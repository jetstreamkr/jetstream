<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="euc-kr">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
	<style>
		ul.nav-pills {
			top: 85px;
			position: fixed;
		}
		
		body {
			padding-top: 50px;
		}
	</style>
</head>
<body data-spy="scroll" data-target="#sideMenu" data-offset="0">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
</body>

</html>