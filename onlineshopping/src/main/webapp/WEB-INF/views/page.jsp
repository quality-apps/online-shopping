<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var = "css" value="/resources/css"/>
<spring:url var = "js" value="/resources/js"/>
<spring:url var = "images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage - ${title}</title>


    <script>
        window.menu = '${title}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap custom theme CSS  // theme can be downloaded in bootswatch.com -->
    <link href="${css}/bootstrap-custom-theme.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

  </head>

  <body>

  <div class="wrapper">

        <!-- Navigation -->
        <%@ include file = "./shared/navbar.jsp" %>

        <div class="context">
            <!-- Page Content -->
            <!-- loading home content -->

            <c:if test = "${userClickedHome == true}">
                <%@ include file = "./home.jsp" %>
            </c:if>

            <!-- loading about content -->
            <c:if test = "${userClickedAbout == true}">
                <%@ include file = "./about.jsp" %>
            </c:if>

            <!-- loading contact content -->
            <c:if test = "${userClickedContact == true}">
                <%@ include file = "./contact.jsp" %>
            </c:if>

            <!-- loading all products content -->
            <c:if test = "${userClickedAllProducts == true or userClickedCategoryProduct == true}">
                <%@ include file = "./listProducts.jsp" %>
            </c:if>
        </div>

        <!-- Footer -->
        <%@ include file = "./shared/footer.jsp" %>

    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    <script src="${js}/myapp.js"></script>


  </body>

</html>
