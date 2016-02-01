package com.lib.mysql;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.lib.mysql.book.BookMySqlTable;

@Component(value = "BookMySqlDao")
public interface BookMySqlDao {

    public BookMySqlTable getBookById(@Param("id") String id);

}
