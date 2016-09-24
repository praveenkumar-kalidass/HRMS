<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="com.ideas2it.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<section style="width: 200px">
    <ul class="sidebar-menu" style="height: 100vh">
        <li class="header">
            <div class="per-head">
                <div id="per-image">
                    <img src="images/user.png" />
                </div>
                <div id="per-name">
                    <h5> 
                     <c:out value="${sessionScope['currentUserFullName']}" />
                     <c:out value="${sessionScope['currentUserId']}" />  
                     <c:set value="${sessionScope['currentUser'].designation}" var="designation" />
                     <c:out value="${designation.designationName}" />     
                     </h5>
                    <h6> Designation</h6>
                </div>
            </div>
        </li>
        <li><a href="dashboard.html"><i class="fa fa-dashboard"></i> <span>Dash Board</span></a>
        </li>
        <li><a href="user.html"><i class="fa fa-users"></i> <span>  Employees  </span></a>
        </li>
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
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-money"></i> <span>Salary</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="salary.html"><i class="fa fa-circle-o"></i> Generate Salary</a>
                    </li>
                    <li><a href="allowance.html"><i class="fa fa-circle-o"></i> Allowance Variants</a>
                    </li>
                </ul>
            </li>
            <li><a href="department.html"><i class="fa fa-university"></i> <span>Departments</span></a>
            </li>

            <li><a href="designation.html"><i class="fa fa-code-fork"></i> <span>Designations</span></a>
            </li>

            <li><a href="role.html"><i class="fa fa-cogs"></i> <span>User Roles</span></a>
            </li>

    </ul>
</section>
