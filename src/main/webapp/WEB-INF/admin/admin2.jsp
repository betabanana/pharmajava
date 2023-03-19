<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page  import="dao.*" %>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en"> 
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Pharmajava</title>
    <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
    <meta name="description" content="This is an example dashboard created using build-in elements and components.">
    <meta name="msapplication-tap-highlight" content="no">
    <link href="https://demo.dashboardpack.com/architectui-html-free/main.css" rel="stylesheet">

    <link rel="stylesheet" href="css/lion.css">
    <link rel="stylesheet" href="css/lion2.css">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Work+Sans:ital,wght@0,600;1,300;1,500&display=swap"
        rel="stylesheet">

    <jsp:include page="linkLoader.jsp" />


</head>

<body>
    <div class="container"> 
      <input class="AjouterMedInput" type="checkbox" id="AjoueterMed">
     <%@ include file="ajouterMedicament.jsp" %>
     <c:if test="${ajeterModSUPInst==1 }">
    
       <%@ include file="ajouterInstance.jsp" %>
      </c:if>
      <c:if test="${ajeterModSUPInst==2}">
      <%@ include file="modiferMed.jsp" %>
      </c:if>
      <c:if test="${ajeterModSUPInst==5}">
      <%@ include file="ConsltMed.jsp" %>
      </c:if>
      <c:if test="${ajouterMed==1 }">
          <%@ include file="AjouterMEDERROR.jsp" %>
        </c:if>
 
     </div>
    <div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
        <div class="app-header header-shadow">
            <!--loooog -->
            <div class="app-header__logo">
                 <input class="inpLo" type="checkbox" id="lo"/> 
                <div class="logopfar"><span class="span1">PHARMA</span><span class="span2">JAVA</span></div>

                
                <div class="header__pane ml-auto">
                    <div>
                        
                        <button type="button" class="hamburger close-sidebar-btn hamburger--elastic"
                            data-class="closed-sidebar">
                          
                            <label for="lo"   style="color: white;">  .<span class="hamburger-box"> 
                                <span class="hamburger-inner"></span></label>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <!--loooog -->

            <div class="app-header__mobile-menu">
                <div>
                    <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                        <span class="hamburger-box">
                            <span class="hamburger-inner"></span>
                        </span>
                    </button>
                </div>
            </div>
            <div class="app-header__menu">
                <span>
                    <button type="button"
                        class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                        <span class="btn-icon-wrapper">
                            <i class="fa fa-ellipsis-v fa-w-6"></i>
                        </span>
                    </button>
                </span>
            </div>


            <div class="app-header__content">


                <div class="app-header-left">
                    <div class="search-wrapper">
                        <form action="AdminCommande" method="post">
                             <input type="text" name="mot" size=30px>
                             <button><p><i class="fa-sharp fa-solid fa-magnifying-glass"></i></p></button>
                            </form>
                    </div>
                    <ul class="header-menu nav">
                        <!--nav  vvvvvvvvvvv -->
                    </ul>
                </div>
                <div class="app-header-right">
                    <div class="header-btn-lg pr-0">
                        <div class="widget-content p-0">
                            <div class="widget-content-wrapper">
                                <div class="widget-content-left">

                                    <div class="btn-group">
                                        <a data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                                            class="p-0 btn">
                                            <img width="42" class="rounded-circle" src="assets/images/avatars/1.jpg"
                                                alt="">
                                            <i class="fa fa-angle-down ml-2 opacity-8"></i>
                                        </a>
                                        <div tabindex="-1" role="menu" aria-hidden="true"
                                            class="dropdown-menu dropdown-menu-right">
                                            <a href="acceuil" type="button" tabindex="0" class="dropdown-item">deconnecter</a>


                                        </div>
                                    </div>

                                </div>
                                <div class="widget-content-left  ml-3 header-user-info">
                                    <div class="widget-heading">
                                    <c:choose>
                                            <c:when test="${ !empty sessionScope.nom }">
                                            <i class="fa-thin fa-user"></i>${sessionScope.nom }
                                            </c:when>
                                            <c:otherwise>
                                            <a href="AdminCommande">se connecter</a> 
                                             
                                            </c:otherwise>
                                      </c:choose>
                                    </div>
                                    <div class="widget-subheading">

                                    </div>
                                </div>
                                <div class="widget-content-right header-user-info ml-3">

                                    <!--   deconecer-->
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
     </div>
        
           <%-- <%@ include file="parametre.jsp" --%>--%>
        
        
        <div class="app-main">
            <div class="app-sidebar sidebar-shadow">
                <div class="app-header__logo">
                    <input class="inpLo2" type="checkbox" id="loo"/> 
                    <div class="logopfar2"><span class="span1">PHARMA</span><span class="span2">JAVA</span></div>
                    <div class="header__pane ml-auto">
                        <div>
                            <button type="button" class="hamburger close-sidebar-btn hamburger--elastic"
                            data-class="closed-sidebar">
                          
                            <label for="loo"  style="color: white;">  .<span class="hamburger-box"> 
                                <span class="hamburger-inner"></span></label>
                            </span>
                        </button>

                       
                        </div>
                    </div>
                </div>
                <div class="app-header__mobile-menu">
                    <div>
                        <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
                <div class="app-header__menu">
                    <span>
                        <button type="button"
                            class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                            <span class="btn-icon-wrapper">
                                <i class="fa fa-ellipsis-v fa-w-6"></i>
                            </span>
                        </button>
                    </span>
                </div>
                <div class="scrollbar-sidebar">
                    <div class="app-sidebar__inner">
                             <ul class="vertical-nav-menu">
                            <li class="app-sidebar__heading">
                                <a href="acceuil">
                                    <i class="fa-solid fa-house"></i>
                                    Acceul
                                </a>
                            </li>
                            <li class="app-sidebar__heading">
                                <a href="AdminMedcamnet">
                         <i class="fa-sharp fa-solid fa-cubes-stacked"></i><span>  </span><span>Stock Medicament</span>
                          
                                </a>
                            </li>
                            <li class="app-sidebar__heading">
                                <a href="AdminCommande">
                                         <i class="fa-solid fa-comment"></i>   Commande
                                </a>
                            </li>
                            <li class="app-sidebar__heading">
                                <a href="">
                               <i class="fa-solid fa-arrow-down"></i>
                                    <label for="AjoueterMed"> Ajouter medicament</label>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>s
            <div class="app-main__outer">
                <div class="app-main__inner">
                    <!--dube table-->
                    <div class="container">                   
                           <%@ include file="commande.jsp" %>
   
                    </div>
                    <!--fin table-->
                </div>
                <div class="app-wrapper-footer">
                   <div class="footer">
                  &copy; 2023 - <span>Leon</span>,All Right Reserved
                  </div>
                </div>
            </div>
        </div>
        <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
    </div>
    </div>
    <script type="text/javascript"
        src="https://demo.dashboardpack.com/architectui-html-free/assets/scripts/main.js"></script>
 </body>

</html>
