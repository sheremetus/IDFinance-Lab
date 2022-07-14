package com.kirillsheremet.cryptowatch.dao;

import com.kirillsheremet.cryptowatch.entity.Coin;
import com.kirillsheremet.cryptowatch.entity.UserNotify;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserNotifyDAOImpl implements UserNotifyDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int notifyUser(String username, int id, double actualPrice) {
        Session session = sessionFactory.getCurrentSession();
        UserNotify userNotify = new UserNotify(username, id, actualPrice);
        session.save(new UserNotify(username, id, actualPrice));
        return userNotify.getId();
    }


}
