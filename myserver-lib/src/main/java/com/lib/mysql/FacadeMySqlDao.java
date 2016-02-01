package com.lib.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class FacadeMySqlDao {

    @Resource(name = "UserMysqlDao")
    private UserMysqlDao userMysqlDao;

    @Resource(name = "BookMySqlDao")
    private BookMySqlDao bookMySqlDao;

    public UserMysqlDao getUserMysqlDao() {
        return userMysqlDao;
    }

    public void setUserMysqlDao(UserMysqlDao userMysqlDao) {
        this.userMysqlDao = userMysqlDao;
    }

    public BookMySqlDao getBookMySqlDao() {
        return bookMySqlDao;
    }

    public void setBookMySqlDao(BookMySqlDao bookMySqlDao) {
        this.bookMySqlDao = bookMySqlDao;
    }

}
