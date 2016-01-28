package com.lib.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lib.mysql.book.BookMySqlDao;
import com.lib.mysql.user.UserMysqlDao;

@Component
public class FacadeMySqlDao {

    @Resource(name = "UserMysqlDao")
    private UserMysqlDao userMysqlDao;

    public UserMysqlDao getUserMysqlDao() {
        return userMysqlDao;
    }

    public void setUserMysqlDao(UserMysqlDao userMysqlDao) {
        this.userMysqlDao = userMysqlDao;
    }
    
    @Resource(name="BookMySqlDao")
    private BookMySqlDao bookMySqlDao;

    public BookMySqlDao getBookMySqlDao() {
        return bookMySqlDao;
    }

    public void setBookMySqlDao(BookMySqlDao bookMySqlDao) {
        this.bookMySqlDao = bookMySqlDao;
    }
    
    
}
