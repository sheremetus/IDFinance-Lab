package com.kirillsheremet.cryptowatch.service;

import com.kirillsheremet.cryptowatch.entity.Coin;

import java.util.List;

public interface CoinService {
    public List<Coin> getAllCoins();

    public Coin getCoin(int id);

    public void notifyUser(String username, int id);

}
