package com.alacriti.officespace.bo;

import java.sql.Connection;

import com.alacriti.officespace.dao.CheckDao;
import com.alacriti.officespace.vo.UpdateAvailabilityVo;
import com.alacriti.officespace.vo.UpdateCapacityVo;

public class CheckBo {

	public static boolean addRemoveCheck(Connection connection, UpdateAvailabilityVo updateAvailability) {
		return CheckDao.addRemoveCheck(connection,updateAvailability);
	}

	public static boolean capacityCheck(Connection connection, UpdateCapacityVo updateCapacity) {
		return CheckDao.capacityCheck(connection,updateCapacity);
	}
	
}
