package com.alacriti.officespace.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.alacriti.officespace.vo.UpdateAvailabilityVo;
import com.alacriti.officespace.vo.UpdateCapacityVo;

public class CheckDao {

	public static boolean addRemoveCheck(Connection connection, UpdateAvailabilityVo updateAvailability) {
		
		Statement st = null;
		ResultSet rs = null;
		int itemId = updateAvailability.getItemId();
		int capacity = ItemDao.getCapacity(connection, itemId);
		int availableItems = ItemDao.getAvailableItems(connection, itemId);
		int updateAmount = updateAvailability.getUpdateAmount();
		String action = updateAvailability.getUpdateAction();
		
			if(action.equals("add")){
				if( (availableItems+updateAmount)<capacity){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				if( (availableItems-updateAmount)<0 ){
					return false;
				}
				else{
					return true;
				}
			}
		}


	public static boolean capacityCheck(Connection connection, UpdateCapacityVo updateCapacity) {

		Statement st = null;
		ResultSet rs = null;
		int itemId = updateCapacity.getItemId();
		int capacity = updateCapacity.getNewCapacity();
		int availableItems = ItemDao.getAvailableItems(connection, itemId);
		
		if(capacity>0 && capacity>availableItems){
			return true;
		}
		else{
			return false;
		}
		
	}
	
}
