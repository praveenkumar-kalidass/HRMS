<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope['HRMSEmployeeId']==null}">
    <c:redirect url="index.html" />
</c:if>
<c:if test="${sessionScope['HRMSRole']=='Employee'}">
    <c:redirect url="employee_view.html?id=${HRMSEmployeeId}" />
</c:if>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Department</title>
    <link href="images/logo1.png" rel="icon" />
   <c:import url="headCss.jsp" /></head>

<body>
    <div class="containe">
        <div class="side-menu">
            <!-- Side Menu -->
            <c:import url="side-menu.jsp" /> </div>

        <div class="content-bar">
            <c:import url="top-menu.jsp" />

            <div class="content-main">
                <div class="col-md-12">
                  

                    <div id="Department-Table" role="tabpanel" class="tab-pane active">
                        <ol class="breadcrumb">
                            <li><a href="javascript:void(0)">Personal Details</a>
                            </li>
                            <li><a href="javascript:void(0)">Communication Details</a>
                            </li>
                            <li class="active">Education Details</li>
                            <li><a href="javascript:void(0)">Certification Details</a>
                            </li>
                            <li><a href="javascript:void(0)">Profile Picture</a>
                            </li>
                        </ol>

                        <div class="main-head">
                            <h1 class="title"> Education Details </h1> </div>

                        <div class="form">
                            <div class="col-md-12" style="padding-left: 100px;">
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Highest Qualification Degree</label>
                                    <div class="col-md-6">
                                        <select onchange="loadEducationForm(<c:out value ='${EmployeeId}' />)" class="form-control" id="noof">
                                            <option value="0">--Select--</option>
                                            <option value="1">SSLC</option>
                                            <option value="2">HSC</option>
                                            <option value="3">Under Graduation</option>
                                            <option value="4">Post Graduation</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12" style="padding-left: 100px;">
                                <div id="education_form">
                                </div>
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
                dialogConfirmation("employee.html");
            </script>
        </c:if>
        <c:import url="dialogConfirmation.jsp" />
</body>

</html>
