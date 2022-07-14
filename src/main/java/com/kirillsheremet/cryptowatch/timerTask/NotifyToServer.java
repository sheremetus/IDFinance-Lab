package com.kirillsheremet.cryptowatch.timerTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirillsheremet.cryptowatch.entity.CoinJson;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class NotifyToServer implements Runnable {

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void run() {
        CoinJson[] coinJson = restTemplate.getForObject("https://api.coinlore.net/api/ticker/?id=90", CoinJson[].class);
        System.out.println(Arrays.toString(coinJson));
    }

}

