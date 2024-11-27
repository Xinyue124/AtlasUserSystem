package com.mybatis.springboot.controller;

import com.mybatis.springboot.dto.BaseResponse;
import com.mybatis.springboot.pojo.User;
import com.mybatis.springboot.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xinyuezhang
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Return all user information
     */
    @GetMapping("/user")
    public void getUser() {
        List<User> list = userService.getUserList(new User());
        for (User user : list) {
            System.out.println(user.toString());
        }
    }

    /**
     * Add Users
     *
     * @param name
     * @param age
     */
    @GetMapping("/api/insert")
    public void save(@RequestParam String name, @RequestParam Integer age) {
        userService.insert(name, age);
    }

    /**
     * Batch Add
     *
     * @param users
     */
    @GetMapping("/api/insertMany")
    public void saveUsers(@RequestBody List<User> users) {
        userService.saveUsers(users);
    }

    /**
     * Automatically add bulk users
     */
    @GetMapping("/api/insertUsers")
    public void insertUsers() {
        userService.insertUsers();
    }

    /**
     * Delete a User
     *
     * @param id
     */
    @GetMapping("/api/delete")
    public void delete(@RequestParam int id) {
        userService.delete(id);
    }

    /**
     * batch delete
     *
     * @param ids
     */
    @GetMapping("/api/deleteIds")
    public void deleteIds(@RequestBody List<Long> ids) {
        userService.deleteByIds(ids);
    }

    /**
     * Query by primary key
     *
     * @param id
     * @return
     */
    @GetMapping("/api/selectById")
    public User findById(@RequestParam Integer id) throws Exception {
        try {
            User a = userService.selectById(id);
            return new BaseResponse<>(a).getData();
        } catch (Exception ex) {
            return new BaseResponse<User>(ex.getMessage()).getData();
        }
    }

    /**
     * Search by name
     *
     * @param name
     * @return
     */
    @GetMapping("/api/selectByName")
    public List<User> findByName(@RequestParam String name) {
        return userService.selectByName(name);
    }

    @GetMapping("/api/findByAge")
    public List<User> findByAge(@RequestParam int age){
return userService.selectByAge(age);
    }
    /**
     * Fuzzy search by name
     *
     * @param name
     * @return
     */
    @GetMapping("/api/selectByLikeName")
    public List<User> selectByLikeName(@RequestParam String name) {
        return userService.selectByLikeName(name);
    }

    /**
     *  Update user information
     *
     * @param id
     * @param name
     * @param age
     */
    @GetMapping("/api/update")
    public void updateUser(@RequestParam Integer id, @RequestParam String name,
                           @RequestParam Integer age) {
        userService.updateUser(id, name, age);
    }

    /**
     * Batch update of users
     *
     * @param users
     */
    @GetMapping("/api/updateUsers")
    void updateUsers(@RequestBody List<User> users) {
        userService.updateUsers(users);
    }
}
