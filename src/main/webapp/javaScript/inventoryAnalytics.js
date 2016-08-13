$('#analyticsBy').change(function() {
	    if($(this).val()=="day"){
	    	var htmlData='<input type="date" id="alalyticsCal">';
	    	$("#calBox").empty().append(htmlData);
	    }
	    if($(this).val()=="week"){
	    	var htmlData='<input type="week" id="alalyticsCal">';
	    	$("#calBox").empty().append(htmlData);
	    }
	    if($(this).val()=="month"){
	    	var htmlData='<input type="month" id="alalyticsCal">';
	    	$("#calBox").empty().append(htmlData);
	    }
	    if($(this).val()=="year"){
	    	var htmlData='<input type="number" id="alalyticsCal">';
	    	$("#calBox").empty().append(htmlData);
	    }
	});

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