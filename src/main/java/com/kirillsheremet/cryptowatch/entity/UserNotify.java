package com.kirillsheremet.cryptowatch.entity;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "user_notify")
public class UserNotify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "coin_id")
    private int coinId;

    public UserNotify() {
    }

    public UserNotify(String username, int coinId) {
        this.username = username;
        this.coinId = coinId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCoinId() {
        return coinId;
    }

    public void setCoinId(int coinId) {
        this.coinId = coinId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNotify that = (UserNotify) o;
        return id == that.id && coinId == that.coinId && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, coinId);
    }

    @Override
    public String toString() {
        return UserNotify.class.getName()+
                "id=" + id +
                ", username='" + username + '\'' +
                ", coinId=" + coinId +
                '}';
    }
}
