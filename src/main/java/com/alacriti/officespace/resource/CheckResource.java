package com.alacriti.officespace.resource;

import com.alacriti.officespace.delegate.CheckDelegate;
import com.alacriti.officespace.vo.UpdateAvailabilityVo;
import com.alacriti.officespace.vo.UpdateCapacityVo;

public class CheckResource {
	public boolean addRemoveCheck(UpdateAvailabilityVo updateAvailability){
		return CheckDelegate.addRemoveCheck(updateAvailability);
	}
	public boolean capacityCheck(UpdateCapacityVo updateCapacity){
		return CheckDelegate.capacityCheck(updateCapacity);
	}

}
