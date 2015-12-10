package com.lib.mysql.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.lib.mysql.user.table.UserInfoMySqlTable;

@Component
public interface UserMysqlDao {
    public UserInfoMySqlTable getUseInfoById(@Param(value = "uid") String uid);

    public void deleteUserById(@Param(value = "uid") String uid);

    public UserInfoMySqlTable updateUserInfo(
            @Param(value = "uname") String uname,
            @Param(value = "uinfo") String uinfo,
            @Param(value = "email") String email,
            @Param(value = "telephone") Long telephone);

    public UserInfoMySqlTable registerUser(
            @Param(value = "uname") String uname,
            @Param(value = "uinfo") String uinfo,
            @Param(value = "email") String email,
            @Param(value = "telephone") Long telephone,
            @Param(value = "secret") String secret);

}
