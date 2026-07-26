package org.example.springbootmybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.springbootmybatis.domain.User;

import java.util.List;

@Mapper
public interface UserXmlMapper {
    public List<User> findAll();
}
