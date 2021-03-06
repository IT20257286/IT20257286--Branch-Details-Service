$(document).ready(function() 
{ 
if ($("#alertSuccess").text().trim() == ""){ 
 $("#alertSuccess").hide(); 
 } 
 $("#alertError").hide(); 
}); 


// SAVE ============================================
 $(document).on("click", "#btnSave", function(event) 
{ 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
 
 
// Form validation-------------------
var status = validateBranchForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
 
// If valid------------------------
var type = ($("#hiddbrIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "BranchesAPI", 
 type : type, 
 data : $("#formbr").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onBranchDetailsSaveComplete(response.responseText, status); 
 } 
 }); 
});

function onBranchDetailsSaveComplete(response, status) 
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divBranchGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 } 

 $("#hiddbrIDSave").val(""); 
 $("#formbr")[0].reset(); 
}

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hiddbrIDSave").val($(this).data("branchID"));
 $("#branchID").val($(this).closest("tr").find('td:eq(0)').text()); 
 $("#branchName").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#branchAddress").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#branchContact").val($(this).closest("tr").find('td:eq(3)').text()); 
 $("#branchEmail").val($(this).closest("tr").find('td:eq(4)').text()); 
}); 


$(document).on("click", ".btnRemove", function(event) 
{ 
 $.ajax( 
 { 
 url : "BranchesAPI", 
 type : "DELETE", 
 data : "branchID=" + $(this).data("branchID"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onODPaymentsDeleteComplete(response.responseText, status); 
 } 
 }); 
});


function onBranchDetailsDeleteComplete(response, status) 
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divBranchGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}




// CLIENT-MODEL================================================================
function validateBranchForm() 
{ 
	
// Branch ID
if ($("#branchID").val().trim() == ""){ 
 return "Insert branchID."; 
 } 
 

// Branch Name
if ($("#branchName").val().trim() == ""){ 
 return "Insert branchName."; 
 } 
 
// Branch Address
if ($("#branchAddress").val().trim() == ""){ 
 return "Insert branchAddresss."; 
 } 
 
// Branch Contact NO
if ($("#branchContact").val().trim() == ""){ 
 return "Insert branchContact."; 
 } 
 
 //Branch Email
if ($("#branchEmail").val().trim() == "") 
 { 
 return "Insert branchEmail."; 
 } 
 


 
return true; 
}