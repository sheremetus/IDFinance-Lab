package com.kirillsheremet.cryptowatch.service;

import com.kirillsheremet.cryptowatch.dao.CoinDAO;
import com.kirillsheremet.cryptowatch.entity.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class CoinServiceImpl implements CoinService {
    @Autowired
    private CoinDAO coinDAO;

    @Override
    @Transactional
    public List<Coin> getAllCoins() {
        return coinDAO.getAllCoins();
    }

    @Override
    @Transactional
    public Coin getCoin(int id) {
        return coinDAO.getCoin(id);
    }

    @Override
    @Transactional
    public void updateCoinPrice(double price, int id) {
        coinDAO.updateCoinPrice(price, id);
    }

    @Override
    @Transactional
    public double getCoinPrice(int id) {
      return coinDAO.getCoinPrice(id);
    }

}
