package com.kirillsheremet.cryptowatch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity

public class CoinJson  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String symbol;
    private String name;
    private String nameid;
    private int rank;
    private double price_usd;
    private double percent_change_24h;
    private double percent_change_1h;
    private double percent_change_7d;
    private double market_cap_usd;
    private double volume24;
    private double volume24_native;
    private double csupply;
    private double price_btc;
    private int tsupply;
    private int msupply;

    public CoinJson() {
    }

    public CoinJson(int id, String symbol, String name, String nameid, int rank, double price_usd, double percent_change_24h, double percent_change_1h, double percent_change_7d, double market_cap_usd, double volume24, double volume24_native, double csupply, double price_btc, int tsupply, int msupply) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.nameid = nameid;
        this.rank = rank;
        this.price_usd = price_usd;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_7d = percent_change_7d;
        this.market_cap_usd = market_cap_usd;
        this.volume24 = volume24;
        this.volume24_native = volume24_native;
        this.csupply = csupply;
        this.price_btc = price_btc;
        this.tsupply = tsupply;
        this.msupply = msupply;
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
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameid() {
        return nameid;
    }

    public void setNameid(String nameid) {
        this.nameid = nameid;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(double price_usd) {
        this.price_usd = price_usd;
    }

    public double getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public double getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public double getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public double getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(double market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public double getVolume24() {
        return volume24;
    }

    public void setVolume24(double volume24) {
        this.volume24 = volume24;
    }

    public double getVolume24_native() {
        return volume24_native;
    }

    public void setVolume24_native(double volume24_native) {
        this.volume24_native = volume24_native;
    }

    public double getCsupply() {
        return csupply;
    }

    public void setCsupply(double csupply) {
        this.csupply = csupply;
    }

    public double getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(double price_btc) {
        this.price_btc = price_btc;
    }

    public int getTsupply() {
        return tsupply;
    }

    public void setTsupply(int tsupply) {
        this.tsupply = tsupply;
    }

    public int getMsupply() {
        return msupply;
    }

    public void setMsupply(int msupply) {
        this.msupply = msupply;
    }

    @Override
    public String toString() {
        return "CoinJson{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", nameid='" + nameid + '\'' +
                ", rank=" + rank +
                ", price_usd=" + price_usd +
                ", percent_change_24h=" + percent_change_24h +
                ", percent_change_1h=" + percent_change_1h +
                ", percent_change_7d=" + percent_change_7d +
                ", market_cap_usd=" + market_cap_usd +
                ", volume24=" + volume24 +
                ", volume24_native=" + volume24_native +
                ", csupply=" + csupply +
                ", price_btc=" + price_btc +
                ", tsupply=" + tsupply +
                ", msupply=" + msupply +
                '}';
    }
}
