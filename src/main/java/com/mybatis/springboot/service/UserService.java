package com.mybatis.springboot.service;

import com.mybatis.springboot.pojo.User;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

public interface UserService {

    List<User> getUserList(User user);

    void insert(String name, Integer age);

    void delete(Integer id);

    void deleteByIds(List<Long> ids);

    User selectById(Integer id)throws Exception;

    void updateUser(Integer id, String name, Integer age);

    void insertUsers();

    void updateUsers(List<User> user);

    void saveUsers(List<User> users);

    List<User> selectByName(String name);

    List<User> selectByLikeName(String name);

    List<User> selectByAge(int age);
}
