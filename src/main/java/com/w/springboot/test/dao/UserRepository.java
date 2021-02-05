package com.w.springboot.test.dao;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.w.springboot.test.entity.User;

@Repository
@Table(name="user")
@Qualifier("userRepository")
public interface UserRepository extends CrudRepository<User, Long > {

    public User findOne(Long id);

   // public User save(User u);

    @Query("select t from User t where t.userName=:name")
    public User findUserByName(String name);
}