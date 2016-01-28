package com.lib.mysql.book;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.lib.mysql.book.table.BookMySqlTable;

@Component
public interface BookMySqlDao {

    public BookMySqlTable getBookById(@Param(value="id") String id);

}
