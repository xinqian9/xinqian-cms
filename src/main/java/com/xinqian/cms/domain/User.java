package com.xinqian.cms.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.xinqian.cms.domain.enums.Gender;



public class User implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -8703527821090055176L;
	private Integer id;
	private String username;
	private String password;
	private String nickname;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date birthday;
	private Gender gender;
	private Integer locked;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date created;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date updated;
	private Integer role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String username, String password, String nickname, Date birthday, Gender gender,
			Integer locked, Date created, Date updated, Integer role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.birthday = birthday;
		this.gender = gender;
		this.locked = locked;
		this.created = created;
		this.updated = updated;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", birthday=" + birthday + ", gender=" + gender + ", locked=" + locked + ", created=" + created
				+ ", updated=" + updated + ", role=" + role + "]";
	}
	

	
	
}
