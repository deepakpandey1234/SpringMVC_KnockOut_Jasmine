<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html class="no-js" lang="en">
<head>
<link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>">
</head>
<body>
 <div class="container-fluid">
										<table  class="table table-striped table-hover">
										<tbody >
												<tr >
													<td>Select</td>								
													<td>ID</td>
													<td>Name</td>
													<td>Category</td>
													<td>Ratings</td>
													<td>Latitude</td>
													<td>Longitude</td>
												</tr>
											</tbody>
										
											<tbody data-bind="foreach:allData" >
												<tr >									
													<td style="width:1%"  align="left"><input  type="checkbox" data-bind="checked:selected" /></td>
													<td style="width:8%"  align="center" data-bind="text: id"></td>
													<td style="width:10%" align="center" data-bind="text: name"></td>
													<td style="width:15%" align="left" data-bind="text: category"></td>
													<td style="width:15%" align="left" data-bind="text: rating"></td>
													<td style="width:15%" align="center" data-bind="text: latitude" ></td>
													<td style="width:15%" align="center" data-bind="text: longitude" ></td>
												</tr>
											</tbody>
										</table>
					            	</div>
</body>
<script src="<c:url value="/static/js/jquery-1.11.2.min.js" />"></script>
<script src="<c:url value="/static/js/knockout-min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/static/js/app.js" />"></script>
</html>
