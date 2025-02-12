package com.example.patientmange.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.patientmange.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
//    //查询所有用户
//    @Select("select * from User")
//    public List<User> find();
//
//    //增加一个用户
//    @Insert("insert into User values(#{id},#{username},#{number},#{address},#{brithday})")
//    public int add(User user);
//
//    //修改一个用户
//    @Update("update User set username=#{username},number=#{number},address=#{address},brithday=#{brithday} where id = #{id}")
//    public int update(User user);
//
//    //删除一个用户
//    @Delete("delete from user where id ={#id}")
//    public int delete(int id);
//
//    //查询特定用户
//    @Select("select * from User where id = {#id}")
//    public User findById(int id);
}
