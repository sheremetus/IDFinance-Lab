package com.kirillsheremet.cryptowatch.timerTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirillsheremet.cryptowatch.controller.CryptoController;
import com.kirillsheremet.cryptowatch.dao.CoinDAO;
import com.kirillsheremet.cryptowatch.entity.CoinJson;
import com.kirillsheremet.cryptowatch.service.CoinService;
import com.kirillsheremet.cryptowatch.service.CoinServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Math.abs;

public class NotifyToServer implements Runnable {

    private RestTemplate restTemplate = new RestTemplate();
    private int cryptoId;
    double currentPrice;
    private CoinService coinService;
    double percent;
    String username;
    private Logger logger = Logger.getLogger(CryptoController.class.getName());
    ScheduledExecutorService scheduled;

    public NotifyToServer(int cryptoId, CoinService coinService) {
        this.cryptoId = cryptoId;
        this.coinService = coinService;

    }

    public NotifyToServer(int cryptoId, CoinService coinService, double currentPrice, String username, ScheduledExecutorService scheduled) {

        this.cryptoId = cryptoId;
        this.currentPrice = currentPrice;
        this.coinService = coinService;
        this.username = username;
        this.scheduled = scheduled;
    }

    @Override
    public void run() {
        CoinJson[] coinJson = restTemplate.getForObject("https://api.coinlore.net/api/ticker/?id=" + cryptoId, CoinJson[].class);
        System.out.println(Arrays.toString(coinJson));
        coinService.updateCoinPrice(coinJson[0].getPrice_usd(), cryptoId);

        percent = ((abs(currentPrice - coinService.getCoinPrice(cryptoId)) / currentPrice) * 100);
        if (percent >= 1) {
            logger.log(Level.WARNING, "Price of coin ( id=" + cryptoId + ") changed by " + percent + " percent.(" + username + ")");
            scheduled.shutdown();
        }
    }

    public double getCurrentPrice() {
        CoinJson[] coinJson = restTemplate.getForObject("https://api.coinlore.net/api/ticker/?id=" + cryptoId, CoinJson[].class);
        return coinJson[0].getPrice_usd();
    }


}

