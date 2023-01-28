package com.userAdimnstration.userAdimnstration.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;




@Entity
@Table(name = "users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;


	@Column(name = "email")
	@Email
	private String email;

	@Size(max = 40)
	@Column(name = "full_name")
	private String fullName;


	@Size(max = 60)
	@Column(name = "password")
	private String password;

	@Transient
	List<Integer> privilagesIds;


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_privileges", joinColumns = {@JoinColumn(name = "email")}, inverseJoinColumns = @JoinColumn(name = "privilege_id"))
	private Set<Privileges> privileges = new HashSet<>();
	
	public User() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Privileges> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privileges> privileges) {
		this.privileges = privileges;
	}

	public List<Integer> getPrivilagesIds() {
		return privilagesIds;
	}

	public void setPrivilagesIds(List<Integer> privilagesIds) {
		this.privilagesIds = privilagesIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}