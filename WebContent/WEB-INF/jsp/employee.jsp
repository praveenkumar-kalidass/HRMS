<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${sessionScope['HRMSEmployeeId']==null}">
    <c:redirect url="index.html" />
</c:if>
<c:if test="${sessionScope['HRMSRole']=='Employee'}">
    <c:redirect url="employee_view.html?id=${HRMSEmployeeId}" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee</title>
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

                    <div id="Employee-Table" role="tabpanel" class="tab-pane active">
                        <div class="main-head">
                            <h1 class="title"> Employee Details </h1>

                        </div>

                        <div class="form">
                            <div style="padding-top:10px; padding-bottom: 10px;">
                                <a href="personal.html">
                                    <button class="btn btn-info"> <i class="fa fa-plus-circle"></i> Add New </button>
                                </a>
                            </div>
                            <c:if test="${EmployeeList!=null}">
                                <table class="TableSorting">
                                    <thead>
                                        <tr>
                                            <th> Employee Id </th>
                                            <th> Name</th>
                                            <th> Department </th>
                                            <th> Designation</th>
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
                                        <c:forEach var="employee" items="${EmployeeList}">
                                            <tr>
                                                <td>
                                                    <c:out value="${employee.employeeId}"></c:out>
                                                </td>
                                                <td>
                                                    <a href="employee_view.html?id=<c:out value='${employee.employeeId} ' />" class="edit"> <c:out value="${employee.employeeFirstName}"></c:out> &nbsp;<c:out value="${employee.employeeLastName}"></c:out> </a>
                                                </td>
                                                <td>
                                                    <c:set value="${employee.employeeDesignation}" var="designation" />
                                                    <c:set value="${designation.department}" var="department" />
                                                    <c:out value="${department.departmentName}"></c:out>
                                                </td>
                                                <td>
                                                    <c:out value="${designation.designationName}"></c:out>
                                                </td>
                                                <td>
                                                    <a href="attendance_view.html?id=<c:out value='${employee.employeeId} ' />" > <i class="fa fa-edit"></i> View Attendance </a>
                                                </td>
                                                <td>
                                                    <a href="employee_delete.html?id=<c:out value='${employee.employeeId} ' />" class="delete"> <i class="fa fa-trash"></i> Delete </a>
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
  
    <c:import url="headJs.jsp" />

     <c:if test="${message!=null}">
            <script>
                $("#myModal").modal("hide");
                dialogConfirmation("employee.html");
            </script>
        </c:if>
        <c:import url="dialogConfirmation.jsp" />
</body>

</html>
