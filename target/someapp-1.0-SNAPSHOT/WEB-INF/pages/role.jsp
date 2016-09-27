<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope['currentRole']=='ROLE_USER'}">
    <c:redirect url="../../user_view.html?id=${currentUserId}" />
</c:if>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Role</title>
    <link href="images/logo1.png" rel="icon" />
   <c:import url="headCss.jsp" /> </head>

<body>
    <div class="containe">
        <div class="side-menu">
            <!-- Side Menu -->
            <c:import url="side-menu.jsp" /> </div>

        <div class="content-bar">
            <c:import url="top-menu.jsp" />

            <div class="content-main">
                <div class="col-md-12">
                    <!-- Main Start -->
                    
                    <div class="tab-content">
                        <div id="Role-Table" role="tabpanel" class="tab-pane active">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Role Details </h1> </div>

                                <c:if test="${RoleList!=null}">
                                    <table class="TableSorting">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Name</th>

                                        </thead>
                                        <tfoot>

                                            <tr>
                                                <th colspan="7" class="ts-pager form-horizontal">
                                                    <button type="button" class="btn first"><i class="fa fa-fast-backward "></i>
                                                    </button>
                                                    <button type="button" class="btn prev"><i class="fa fa-step-backward "></i>
                                                    </button>
                                                    <span class="pagedisplay"></span>
                                                    <!-- this can be any element, including an input -->
                                                    <button type="button" class="btn next"><i class="fa fa-step-forward"></i>
                                                    </button>
                                                    <button type="button" class="btn last"><i class="fa fa-fast-forward"></i>
                                                    </button>
                                                    <select class="pagesize input-mini" title="Select page size">
                                                        <option selected="selected" value="10">10</option>
                                                        <option value="20">20</option>
                                                        <option value="30">30</option>
                                                        <option value="40">40</option>
                                                        <option value="50">50</option>
                                                    </select>
                                                    <select class="pagenum input-mini" title="Select page number"></select>
                                                </th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <c:forEach var="role" items="${RoleList}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${role.id}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${role.name}"></c:out>
                                                    </td>
                                                   
                                                   
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </c:if>
                            </div>
                        </div>
                       

                    </div>

                    <!-- Main End -->
                </div>
            </div>
        </div>
    </div>
  

   <c:import url="headJs.jsp" />

    <c:if test="${message==null}">
        <c:if test="${RoleEdit!=null}">
            <script>
                $("#myModal").modal();
            </script>
        </c:if>
    </c:if>

       <c:if test="${message!=null}">
            <script>
                $("#myModal").modal("hide");
                dialogConfirmation("role.html");
            </script>
        </c:if>
        <c:import url="dialogConfirmation.jsp" />
</body>

</html>