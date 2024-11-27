package com.mybatis.springboot.mapper;

import com.mybatis.springboot.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xinyuezhang
 */
@Mapper
public interface UserMapper {
    /**
     * Return all user information
     *
     * @param user
     * @return
     */
    List<User> getUserList(User user);

    /**
     * add user
     *
     * @param user
     */
    void insert(User user);

    /**
     * batch add
     *
     * @param users
     */
    void saveUsers(List<User> users);

    /**
     * auto add 100 user
     *
     * @param userList
     * @return
     */
    Integer insertUsers(List<User> userList);

    /**
     * delete a user
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * batch delete
     *
     * @param ids
     * @return
     */
    int deleteByIds(List<Long> ids);

    /**
     * search through key
     *
     * @param user
     * @return
     */
    List<User> getOne(User user);

    /**
     * search by name
     *
     * @param name
     * @return
     */
    List<User> getByName(String name);

    /**
     * search by name contain
     *
     * @param name
     * @return
     */
    List<User> getByLikeName(String name);

    /**
     * search by age
     *
     * @param age
     * @return
     */
    List<User> getByAge(int age);

    /**
     * update user information
     *
     * @param user
     */
    void update(User user);

    /**
     * batch update
     *
     * @param users
     * @return
     */
    int updateUsers(List<User> users);
}
