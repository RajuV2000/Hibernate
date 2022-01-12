package com.xworkz.xworkzApp.islands;

import com.xworkz.xworkzApp.islands.dao.IslandsDao;
import com.xworkz.xworkzApp.islands.dao.IslandsDaoImpl;
import com.xworkz.xworkzApp.islands.dto.IslandDto;

public class IslandCommence {

	public static void main(String[] args) {
		
		IslandDto dto = new IslandDto(2, "Swaraj Dweep", "Andaman Islands");
		
		IslandsDao dao = new IslandsDaoImpl();
		
		//System.out.println(dao.createIsland(dto));
		
		//System.out.println(dao.deleteIslandById(2));
		
		System.out.println(dao.updateIslandNameById(2, "Swaraj Dweep"));
		
		System.out.println(dao.getIslandById(2));
	}
}
