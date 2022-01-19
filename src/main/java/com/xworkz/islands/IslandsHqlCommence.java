package com.xworkz.islands;

import com.xworkz.islands.dao.IslandsHqlDao;
import com.xworkz.islands.dao.IslandsHqlDaoImpl;
import com.xworkz.islands.dto.IslandsHqlDto;

public class IslandsHqlCommence {

	public static void main(String[] args) {
		
		IslandsHqlDto dto = new IslandsHqlDto(5, "Pamban Island", "Tamilnadu");
		
		IslandsHqlDao dao = new IslandsHqlDaoImpl();
		
		//System.out.println(dao.createIsland(dto));
		//System.out.println(dao.getIslandByName("Panban Island"));
		//System.out.println(dao.deleteIslandByLocation("Tamilnadu"));
		//System.out.println(dao.updateIslandNameByLocation("Tamilnadu", "Panban Island"));
		System.out.println(dao.getAllIslands());
	}
}
