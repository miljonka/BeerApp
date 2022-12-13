<!DOCTYPE html>
<%@ page language="java" contentType="text/html; ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="utf-8" />

<link href="styles/demo.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<style><%@include file="/WEB-INF/css/formtyylit.css"%></style>
<title>Lis‰‰ olut &#127866;</title>
<style type="text/css">

</style>
</head>

<body>
	<h1>Lis‰‰ olut &#127866;</h1>
	<form action="/lisaa-uusiolut" method="post">

		<p>
			<label>Nimi:</label> <input type="text" value="" name="nimi"size="30" />
		</p>
		<p>
			<label>Maa:</label> <input type="text" value="" name="maa" placeholder= "" size="15" />
		</p>
		<p>
			<label>Tyyppi:</label> <input type="text" value="" name="tyyppi" placeholder = "esim. Lager" size="15" />
		</p>
		<p>
			<label>Prosentit:</label> <input type="number" value="" name="prosentit" min="0" max="95" step="0.1" size="15" />
		</p>
		<p>
			<label>Arvosana:</label> <input type="number" value="" name="arvosana" min="0" max="5" step="0.05" placeholder= 0-5 size="15" />
		</p>
		<p>
		<span class="button"><a href="/listaa-oluet" >Oluet</a></span>
		<button class=button1 type="submit" /><span>Lis‰‰</span></button>
		</p>
	</form>

</body>
</html>