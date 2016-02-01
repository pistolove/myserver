package com.lib.mysql;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.lib.mysql.user.UserInfoMySqlTable;

@Component(value = "UserMysqlDao")
public interface UserMysqlDao {

    public UserInfoMySqlTable getUseInfoById(@Param(value = "id") String id);

}
