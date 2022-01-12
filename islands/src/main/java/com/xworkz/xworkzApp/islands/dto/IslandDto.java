package com.xworkz.xworkzApp.islands.dto;

import javax.persistence.*;

@Entity
@Table(name = "islands", schema = "hibernate")
public class IslandDto {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "loc")
	private String loc;
	
	public IslandDto()
	{
		super();
	}
	
	public IslandDto(int id, String name, String loc) {
		super();
		this.id = id;
		this.name = name;
		this.loc = loc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "IslandDto [id=" + id + ", name=" + name + ", loc=" + loc + "]";
	}
}
