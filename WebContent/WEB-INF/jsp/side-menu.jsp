<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${sessionScope['HRMSEmployeeId']==null}" >
   <c:redirect url="index.html" /> 
</c:if>
<section style="width: 200px">
    <ul class="sidebar-menu" style="height: 100vh">
        <li class="header">
        <c:set value="${sessionScope['HRMSEmployee']}" var="hrmsEmployee" /> 
            <div class="per-head">
                <div id="per-image">
                    <img src="upload/ <c:out value="${hrmsEmployee.employeePicture}" />" />
                </div>
                <div id="per-name">
                    <h5> 
                    <c:out value="${hrmsEmployee.employeeFirstName}" />
                    </h5>
                    <h6> <c:out value="${hrmsEmployee.getEmployeeDesignation().getDesignationName()}" /> </h6>
                </div>
            </div>
        </li>
        <li><a href="#"><i class="fa fa-dashboard"></i> <span>Dash Board</span></a>
        </li>
        <li><a href="employee.html"><i class="fa fa-users"></i> <span> <c:if test="${sessionScope['HRMSRole']=='Employee'}"> Profile Details </c:if> <c:if test="${sessionScope['HRMSRole']=='Admin'}"> Employees </c:if> </span></a>
        </li>
       <c:if test="${sessionScope['HRMSRole']=='Employee'}">
        <li><a href="project.html"><i class="fa fa-code"></i> <span>  Project  </span></a></li>
        </c:if> 
       <c:if test="${sessionScope['HRMSRole']=='Admin'}"> 
        <li class="treeview">
            <a href="#">
                <i class="fa fa-code"></i> <span>Projects</span>
                <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="treeview-menu">
                <li><a href="project.html"><i class="fa fa-circle-o"></i> Projects</a>
                </li>
                <li><a href="client.html"><i class="fa fa-circle-o"></i> Clients</a>
                </li>
                
                
            </ul>
        </li>
        </c:if>

        <li class="treeview">
            <a href="#">
                <i class="fa fa-laptop"></i> <span>Attendance</span>
                <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="treeview-menu">
                <li><a href="attendance.html"><i class="fa fa-circle-o"></i> Attendance </a>
                </li>
                <li><a href="leaverequest.html"><i class="fa fa-circle-o"></i> Leave Requests</a>
                </li>
                
            </ul>
        </li>
      <!-- 
        <li class="treeview">
            <a href="#">
                <i class="fa fa-money"></i> <span>Salary</span>
                <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i> Hike Records</a>
                </li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Allowance Variants</a>
                </li>
            </ul>
        </li>
         -->
          <c:if test="${sessionScope['HRMSRole']=='Admin'}"> 
        <li><a href="department.html"><i class="fa fa-university"></i> <span>Departments</span></a>
        </li>
        
        <li><a href="designation.html"><i class="fa fa-code-fork"></i> <span>Designations</span></a>
        </li>
       
       <li><a href="role.html"><i class="fa fa-cogs"></i> <span>User Roles</span></a>
        </li>
        </c:if>
       

    </ul>
</section>