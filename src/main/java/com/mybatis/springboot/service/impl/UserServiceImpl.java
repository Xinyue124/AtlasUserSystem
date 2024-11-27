package com.mybatis.springboot.service.impl;

import com.mybatis.springboot.mapper.UserMapper;
import com.mybatis.springboot.pojo.User;
import com.mybatis.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinyuezhang
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList(User user) {
        return userMapper.getUserList(user);
    }

    @Override
    public void insert(String name, Integer age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        userMapper.insert(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        userMapper.deleteByIds(ids);
    }

    @Override
    public User selectById(Integer id) throws Exception {
        User user = new User();
        user.setId(id);
        if(user.getId().equals(id)){
            return (User) userMapper.getOne(user);
        }
        throw new Exception("不存在此人！");
    }

    @Override
    public void updateUser(Integer id, String name, Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        userMapper.update(user);
    }

    @Override
    public void insertUsers() {
        List<User> userList = new ArrayList<>();
        User user;
        for (int i = 0; i < 100; i++){
            user = new User();
            user.setName("name"+i);
            user.setAge(i);
            userList.add(user);
        }
        userMapper.insertUsers(userList);
    }

    @Override
    public void updateUsers(List<User> users) {
        userMapper.updateUsers(users);
    }

    @Override
    public void saveUsers(List<User> users) {
        userMapper.saveUsers(users);
    }

    @Override
    public List<User> selectByName(String name) {
        User user = new User();
        user.setName(name);
        return userMapper.getByName(name);
    }

    @Override
    public List<User> selectByLikeName(String name) {
        User user = new User();
        user.setName(name);
        List<User> userList = userMapper.getByLikeName(name);
        return userList;
    }

    @Override
    public List<User> selectByAge(int age) {
        User user = new User();
        user.setAge(age);
        List<User> userList = userMapper.getByAge(age);
        return userList;
    }
}
