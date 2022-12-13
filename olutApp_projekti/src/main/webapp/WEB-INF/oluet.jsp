<%@ page language="java" contentType="text/html; ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8" />
<title>Oluet &#127866;</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style><%@include file="/WEB-INF/css/tyyli.css"%></style>

</head>
<body>
	<h1><a href="/listaa-oluet" style=color:black>Oluet &#127866;</a></h1>
	<button class="button1" ><a href = "/lisaa-uusiolut"><span>Lis‰‰ olut ª </span></a></button>
	<div class="topnav">
	<div class="search-container">
	
  <form class="form-inline" method="post" action="/etsi-olut"> 
    <input type="text" name="olutNimi" class="form-control" placeholder="Etsi olut nimell‰..">
    <button type="submit" class="fa fa-search"></button>
  </form>
	
	 </div>
	 </div>
	<table class="table table_striped" >

		<tr>
			<th><a href="/listaa-oluet">Id</a></th>
			<th><a href="/listaa-oluet-sorted">Nimi</a></th>
			<th>Maa</th>
			<th>Tyyppi</th>
			<th>Prosentit</th>
			<th>Arvosana</th>
			<th></th>
	</tr>
		 <c:forEach items="${oluet_loytyi}" var="olut">   
	           
			<tr>
				<td><c:out value="${olut.olut_id}"/></td> 
				<td><c:out value="${olut.nimi}" /></td>  <%-- lyhennysmerkint‰ metodikutsulle ${olut.getNimi()} --%>
				<td><c:out value="${olut.maa}" /></td> 
				<td><c:out value="${olut.tyyppi}" /></td> 
				<td><c:out value="${olut.prosentit}%" /></td> 
				<td><c:out value="${olut.arvosana}" /></td> <%-- lyhennysmerkint‰ metodikutsulle ${olut.getNimi()} --%>
				<td><a href="/muuta-olut?olut_id=<c:out value='${olut.olut_id}'/>">Muuta / </a><a href="/poista-olut?olut_id=<c:out value='${olut.olut_id}'/>">Poista</a></td>
				
			</tr>
			
		</c:forEach>
	
		<%-- ${oluet} viittaa keyword-arvolla request-olion Map-tietorakenteessa olevaan olutlistaan(ArrayList) --%>
		
		<c:forEach items="${oluet}" var="olut">             
			<tr>
				<td><c:out value="${olut.olut_id}"/></td> 
				<td><c:out value="${olut.nimi}" /></td>  <%-- lyhennysmerkint‰ metodikutsulle ${olut.getNimi()} --%>
				<td><c:out value="${olut.maa}" /></td> 
				<td><c:out value="${olut.tyyppi}" /></td> 
				<td><c:out value="${olut.prosentit}%" /></td> 
				<td><c:out value="${olut.arvosana}" /></td>
				<td><a href="/muuta-olut?olut_id=<c:out value='${olut.olut_id}'/>">Muuta / </a><a href="/poista-olut?olut_id=<c:out value='${olut.olut_id}'/>">Poista</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>