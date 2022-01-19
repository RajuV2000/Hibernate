package com.xworkz.islands.dao;

import java.util.List;

import com.xworkz.islands.dto.IslandsHqlDto;

public interface IslandsHqlDao {

	public boolean createIsland(IslandsHqlDto dto);
	
	public boolean deleteIslandByLocation(String loc);
	
	public boolean updateIslandNameByLocation(String loc, String name);
	
	public IslandsHqlDto getIslandByName(String name);
	
	public List<IslandsHqlDto> getAllIslands();
}
