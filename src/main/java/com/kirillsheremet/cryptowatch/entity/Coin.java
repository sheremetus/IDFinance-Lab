package com.kirillsheremet.cryptowatch.entity;

import com.kirillsheremet.cryptowatch.dao.CoinDAOImpl;

import javax.persistence.*;
import javax.swing.*;
import java.util.Objects;

@Entity
@Table(name = "coin")
public class Coin  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "price")
    private double price;

    public Coin() {

    }

    public Coin(int id, String symbol, int price) {
        this.id = id;
        symbol = symbol;
        this.price = price;
    }

    public Coin(int id, String symbol) {
        this.id = id;
        symbol = symbol;
    }

    public Coin(int id,  double price) {
        this.id = id;
        this.price = price;
    }

    public Coin(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return id == coin.id && price == coin.price && Objects.equals(symbol, coin.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, price);
    }

    @Override
    public String toString() {
        return Coin.class.getName() + "{" +
                "id=" + id +
                ", Symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }
}
