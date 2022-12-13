<!DOCTYPE html>
<%@ page language="java" contentType="text/html; ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8" />

<link href="styles/demo.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<style><%@include file="/WEB-INF/css/formtyylit.css"%></style>
<title>Muokkaa olut &#127866;</title>
<style type="text/css">
Olut olut = (Olut)request.getAttribute("olut"); 
</style>
</head>

<body>
	<h1>Muokkaa olutta &#127866;</h1>
	<form action="/muokkaa-olut" method="post">
	<table class="table table_striped" >
	
		<input type=hidden name=olut_id value="${olut.olut_id}"/>
			
		<p>
			<label>Nimi:</label> <input type="text" value="${olut.nimi}" name="nimi" placeholder = "${olut.nimi}" size="30" />
		</p>
		<p>
			<label>Maa:</label> <input type="text" value="${olut.maa}" name="maa" placeholder= "${olut.maa}" size="15" />
		</p>
		<p>
			<label>Tyyppi:</label> <input type="text" value="${olut.tyyppi}" name="tyyppi" placeholder = "${olut.tyyppi}" size="15" />
		</p>
		<p>
			<label>Prosentit:</label> <input type="number" value="${olut.prosentit}" name="prosentit" min="0" max="95" step="0.1" placeholder= "${olut.prosentit}" size="50" />
		</p>
		<p>
			<label>Arvosana:</label> <input type="number" value="${olut.arvosana}" name="arvosana" min="0" max="5" step="0.05" placeholder= "${olut.arvosana}" size="20" />
		</p>
		<p>
		<span class="button"><a href="/listaa-oluet" >Oluet</a></span>
		<button class=button1 type="submit" /><span>Tallenna</span></button>
		</p>
	</form>

</body>
</html>