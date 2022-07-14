package com.kirillsheremet.cryptowatch.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kirillsheremet.cryptowatch.entity.Coin;
import com.kirillsheremet.cryptowatch.entity.CoinJson;
import com.kirillsheremet.cryptowatch.exception_handling.CoinIncorrectData;
import com.kirillsheremet.cryptowatch.exception_handling.NoSuchCoinException;
import com.kirillsheremet.cryptowatch.service.CoinService;
import com.kirillsheremet.cryptowatch.service.CoinServiceImpl;
import com.kirillsheremet.cryptowatch.timerTask.NotifyToServer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class CryptoController {

    @Autowired
    private CoinService coinService;
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
        coinService.notifyUser(username, id);


        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new NotifyToServer(), 0, 1, TimeUnit.MINUTES);
    }

    @GetMapping("https://api.coinlore.net/api/ticker{id}")
    public void getCurrentPrice(@PathVariable int id) {

    }

    @ExceptionHandler
    public ResponseEntity<CoinIncorrectData> handleException(NoSuchCoinException exception) {
        CoinIncorrectData data = new CoinIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }


}
