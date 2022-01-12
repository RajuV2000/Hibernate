package com.xworkz.xworkzApp.islands.dao;

import com.xworkz.xworkzApp.islands.dto.IslandDto;

public interface IslandsDao {

	public boolean createIsland(IslandDto dto);
	
	public boolean deleteIslandById(int id);
	
	public boolean updateIslandNameById(int id, String name);
	
	public IslandDto getIslandById(int id);
}
