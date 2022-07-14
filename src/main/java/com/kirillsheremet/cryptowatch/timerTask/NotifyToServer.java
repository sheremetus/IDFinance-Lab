package com.kirillsheremet.cryptowatch.timerTask;

import com.fasterxml.jackson.databind.ObjectMapper;
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

public class NotifyToServer implements Runnable {

    private RestTemplate restTemplate = new RestTemplate();
    private int cryptoId;

    private CoinService coinService;


    public NotifyToServer(int cryptoId, CoinService coinService) {
        this.cryptoId = cryptoId;
        this.coinService = coinService;
    }

    @Override
    public void run() {
        CoinJson[] coinJson = restTemplate.getForObject("https://api.coinlore.net/api/ticker/?id=" + cryptoId, CoinJson[].class);
        System.out.println(Arrays.toString(coinJson));
        coinService.updateCoinPrice(coinJson[0].getPrice_usd(), cryptoId);

    }

    public double getCurrentPrice() {
        CoinJson[] coinJson = restTemplate.getForObject("https://api.coinlore.net/api/ticker/?id=" + cryptoId, CoinJson[].class);
        return coinJson[0].getPrice_usd();
    }


}

