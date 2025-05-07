package org.example.conference_management.mapper;


import org.apache.ibatis.annotations.*;
import org.example.conference_management.entity.User;

@Mapper
public interface UserMapper {
    @Insert("insert into user values (#{userId} , #{password} , #{email} , #{userName})")
    void insert(User user);

    @Delete("delete from user where user_id = #{userId}")
    void delete(int userId);

    @Update("update user set password = #{password} , email = #{email} , user-name = #{userName} where user_id = #{updateUserId}")
    void update(int updateUserId, User user);

    @Select("select * from user where user_id = #{userId}")
    User select(int userId);
}
