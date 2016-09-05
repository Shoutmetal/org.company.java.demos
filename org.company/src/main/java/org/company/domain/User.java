package org.company.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name="user")
@Component
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Username;
	private String Password;
	
	public User()
	{
		Roles = new HashSet<Role>();
		
	}
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", 
	joinColumns = { @JoinColumn(name = "UserId") },
	inverseJoinColumns = { @JoinColumn(name = "RoleId") })
	private Set<Role> Roles;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Set<Role> getRoles() {
		return Roles;
	}
	public void setRoles(Set<Role> roles) {
		Roles = roles;
	}

}
