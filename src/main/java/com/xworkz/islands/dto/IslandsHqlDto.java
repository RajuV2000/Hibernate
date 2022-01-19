package com.xworkz.islands.dto;

import javax.persistence.*;

@Entity
@Table(name = "islands", schema = "hibernate")
public class IslandsHqlDto {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "loc")
	private String location;

	public IslandsHqlDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IslandsHqlDto(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	@Override
	public String toString() {
		return "IslandsHqlDto [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
}
