package com.userAdimnstration.userAdimnstration.model;

import javax.persistence.*;

@Entity
@Table(name = "privileges")

public class Privileges {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "privilege")
	private String privilege;

	public Privileges(){}

	public Privileges(String privilege) {
		this.privilege = privilege;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
}