<%@page import= "com.Branch" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.js"></script>
<script src="Components/branches.js"></script>

<title>Branch Details</title>
</head>
<body>

<div class="container"><div class="row"><div class="col-6"> 
       <h1>Branch Details</h1>
              <form id="formbr" name="formbr"> 
              Branch ID: 
              <input id="branchID" name="branchID" type="text" class="form-control form-control-sm">
              <br>
              Branch Name: 
              <input id="branchName" name="branchName" type="text" class="form-control form-control-sm">
              <br> 
              Address: 
              <input id="branchAddress" name="branchAddress" type="text" class="form-control form-control-sm">
              <br>
              Contact No: 
              <input id="branchContact" name="branchContact" type="number" class="form-control form-control-sm">
              <br>
              Email : 
              <input id="branchEmail" name="branchEmail" type="text" class="form-control form-control-sm">
              <br>
              
              <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
              <input type="hidden" id="hiddbrIDSave" name="hiddbrIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divBranchGrid">
 <%
 Branch brObj = new Branch(); 
 out.print(brObj.readBranches()); 
 %>
</div>
</div> </div> </div> 

</body>
</html>