<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="templates/head.jsp" />
</head>
<body>
    <div class="container">
        <main>
            <div class="jumbotron">
                <form action="/tubes/create" method="post">
                    <div class="row">
                        <div class="col col-md-12 d-flex justify-content-center">
                            <h1>Create Tube</h1>
                        </div>
                    </div>
                    <hr/>
                    <div class="row">
                        <div class="col col-md-12">
                            <div class="row d-flex justify-content-center">
                                <label for="nameInput">Name</label>
                            </div>
                            <div class="row d-flex justify-content-center">
                                <input type="text" id="nameInput" name="name">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col col-md-12">
                            <div class="row d-flex justify-content-center">
                                <label for="descriptionTextarea">Description</label>
                            </div>
                            <div class="row d-flex justify-content-center">
                                <textarea name="description" id="descriptionTextarea" cols="22" rows="4"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col col-md-12">
                            <div class="row d-flex justify-content-center">
                                <label for="inputLink">YouTube Link</label>
                            </div>
                            <div class="row d-flex justify-content-center">
                                <input type="text" id="inputLink" name="youTubeLink">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col col-md-12">
                            <div class="row d-flex justify-content-center">
                                <label for="inputUploader">Uploader</label>
                            </div>
                            <div class="row d-flex justify-content-center">
                                <input type="text" id="inputUploader" name="uploader">
                            </div>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="col col-md-12 d-flex justify-content-center">
                            <button type="submit" class="btn btn-primary">Create Tube</button>
                        </div>
                    </div>
                </form>
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
