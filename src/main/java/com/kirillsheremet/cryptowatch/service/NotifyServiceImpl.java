package com.kirillsheremet.cryptowatch.service;

import com.kirillsheremet.cryptowatch.dao.CoinDAO;
import com.kirillsheremet.cryptowatch.dao.UserNotifyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private UserNotifyDAO userNotifyDAO;

    @Override
    @Transactional
    public int notifyUser(String username, int id, double actualPrice) {
        return userNotifyDAO.notifyUser(username, id, actualPrice);
    }



}
