package com.w.springboot.framework.db;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w.springboot.test.entity.User;

public interface DbClient extends JpaRepository<User, Serializable>  {

}
