package com.w.springboot.test.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rid")
    @GeneratedValue
	private Integer rid;
	private String rname;
	private Set<User> users = new HashSet<>();
	private Set<Module> modules = new HashSet<>();
	/**
	 * @return the rid
	 */
	public Integer getRid() {
		return rid;
	}
	/**
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	/**
	 * @return the rname
	 */
	public String getRname() {
		return rname;
	}
	/**
	 * @param rname the rname to set
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}
	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	/**
	 * @return the modules
	 */
	public Set<Module> getModules() {
		return modules;
	}
	/**
	 * @param modules the modules to set
	 */
	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}
	
	
}
