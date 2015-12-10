package com.lib.mysql.user;

import org.springframework.beans.factory.annotation.Autowired;

public class UserFacadeMysqlDao {

    @Autowired(required = false)
    public UserMysqlDao userMysqlDao;

    public UserMysqlDao getUserMysqlDao() {
        return userMysqlDao;
    }
}
