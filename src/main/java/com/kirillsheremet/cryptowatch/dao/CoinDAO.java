package com.kirillsheremet.cryptowatch.dao;

import com.kirillsheremet.cryptowatch.entity.Coin;

import java.util.List;

public interface CoinDAO {

    public List<Coin> getAllCoins();

    public Coin getCoin(int id);

    public void notifyUser(String username, int id, double actualPrice);

}
