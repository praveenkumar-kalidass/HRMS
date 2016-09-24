<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Salary Details</title>
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
                        <div id="Client-Table" role="tabpanel" class="tab-pane active">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Salary Details </h1> </div>

                                <c:if test="${SalaryList!=null}">
                                    <table id="ProjectTable" class="TableSorting">
                                        <thead >
                                            <tr>
                                                <th>Employee Name</th>
                                                <th>Department</th>
                                                <th>Designation</th>
                                                <th>Basic Pay</th>
                                                <th>House Rent Allowance</th>
                                                <th>Dearness Allowance</th>
                                                <th>Provident Fund</th>
                                                <th>Medical Allowance</th>
                                                <th>No of Days Leave</th>
                                                <th>Loss of Pay</th>
                                                <th>Net Pay</th>
                                        </thead>
                                        <tfoot>

                                            <tr>
                                                <th colspan="11" class="ts-pager form-horizontal">
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
                                                        <option selected="selected" value="100">100</option>
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
                                            <c:forEach var="salary" items="${SalaryList}">
                                                <tr>
                                                    <td>
                                                        <c:set value="${salary.user}" var="user" />
                                                        <c:out value="${user.firstName}" />&nbsp;&nbsp;
                                                        <c:out value="${user.lastName}" />
                                                    </td>
                                                    <td>
                                                        <c:set value="${user.designation}" var="designation" />
                                                        <c:set value="${designation.department}" var="department" />
                                                        <c:out value="${department.departmentName}"></c:out>

                                                    </td>
                                                    <td>
                                                        <c:out value="${designation.designationName}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${salary.basicPay}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${salary.houseRentAllowance}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${salary.dearnessAllowance}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${salary.providentFund}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${salary.medicalAllowance}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${salary.noDays}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${salary.lossOfPay}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${salary.totalAmount}"></c:out>
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

       <c:if test="${message!=null}">
            <script>
                $("#myModal").modal("hide");
                dialogConfirmation("salary.html");
            </script>
        </c:if>
        <c:import url="dialogConfirmation.jsp" />
</body>

</html>
