var itemId;
var categoryId;
//Edit Inventory

$(document.body).on('click', ".menuHeader" ,function(){
	
	var catg_id=$(this).attr('id');
	
	$(".sub").slideUp();
	$("."+catg_id+"_sub").slideDown();
	
});

/*$(document.body).on('click', ".select" ,function(){
    $.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/update/categoryList",
		success: function(result){
			$(".categoryList").html(result);
    	}
    });
});*/

$(document.body).on('click', "#logout" ,function(){
	
    $.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/logout",
		success: function(result){
			window.location.href = result;
    	}
    });
	
});

$(document.body).on('click', '#doUpdateInventory' ,function(){
	var updateAction = $("#updateAction").val();
	if(updateAction=="add" || updateAction =="remove"){
		var updateAmount = $("#updateNumber").val();
		$.ajax({
	    	type: "POST",
			url: "http://localhost:8080/OfficeSpace/web/update/availability/"+categoryId+"/"+itemId+"/"+updateAmount+"/"+updateAction,
			success: function(result){
				alert(result);
				ajaxCall();
	    	}
	    });
		
		function ajaxCall(){
		    $.ajax({
		    	type: "POST",
				url: "http://localhost:8080/OfficeSpace/web/item/"+itemId,
				success: function(result){
					$("#container").html(result);
		    	}
		    });
		}
	    
	    $("#innerBar").attr('style', 'background-color : red !important');
	}
	else{
		alert("Select Action");
	}
});
$(document.body).on('click', '#doUpdateCapaciry' ,function(){
	var updateCapacity = $("#updateCapacity").val();
    $.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/update/capacity/"+categoryId+"/"+itemId+"/"+updateCapacity,
		success: function(result){
			alert(result);
    	}
    });
    
    $.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/item/"+itemId,
		success: function(result){
    		$("#container").html(result);
    	}
    });
    
});

$(document.body).on('click', '#addNewCategory' ,function(){
	
	var newCategoryName = $("#newCategory").val();
	$.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/update/addCategory/"+newCategoryName,
		success: function(result){
			alert(result);
				
    	}
    });
});

$(document.body).on('click', '#doAddItem' ,function(){
	
	var newItemName = $("#addItem").val();
	var maxCapacity = $("#maxCapacity").val();
	var selectedCategotyId = $("#category").val();
	/*	if(category=="stationary") selectedCategotyId=1;
	else if(category=="cleaning") selectedCategotyId=2;
	else if(category=="pantry") selectedCategotyId=3;
	else if(category=="system") selectedCategotyId=4;*/
	$.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/update/addItem/"+selectedCategotyId+"/"+newItemName+"/"+maxCapacity,
		success: function(result){
			$("#sideMenu").html(result);
    	}
    });
});

$(document.body).on('click', '#doDeleteCategory' ,function(){
	
	var categoryId = $("#deleteCategory").val();
	$.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/update/deleteCategory/"+categoryId,
		success: function(result){
			alert("Deleted Successfully");
			$("#sideMenu").html(result);ss
    	}
    });
	
    $.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/update/categoryList",
		success: function(result){
			$(".categoryList").html(result);
    	}
    });
	
	
	
});

$(document.body).on('change', '#deleteItemCategory' ,function(){

	var categoryId = $("#deleteItemCategory").val();
	$.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/update/ajaxItem/"+categoryId,
		success: function(result){
    		$("#deleteItemItem").html(result);
    	}
    });
});

$(document.body).on('click', '#doDeleteItem' ,function(){

	var categoryId = $("#deleteItemCategory").val();
	var deleteItemId = $("#deleteItemItem").val();
	$.ajax({
    	type: "POST",
    	url: "http://localhost:8080/OfficeSpace/web/update/deleteItem/"+categoryId+"/"+deleteItemId,
		success: function(result){
			$("#sideMenu").html(result);
    	}
    });

});

$(document.body).on('change', '#analyticsBy' ,function(){
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
$(document.body).on('change', '#paginationBy' ,function(){
    if($(this).val()=="day"){
    	var htmlData='<input type="date" id="paginationCal">';
    	$("#paginationcalBox").empty().append(htmlData);
    }
    if($(this).val()=="week"){
    	var htmlData='<input type="week" id="paginationCal">';
    	$("#paginationcalBox").empty().append(htmlData);
    }
    if($(this).val()=="month"){
    	var htmlData='<input type="month" id="paginationCal">';
    	$("#paginationcalBox").empty().append(htmlData);
    }
    if($(this).val()=="year"){
    	var htmlData='<input type="number" id="paginationCal">';
    	$("#paginationcalBox").empty().append(htmlData);
    }
});
$(document.body).on('click', '#doAnalytics' ,function(){
		var analyticsBy = $("#analyticsBy").val();
		var calValue = $("#alalyticsCal").val();
	    $.ajax({
	    	type: "POST",
			url: "http://localhost:8080/OfficeSpace/web/analytics/"+itemId+"/"+analyticsBy+"/"+calValue,
			success: function(result){
				$("#analytics").html(result);
	    	}
	    });
		
});
$(document.body).on('click', '#doPagination' ,function(){
	var analyticsBy = $("#paginationBy").val();
	var calValue = $("#paginationCal").val();
    $.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/analytics/pagination/"+itemId+"/"+analyticsBy+"/"+calValue,
		success: function(result){
    		$("#analytics").html(result);
    	}
    });
	
});
$(document.body).on('click', '.numberDiv' ,function(){
	var details = $(this).attr("id");
	var detailsList = details.split("_");
	
	$.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/getPagination/"+detailsList[0]+"/"+detailsList[1]+"/"+detailsList[2]+"/"+detailsList[3]+"/"+detailsList[4],
		success: function(result){
    		$("#analytics").html(result);
    	}
    });
	
});



