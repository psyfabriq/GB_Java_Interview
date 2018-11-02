<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/includes/head.jsp"></jsp:include>
<body >
<jsp:include page="/WEB-INF/includes/navmenu.jsp"></jsp:include>

<div class="wrapper" >

    <!-- Page Content  -->
    <main role="main" class="container-fluid">

        <div class="jumbotron">
            <h1>
                <c:out value="${msg}" />
            </h1>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <a type="button" href="<c:url value="/students/add" />"
                       class="btn  btn-outline-success"> <i class="fas fa-plus-circle"></i>
                        <span></span>
                    </a>
                </div>
            </nav>
            <div>
                <div infinite-scroll='listtask.nextPage()'
                     infinite-scroll-disabled='listtask.busy'
                     infinite-scroll-distance='1'>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">SecondName</th>
                            <th scope="col">Mark</th>
                            <th scope="col">Create</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat='item in listtask.items'>
                            <th scope="row">{{$index}}</th>
                            <td>{{item.name}}</td>
                            <td>{{item.seondname}}</td>
                            <td>{{item.mark}}</td>
                            <td>{{item.createAt}}</td>
                            <td><a href="{{baseUrl}}/student/{{item.id}}" type="button" class="btn btn-primary ">Open</a></td>
                        </tr>

                        </tbody>
                    </table>
                    <div ng-show='listtask.busy'>Loading data...</div>
                </div>
            </div>
        </div>
        <jsp:include page="/WEB-INF/includes/footer.jsp"></jsp:include> </main>
</div>
</body>
</html>

