//Edit Inventory
$("#doUpdateInventory").click(function(){
	var updateAction = $("#updateAction").val();
	if(updateAction=="add" || updateAction =="remove"){
		var updateAmount = $("#updateNumber").val();
	    $.ajax({
	    	type: "POST",
			url: "http://localhost:8080/OfficeSpace/web/update/availability/"+categoryId+"/"+itemId+"/"+updateAmount+"/"+updateAction,
			success: function(result){
	    		alert(result);
	    	}
	    });
	}
	else{
		alert("Select Action");
	}
});
$("#doUpdateCapaciry").click(function(){
	var updateCapacity = $("#updateCapacity").val();
	var updateAmount = $("#updateNumber").val();
    $.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/update/capacity/"+categoryId+"/"+itemId+"/"+updateCapacity,
		success: function(result){
    		alert(result);
    	}
    });
});
$("#doAddItem").click(function(){
	var category = $("#category").val();
	var selectedCategotyId=0;
	var newItemName = $("#addItem").val();
	var maxCapacity = $("#maxCapacity").val();
	if(category=="stationary") selectedCategotyId=1;
	else if(category=="cleaning") selectedCategotyId=2;
	else if(category=="pantry") selectedCategotyId=3;
	else if(category=="system") selectedCategotyId=4;
	$.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/update/addItem/"+selectedCategotyId+"/"+newItemName+"/"+maxCapacity,
		success: function(result){
    		alert(result);
    	}
    });
});
