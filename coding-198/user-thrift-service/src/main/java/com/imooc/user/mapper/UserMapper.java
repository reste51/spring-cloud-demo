package com.imooc.user.mapper;

import com.imooc.thrift.user.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Michael on 2017/10/28.
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户 id 先查询用户信息
     * @param id
     * @return
     */
    @Select("select id,username, password, real_name as realName," +
            "mobile, email from pe_user where id=#{id}")
    UserInfo getUserById(@Param("id")int id);

    /**
     * 根据用户名 查询用户信息
     * @param username
     * @return
     */
    @Select("select id,username, password, real_name as realName," +
            "mobile, email from pe_user where username=#{username}")
    UserInfo getUserByName(@Param("username")String username);

    /**
     * 注册用户信息
     * @param userInfo
     */
    @Insert("insert into pe_user (username, password, real_name, mobile, email)" +
            "values (#{u.username}, #{u.password}, #{u.realName}, #{u.mobile}, #{u.email})")
    void registerUser(@Param("u") UserInfo userInfo);


    @Select("select u.id,u.username,u.password,u.real_name as realName," +
            "u.mobile,u.email,t.intro,t.stars from pe_user u," +
            "pe_teacher t where u.id=#{id} " +
            "and u.id=t.user_id")
    UserInfo getTeacherById(@Param("id")int id);
}
