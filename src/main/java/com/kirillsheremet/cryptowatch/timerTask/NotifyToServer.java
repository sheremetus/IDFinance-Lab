package com.kirillsheremet.cryptowatch.timerTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirillsheremet.cryptowatch.entity.CoinJson;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class NotifyToServer implements Runnable {

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();
    private int cryptoId;
    private static CoinJson coinJson;

    public NotifyToServer(int cryptoId) {
        this.cryptoId = cryptoId;
    }

    @Override
    public void run() {
        CoinJson[] coinJson = restTemplate.getForObject("https://api.coinlore.net/api/ticker/?id=" + cryptoId, CoinJson[].class);
        System.out.println(Arrays.toString(coinJson));

    }

    public double getCurrentPrice() {
        CoinJson[] coinJson = restTemplate.getForObject("https://api.coinlore.net/api/ticker/?id=" + cryptoId, CoinJson[].class);
       return coinJson[0].getPrice_usd();
    }


}

