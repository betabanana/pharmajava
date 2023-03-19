<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="<c:url value = "/WEB-INF/admin/css/all.min.css"/>">
    <link rel="stylesheet" href="css/lion2.css" type="text/css">
    <link rel="stylesheet" href="css/all.min.css" type="text/css">
    <link rel="stylesheet" href="css/lion.css" type="text/css">
    <jsp:include page="/WEB-INF/admin/linkLoader.jsp" />
</head>
<body>
  <div class="login-box">
             <center><h1>se connecter</h1></center>
                <form method="post" action="AdminMedcamnet" >
                    <div class="textbox ">
                        <i class="fa fa-envelope " aria-hidden="true"></i>
                        <input type="text" placeholder="nom et prenom"name="nom" size=65px >
                    </div>

                    <div class="textbox">
                        <i class="fa fa-lock" aria-hidden="true" ></i>
                        <input type="password" name="pass" placeholder="Mot de passe" size=65px >
                    </div><br>
                    <input  type="submit" value="se connecter" class="button" name='ok'  style="background-color: brown;">
                    
                </form>
                <c:if test="${Ero!=null }">
                 <center><h3 style="color: red;"> <c:out value="${Ero }"></c:out></h3></center>
                </c:if> 
        </div>
</body>
</html>