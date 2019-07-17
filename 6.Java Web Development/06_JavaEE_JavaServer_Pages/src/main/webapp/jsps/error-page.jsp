<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="templates/head.jsp" />
</head>
<body>
<% int statusCode = response.getStatus(); %>
<div class="container">
    <main>
        <div class="jumbotron">
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <h1>Something went wrong</h1>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <p>
                        <img src="https://http.cat/<%= statusCode%>" alt="kitty">
                    </p>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <a href="/">Back to home.</a>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <c:import url="templates/footer.jsp" />
    </footer>
</div>
</body>
</html>
