package com.alacriti.officespace.resource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import com.alacriti.officespace.delegate.ItemsMenuDelegate;
import com.alacriti.officespace.delegate.UpdateInventoryDelegate;
import com.alacriti.officespace.util.GenerateFtlResponse;
import com.alacriti.officespace.vo.AddItemVo;
import com.alacriti.officespace.vo.CategoryVo;
import com.alacriti.officespace.vo.ItemMenuResponseVo;
import com.alacriti.officespace.vo.ItemsListVo;
import com.alacriti.officespace.vo.ResponseVo;
import com.alacriti.officespace.vo.UpdateAvailabilityVo;
import com.alacriti.officespace.vo.UpdateCapacityVo;

import freemarker.template.TemplateException;

@Path("/update")
public class UpdateInventoryResource {
	@GET
	public String check(){
		return "abc";
	}
	
	@POST
	@Path("availability/{categoryId}/{itemId}/{updateAmount}/{updateAction}")
	public String doUpdateAvailability(
			@PathParam("categoryId") int categoryId,
			@PathParam("itemId") int itemId,
			@PathParam("updateAmount") int updateAmount,
			@PathParam("updateAction") String updateAction,
			@Context HttpServletRequest request              ){
		System.out.println("update resource");
		UpdateAvailabilityVo updateAvailability = new UpdateAvailabilityVo();
		updateAvailability.setCategoryId(categoryId);
		updateAvailability.setItemId(itemId);
		updateAvailability.setUpdateAction(updateAction);
		updateAvailability.setUpdateAmount(updateAmount);
		System.out.println(updateAvailability.toString());
		
		CheckResource checkResource = new CheckResource();
		boolean check = checkResource.addRemoveCheck(updateAvailability);
			
		if(check == true){
			ResponseVo responseVo =  UpdateInventoryDelegate.doUpdateAvailability(updateAvailability);
			
			if(responseVo.isSuccess()==true){
				return "successfully updated";
				}
		}	
		else{
			if(updateAvailability.getUpdateAction().equals("add")){
				return "No capacity to store";
			}
			else{
				return "Available items are low.";
			}
			
		}
		return "something wrong: updateInventory Resource.";
	}		
	
	@POST	
	@Path("capacity/{categoryId}/{itemId}/{updateCapacity}")
	public String doUpdateCapacity(
			@PathParam("categoryId") int categoryId,
			@PathParam("itemId") int itemId,
			@PathParam("updateCapacity") int newCapacity,
			@Context HttpServletRequest request            ){
		
		UpdateCapacityVo updateCapacity = new UpdateCapacityVo();
		updateCapacity.setCategoryId(categoryId);
		updateCapacity.setItemId(itemId);
		updateCapacity.setNewCapacity(newCapacity);
		
		CheckResource checkResource = new CheckResource();
		boolean check = checkResource.capacityCheck(updateCapacity);
		if(check == true){
			ResponseVo responseVo = new ResponseVo();
			responseVo = UpdateInventoryDelegate.doUpdateCapacity(updateCapacity);
			
			String ftlCode="Something wrong: update Inventory resource";
			
			if(responseVo.isSuccess()==true){
				return "Successfully Updated";
			}
			else{
				return "Something gone wrong, Not updated.";
			}
		}
		else{
			return "Capacity Should be grather than ZERO and AVILABLE ITEMS.";
		}
				
	}
	@POST
	@Path("addCategory/{newCategoryName}")
	public String addCategory(
			@PathParam("newCategoryName") String newCategoryName
			){
		ResponseVo responseVo = UpdateInventoryDelegate.addCategory(newCategoryName);
		System.out.println(responseVo);
		if(responseVo.isSuccess()==true){
			return "Successfully Added, Add items to view in menu List";
		}
		else{
			return "Something gone wrong";
		}
	}
	@POST
	@Path("addItem/{categoryId}/{newItem}/{maxCapacity}")
	public String doAddItem(
			@PathParam("categoryId") int categoryId,
			@PathParam("newItem") String newItem,
			@PathParam("maxCapacity") int maxCapacity
			){
		AddItemVo addItem = new AddItemVo();
		addItem.setCategoryId(categoryId);
		addItem.setNewItem(newItem);
		addItem.setMaxCapacity(maxCapacity);
		UpdateInventoryDelegate.doAddItem(addItem);
		ItemMenuResponseVo itemsMenuResponseVo =  ItemsMenuDelegate.getMenu();
		return GenerateFtlResponse.getSideMenu(itemsMenuResponseVo);
	}
	@POST
	@Path("deleteCategory/{categoryId}")
	public String deleteCategory(
			@PathParam("categoryId") int categoryId
			){
		
		ResponseVo responseVo = UpdateInventoryDelegate.deleteCategory(categoryId);
		System.out.println(responseVo);
		if(responseVo.isSuccess()==true){
			
			ItemMenuResponseVo itemsMenuResponseVo =  ItemsMenuDelegate.getMenu();
			return GenerateFtlResponse.getSideMenu(itemsMenuResponseVo);
			
		}
		else{
			return "Something gone wrong";
		}
		
	}

	@POST
	@Path("deleteItem/{categoryId}/{itemId}")
	public String deleteItem(
			@PathParam("categoryId") int categoryId,
			@PathParam("itemId") int itemId
			){
			
		ResponseVo responseVo = UpdateInventoryDelegate.deleteItem(itemId);
		System.out.println(responseVo);
		if(responseVo.isSuccess()==true){
			ItemMenuResponseVo itemsMenuResponseVo =  ItemsMenuDelegate.getMenu();
			return GenerateFtlResponse.getSideMenu(itemsMenuResponseVo);
		}
		else{
			return "Something gone wrong";
		}
	}
	
	@POST
	@Path("ajaxItem/{categoryId}")
	public String ajaxItem(
			@PathParam("categoryId") int categoryId
			){
		ItemsListVo itemsListVo = UpdateInventoryDelegate.ajaxItem(categoryId);
		String ftlCode = GenerateFtlResponse.getItems(itemsListVo);
		return ftlCode;
	}
	
	@POST
	@Path("categoryList")
	public String ajaxCategory(
			){
		ArrayList<CategoryVo> categoryList = UpdateInventoryDelegate.ajaxCategory();
		String ftlCode = GenerateFtlResponse.getCategoryList(categoryList);
		return ftlCode;
	}

}
