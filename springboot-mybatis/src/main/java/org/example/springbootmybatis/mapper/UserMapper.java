package org.example.springbootmybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springbootmybatis.domain.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from t_user")
    public List<User> findAll();
}
