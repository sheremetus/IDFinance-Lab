package com.kirillsheremet.cryptowatch.controller;

import com.kirillsheremet.cryptowatch.entity.Coin;
import com.kirillsheremet.cryptowatch.exception_handling.CoinIncorrectData;
import com.kirillsheremet.cryptowatch.exception_handling.NoSuchCoinException;
import com.kirillsheremet.cryptowatch.service.CoinService;
import com.kirillsheremet.cryptowatch.service.NotifyService;
import com.kirillsheremet.cryptowatch.timerTask.NotifyToServer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Math.abs;

@RestController
@RequestMapping("/api")
public class CryptoController {

    @Autowired
    private CoinService coinService;

    @Autowired
    private NotifyService notifyService;

    private final String noSuchCoinMessage = " There is no coin in database with ID = ";

    @GetMapping("/coins")
    public List<Coin> showAllCoins() {
        List<Coin> allCoins = coinService.getAllCoins();
        return allCoins;
    }

    @GetMapping("/coins/{id}")
    public Coin getCoin(@PathVariable int id) {
        Coin coin = coinService.getCoin(id);

        if (coin == null) {
            throw new NoSuchCoinException(noSuchCoinMessage + id);
        }

        return coin;

    }

    @GetMapping("/notify/{username}/{id}")
    public void notifyUser(@PathVariable String username, @PathVariable int id) {
        NotifyToServer notify = new NotifyToServer(id, coinService);
        double currentPrice = notify.getCurrentPrice();
        double percent;

        notifyService.notifyUser(username, id, currentPrice);


        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(new NotifyToServer(id, coinService, currentPrice, username, scheduler), 0, 1, TimeUnit.MINUTES);
    }


    @ExceptionHandler
    public ResponseEntity<CoinIncorrectData> handleException(NoSuchCoinException exception) {
        CoinIncorrectData data = new CoinIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }


}
