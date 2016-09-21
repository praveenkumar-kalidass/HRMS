<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope['HRMSEmployeeId']==null}">
    <c:redirect url="index.html" />
</c:if>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LeaveRequest Details</title>
    <link href="images/logo1.png" rel="icon" />
     <c:import url="headCss.jsp" />
    
</head>

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
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#Employee-Table" aria-controls="Employee-Table" role="tab" data-toggle="tab">LeaveRequests</a>
                        </li>
                        <li role="presentation"><a href="#Employee-Form" aria-controls="Employee-Form" role="tab" data-toggle="tab">Add New</a>
                        </li>
                        <c:if test="${sessionScope['HRMSRole']=='Admin'}">
                            <li role="presentation"><a href="#All-Request" aria-controls="Employee-Form" role="tab" data-toggle="tab">All Request</a>
                            </li>
                        </c:if>
                    </ul>
                    <div class="tab-content">

                        <div id="All-Request" role="tabpanel" class="tab-pane">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> LeaveRequest Details </h1> </div>

                                <c:if test="${LeaveRequestList!=null}">
                                    <table class="TableSorting">
                                        <thead>
                                            <tr>

                                                <th>Employee Name</th>
                                                <th>Department</th>
                                                <th>Designation</th>
                                                <th>Reason</th>
                                                <th>From</th>
                                                <th>To</th>
                                                <th>No of Days</th>
                                                <th>Status</th>
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
                                            <c:forEach var="leaveRequest" items="${LeaveRequestList}">
                                                <tr>

                                                    <td>
                                                        <c:set value="${leaveRequest.employee}" var="employee" />
                                                        <c:set value="${employee.employeeDesignation}" var="designation" />
                                                        <c:set value="${designation.department}" var="department" />
                                                        <c:out value="${employee.employeeFirstName}" />&nbsp;
                                                        <c:out value="${employee.employeeLastName}" />
                                                    </td>
                                                    <td>
                                                        <c:out value="${department.departmentName}"></c:out>
                                                    </td>

                                                    <td>
                                                        <c:out value="${designation.designationName}"></c:out>
                                                    </td>

                                                    <td>
                                                        <c:out value="${leaveRequest.leaveReason}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${leaveRequest.leaveFromDate}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${leaveRequest.leaveToDate}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${leaveRequest.noDays}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${leaveRequest.leaveStatus}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:if test="${leaveRequest.leaveStatus=='Rejected'}">
                                                            <a href="leaveRequest_status.html?id=<c:out value='${leaveRequest.leaveId} ' />&status=1">
                                                                <button class="btn btn-success"> <i class="fa fa-check"></i> Approve </button>
                                                            </a>
                                                        </c:if>
                                                        <c:if test="${leaveRequest.leaveStatus=='Approved'}">
                                                            <a href="leaveRequest_status.html?id=<c:out value='${leaveRequest.leaveId} ' />&status=2">
                                                                <button class="btn btn-danger"> <i class="fa fa-times-circle "></i> Reject </button>
                                                            </a>
                                                        </c:if>
                                                        <c:if test="${leaveRequest.leaveStatus=='Pending'}">
                                                            <a href="leaveRequest_status.html?id=<c:out value='${leaveRequest.leaveId} ' />&status=1">
                                                                <button class="btn btn-success"> <i class="fa fa-check"></i> Approve </button>
                                                            </a>
                                                            <a href="leaveRequest_status.html?id=<c:out value='${leaveRequest.leaveId} ' />&status=2">
                                                                <button class="btn btn-danger"> <i class="fa fa-times-circle "></i> Reject </button>
                                                            </a>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </c:if>


                            </div>
                        </div>
                        <div id="Employee-Table" role="tabpanel" class="tab-pane active">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> LeaveRequest Details </h1> </div>

                                <c:if test="${OwnLeaveRequestList!=null}">
                                    <table class="TableSorting">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Reason</th>
                                                <th>From</th>
                                                <th>To</th>
                                                <th>No of Days</th>
                                                <th>Status</th>
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
                                            <c:forEach var="leaveRequest" items="${OwnLeaveRequestList}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${leaveRequest.leaveId}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${leaveRequest.leaveReason}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${leaveRequest.leaveFromDate}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${leaveRequest.leaveToDate}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${leaveRequest.noDays}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${leaveRequest.leaveStatus}"></c:out>
                                                    </td>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </c:if>


                            </div>
                        </div>
                        <div id="Employee-Form" role="tabpanel" class="tab-pane">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Add New LeaveRequest </h1> </div>
                                <div class="single-rowform">
                                    <c:if test="${LeaveRequest!=null}">
                                        <spring:form action="leaveRequest_insert" method="post" class="form-group" modelAttribute="LeaveRequest">
                                            <div class="col-md-12">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Reason</label>
                                                        <div class="col-md-8">
                                                            <spring:textarea path="leaveReason" class="form-control" placeHolder="Reason" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Name Minimum 5 Characters"></spring:textarea>
                                                        </div>
                                                    </div>

                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">From Date</label>
                                                        <div class="col-md-8">

                                                            <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input3" data-link-format="yyyy-mm-dd">
                                                                <input class="form-control readonly" size="16" type="text" placeHolder="From Date" required="required"  >
                                                                <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                                            </div>
                                                            <spring:input path="leaveFromDate" id="dtp_input3" type="hidden" class="form-control" />
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">To Date</label>
                                                        <div class="col-md-8">

                                                            <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input4" data-link-format="yyyy-mm-dd">
                                                                <input class="form-control readonly" size="16" type="text"  onchange="cldate();" required="required" placeHolder="To Date" >
                                                                <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                                            </div>
                                                            <spring:input path="leaveToDate" id="dtp_input4" type="hidden" class="form-control" />
                                                        </div>
                                                    </div>

                                                    <spring:input path="noDays" type="hidden" id="noofDays" class="form-control"></spring:input>

                                                    <div class="form-group row">
                                                        <div class="col-md-8">

                                                            <spring:input type="hidden" path="employee.employeeId" class="form-control" value="${sessionScope['HRMSEmployeeId']}" />
                                                        </div>


                                                        <div class="form-group row">
                                                            <div class="col-md-8">
                                                                <spring:input path="leaveStatus" type="hidden" class="form-control" value="Pending"></spring:input>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-12">
                                                            <br/> </div>
                                                        <div class="form-group row" align="center">
                                                            <div class="col-md-12">
                                                                <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Send to Admin"> </div>
                                                        </div>

                                                    </div>

                                                </div>
                                            </div>
                                        </spring:form>
                                    </c:if>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- Main End -->
                </div>
            </div>
        </div>
    </div>

    </div>

   <c:import url="headJs.jsp" />
    
    <c:if test="${message==null}">
        <c:if test="${LeaveRequestEdit!=null}">
            <script>
                $("#myModal").modal();
            </script>
        </c:if>
    </c:if>

     <c:if test="${message!=null}">
            <script>
                $("#myModal").modal("hide");
                dialogConfirmation("leaverequest.html");
            </script>
        </c:if>
        <c:import url="dialogConfirmation.jsp" />
</body>
</html>           