$(document.body).on('change', '#graphAnalyticsBy' ,function(){
    if($(this).val()=="week"){
    	var htmlData='<input type="week" id="graphAnalalyticsCal">';
    	$("#graphCalBox").empty().append(htmlData);
    }
    if($(this).val()=="month"){
    	var htmlData='<input type="month" id="graphAnalalyticsCal">';
    	$("#graphCalBox").empty().append(htmlData);
    }
    if($(this).val()=="year"){
    	var htmlData='<input type="number" id="graphAnalalyticsCal">';
    	$("#graphCalBox").empty().append(htmlData);
    }
});
$(document.body).on('click', '#doGraphAnalytics' ,function(){
	var graphAnalyticsBy = $("#graphAnalyticsBy").val();
	var graphCalValue = $("#graphAnalalyticsCal").val();
	if(graphAnalyticsBy=="week"){
		graphCalValue = graphCalValue.replace("W","");
		calValues=graphCalValue.split("-");
		graphCalValue=getDateOfISOWeek(calValues[1],calValues[0]);
	}
	$.ajax({
    	type: "POST",
		url: "http://localhost:8080/OfficeSpace/web/graphAnalytics/"+itemId+"/"+graphAnalyticsBy+"/"+graphCalValue,
		success: function(result){
    		$("#graph").html(result);
    	}
    });
	clearTimeSpan();
	generateGraph();
});

function getDateOfISOWeek(w, y) {
    var simple = new Date(y, 0, 1 + (w - 1) * 7);
    var dow = simple.getDay();
    var ISOweekStart = simple;
    if (dow <= 4)
        ISOweekStart.setDate(simple.getDate() - simple.getDay() + 1);
    else
        ISOweekStart.setDate(simple.getDate() + 8 - simple.getDay());
    var dateFormat=ISOweekStart.getFullYear()+"-"+ISOweekStart.getMonth()+"-"+ISOweekStart.getDate();
    return dateFormat;
}


//Stationary
	$(document.body).on("click",".menuItem",function(){
		$(".menuItem").css("background-color","#C8C8C8");
		$(this).css("background-color","green");
		var catg_id=$(this).attr('id');
		var catg_idList=catg_id.split("_");
		itemId=catg_idList[1];
		categoryId=catg_idList[0];
		$("#headerItem").text(catg_idList[2]);
		var requestUrl="http://localhost:8080/OfficeSpace/web/item/"+itemId;
		var id= "#"+itemId;
		id=id.replace(/,/g, "");
		
		$.ajax({
	    	type: "POST",
			url: requestUrl,
			success: function(result){
	    		$("#container").empty().append(result);
	    	}
	    });
	});
	
	
	
	var graphType = "line";
/*	var pointArray = [
					{ label: "", y: 10 },
					{ label: "", y: 15 },
					{ label: "", y: 6 },
					{ label: "", y: 12 },
					{ label: "", y: 11 },
					{ label: "", y: 13 },
					{ label: "", y: 14 },
				];*/
	function generateGraph(){
		var chart = new CanvasJS.Chart("chartContainer",
		{
			animationEnabled: true,
			title:{
				text: ""
			},
			data: [
			{
				type: graphType, //change type to bar, line, area, pie, etc
				dataPoints: pointArray
			}
			]
		});
		chart.render();
	}
	function clearTimeSpan(){
			$("#graphWeek").css("box-shadow","0px 0px 0px white");
			$("#graphMonth").css("box-shadow","0px 0px 0px white");
			$("#graphYear").css("box-shadow","0px 0px 0px white");		
	}
	function clearGraphType(){
		$("#column").css("box-shadow","0px 0px 0px white");
		$("#line").css("box-shadow","0px 0px 0px white");
		$("#area").css("box-shadow","0px 0px 0px white");
		$("#pie").css("box-shadow","0px 0px 0px white");
	}
	$(document.body).on('click', '#column' ,function(){
		clearGraphType();
		$("#column").css("box-shadow","0px 0px 10px green");
		graphType="column";
		generateGraph();
	});
	$(document.body).on('click', '#line' ,function(){
		clearGraphType();
		$("#line").css("box-shadow","0px 0px 10px green");
		graphType="line";
		generateGraph();
	});
	$(document.body).on('click', '#area' ,function(){
		clearGraphType();
		$("#area").css("box-shadow","0px 0px 10px green");
		graphType="area";
		generateGraph();
	});
	$(document.body).on('click', '#pie' ,function(){
		clearGraphType();
		$("#pie").css("box-shadow","0px 0px 10px green");
		graphType="pie";
		generateGraph();
	});
	