package com.kirillsheremet.cryptowatch.dao;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.kirillsheremet.cryptowatch.entity.Coin;
import com.kirillsheremet.cryptowatch.entity.UserNotify;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.net.*;
import java.nio.charset.*;

import org.json.*;
import org.json.*;

import javax.persistence.Query;
import java.net.*;
import java.nio.charset.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@Repository
public class CoinDAOImpl implements CoinDAO  {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Coin> getAllCoins() {
        Session session = sessionFactory.getCurrentSession();
        List<Coin> allCoins = session
                // не обращать внимание на подчеркивание :)
                .createQuery("from Coin", Coin.class)
                .getResultList();
        return allCoins;
    }

    @Override
    public Coin getCoin(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Coin.class, id);
    }

    @Override
    public  void updateCoinPrice(double price, int id) {
        Session session = sessionFactory.getCurrentSession();

        Coin coin= (Coin) session.load(Coin.class, id);
        coin.setPrice(price);
        session.update(coin);


    }

    @Override
    public void notifyUser(String username, int id, double actualPrice) {
        Session session = sessionFactory.getCurrentSession();
        session.save(new UserNotify(username, id, actualPrice));

    }




}
