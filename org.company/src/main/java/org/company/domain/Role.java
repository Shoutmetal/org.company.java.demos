package org.company.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Table(name="role")
@Component
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Name;
	private boolean Status;
	
	public Role()
	{
		Users = new HashSet<User>();
		
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "Roles")
	
	private Set<User> Users;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public Set<User> getUsers() {
		return Users;
	}
	public void setUsers(Set<User> users) {
		Users = users;
	}

}
