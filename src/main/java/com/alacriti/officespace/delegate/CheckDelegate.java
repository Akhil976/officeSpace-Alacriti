package com.alacriti.officespace.delegate;

import java.sql.Connection;

import com.alacriti.officespace.bo.impl.CheckBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.UpdateAvailabilityVo;
import com.alacriti.officespace.vo.UpdateCapacityVo;

public class CheckDelegate {
	static Connection connection = DbConnection.getConnection();
	public static boolean addRemoveCheck(UpdateAvailabilityVo updateAvailability) {
		return CheckBo.addRemoveCheck(connection,updateAvailability);
	}

	public static boolean capacityCheck(UpdateCapacityVo updateCapacity) {
		return CheckBo.capacityCheck(connection,updateCapacity);
	}
	
}
