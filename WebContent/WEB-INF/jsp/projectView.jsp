<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope['HRMSEmployeeId']==null}">
    <c:redirect url="index.html" />
</c:if>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Project Details</title>
    <link href="images/logo1.png" rel="icon" />
    <c:import url="headCss.jsp" />
</head>

<body>
    <div id="dialog-confirm" title="Alert" style="display: none;">
        <p>
            <c:if test="${message!=null}">
                <c:out value="${message}" />
            </c:if>
        </p>
    </div>
    <div class="containe">
        <div class="side-menu">
            <!-- Side Menu -->
            <c:import url="side-menu.jsp" />
        </div>

        <div class="content-bar">
            <c:import url="top-menu.jsp" />
            <c:set value="${Project}" var="project" />
            <c:set value="${project.client}" var="client" />

            <div class="content-main">
                <div class="col-md-12">
                    <!-- Main Start -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#Project-Details" aria-controls="Department-Table" role="tab" data-toggle="tab">Project Details</a>
                        </li>
                        <li role="presentation"><a href="#Client-Details" aria-controls="Department-Table" role="tab" data-toggle="tab">Client
								Details</a>
                        </li>
                        <li role="presentation"><a href="#Release-Details" aria-controls="Department-Table" role="tab" data-toggle="tab">Release
								Details</a>
                        </li>
                        <li role="presentation"><a href="#Team-Details" aria-controls="Department-Table" role="tab" data-toggle="tab">Team
								Details</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="Project-Details" role="tabpanel" class="tab-pane active">
                            <div class="main-head">
                                <h1 class="title" style="float: left; width: 80%;">
									Project Details</h1>

                                <c:if test="${sessionScope['HRMSTeamRole']=='Leader'}">
                                    <a href="project_edit.html?id=<c:out value='${project.projectId}' />" style="float: right; width: 20%; padding-top: 26px;" class="edit"> <i class="fa fa-pencil"></i> Edit Project Details
                                    </a>
                                </c:if>
                            </div>

                            <div class="form">
                                <div class="col-md-12">

                                    <div class="col-md-12">
                                        <div class="form-group row"></div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Project Id </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${project.projectId}' />
                                            </label>
                                        </div>
                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Project Name </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${project.projectName}' />
                                            </label>
                                        </div>
                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Date of Starting </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${project.fromDate}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Description </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${project.description}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Status </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${project.status}' />
                                            </label>
                                        </div>

                                    </div>

                                </div>

                            </div>
                        </div>
                        <div id="Client-Details" role="tabpanel" class="tab-pane">
                            <div class="main-head">
                                <h1 class="title">Client Details</h1>
                            </div>
                            <div class="form">
                                <div class="col-md-12">

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Name </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${client.clientName}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Address </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${client.street}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> City </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${client.city}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> State </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${client.state}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Country </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${client.country}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Phone Number </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${client.phoneNumber}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Email </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${client.eMail}' />
                                        </label>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Web Address </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${client.website}' />
                                        </label>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div id="Release-Details" role="tabpanel" class="tab-pane">
                            <div class="main-head">
                                <h1 class="title" style="float: left; width: 80%;">
									Release Details</h1>
                                <c:if test="${sessionScope['HRMSRole']=='Admin'}">
                                    <a href="projectrelease.html?id=<c:out value='${project.projectId}' />" style="float: right; width: 20%; padding-top: 26px;" class="edit"> <i class="fa fa-plus-circle"></i> Add New Release Details
                                    </a>
                                </c:if>
                            </div>
                            <c:forEach items="${ReleaseList}" var="release">

                                <div class="col-md-12" style="padding-top:10px;">
                                    <div class="col-md-12" style="margin: 0px; padding: 0px;">
                                        <h5 class="title" style="float: left; width: 60%;">
											Version : <c:out value='${release.projectVersion}' />
										</h5>
                                        <c:if test="${sessionScope['HRMSRole']=='Admin'}">
                                            <a href="projectRelease_delete.html?id=<c:out value='${release.releaseId}' />" style="float: right; width: 10%; padding-top: 5px;" class="delete"> <i class="fa fa-trash"></i> Delete
                                            </a>
                                            <a href="projectRelease_edit.html?id=<c:out value='${release.releaseId}' />" style="float: right; width: 10%; padding-top: 5px;" class="edit"> <i class="fa fa-pencil"></i> Edit
                                            </a>
                                        </c:if>

                                        <div class="col-md-12" style="margin: 0px; padding: 0px;">
                                            <hr style="margin-top: 5px;">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Version Name </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${release.projectVersion}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Release Date </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${release.releaseDate}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Description </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${release.description}' />
                                        </label>
                                    </div>

                                </div>
                            </c:forEach>
                        </div>

                        <div id="Team-Details" role="tabpanel" class="tab-pane">
                            <div class="main-head">
                                <h1 class="title" style="float: left; width: 80%;">
									Team Details</h1>
                                <c:if test="${sessionScope['HRMSRole']=='Admin'}">
                                    <a href="team.html?id=<c:out value='${project.projectId}' />" style="float: right; width: 20%; padding-top: 26px;" class="edit"> <i class="fa fa-plus-circle"></i> Allocate New Employee
                                    </a>
                                </c:if>
                            </div>
                            <c:forEach items="${TeamList}" var="team">

                                <div class="col-md-12" style="padding-top:10px;">
                                    <div class="col-md-12" style="margin: 0px; padding: 0px;">
                                        <h5 class="title" style="float: left; width: 60%;">
											&nbsp;&nbsp;
										</h5>
                                        <c:if test="${sessionScope['HRMSRole']=='Admin'}">
                                            <a href="team_delete.html?id=<c:out value='${team.teamId}' />" style="float: right; width: 10%; padding-top: 5px;" class="delete"> <i class="fa fa-user-times "></i> Deallocate
                                            </a>
                                        </c:if>

                                        <div class="col-md-12" style="margin: 0px; padding: 0px;">
                                            <hr style="margin-top: 5px;">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Name of the Employee </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:set value="${team.employee}" var="employee" />
                                            <a href="employee_view.html?id=<c:out value='${employee.employeeId} ' />">   <c:out value='${employee.employeeFirstName}' /> &nbsp;
                                            <c:out value='${employee.employeeLastName}' /> </a>
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Department </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:set value="${employee.employeeDesignation}" var="designation" />
                                            <c:set value="${designation.department}" var="department" />
                                            <c:out value="${department.departmentName}" />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Designation </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${designation.designationName}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Team Role </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${team.teamRole}' />
                                        </label>
                                    </div>

                                </div>
                            </c:forEach>

                        </div>
                    </div>
                    <!-- Main End -->
                </div>
            </div>
        </div>
    </div>

    <div id="project_model" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Project Details</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${ProjectEdit!=null}">
                        <spring:form action="project_update" method="post" class="form-group" modelAttribute="ProjectEdit">
                            <div class="col-md-12">
                                <spring:input path="projectId" type="hidden" class="form-control" id="example-text-input" placeHolder="Project Id" readonly="readOnly" />
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Project Name
                                    </label>
                                    <div class="col-md-8">
                                        <spring:input path="projectName" class="form-control" id="example-text-input" placeHolder="Project Name" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Date of Started</label>
                                    <div class="col-md-8">
                                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                            <input class="form-control" size="16" type="text" value="<c:out value=" ${ProjectEdit.fromDate} "></c:out>" readonly placeHolder="Date of Started">
                                            <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                        </div>
                                        <spring:input path="fromDate" id="dtp_input2" type="hidden" class="form-control" placeHolder="Date of Started" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Client</label>
                                    <div class="col-md-8">
                                        <spring:select path="client" class="form-control">
                                            <c:set value="${ProjectEdit.client}" var="dep" />
                                            <spring:option value="${dep.clientId}">${dep.clientName}</spring:option>
                                            <spring:option value="0"> -------</spring:option>
                                            <c:forEach items="${ClientList}" var="client">
                                                <spring:option value="${client.clientId}">${client.clientName}</spring:option>
                                            </c:forEach>
                                        </spring:select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Description</label>
                                    <div class="col-md-8">
                                        <spring:textarea path="description" class="form-control" id="Description" placeHolder="Description"></spring:textarea>
                                    </div>
                                </div>
                                <c:if test="${ProjectEdit.status=='Active'}">
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Status</label>
                                        <div class="col-md-8">
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="status" value="Active" checked="checked" /> Active
                                                </label>
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="status" value="Completed" /> Completed
                                                </label>
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="status" value="Dropped" /> Dropped
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${ProjectEdit.status=='Completed'}">
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Status</label>
                                        <div class="col-md-8">
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="status" value="Active" /> Active
                                                </label>
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="status" value="Completed" checked="checked" /> Completed
                                                </label>
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="status" value="Dropped" /> Dropped
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${ProjectEdit.status=='Dropped'}">
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Status</label>
                                        <div class="col-md-8">
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="status" value="Active" /> Active
                                                </label>
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="status" value="Completed" /> Completed
                                                </label>
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="status" value="Dropped" checked="checked" /> Dropped
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <div class="form-group row" align="center">
                                    <div class="col-md-12">
                                        <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save"> </div>
                                </div>

                            </div>
                        </spring:form>
                    </c:if>
                </div>
                <div class="modal-footer"></div>
            </div>

        </div>
    </div>
    <div id="release_model" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Release Details</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${ProjectReleaseEdit!=null}">
                        <spring:form action="projectRelease_update" method="post" class="form-group" modelAttribute="ProjectReleaseEdit">
                            <div class="col-md-12">

                                <spring:input path="releaseId" type="hidden" class="form-control" id="example-text-input" placeHolder="ProjectRelease Id" readonly="readOnly" />
                                <spring:input path="project.projectId" type="hidden" class="form-control" id="example-text-input" placeHolder="ProjectRelease Id" readonly="readOnly" />

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">To:</label>
                                    <div class="col-md-8">

                                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input4" data-link-format="yyyy-mm-dd">
                                            <input class="form-control" size="16" type="text" value="<c:out value='${ProjectReleaseEdit.releaseDate}' />" readonly>
                                            <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                        </div>
                                        <spring:input path="releaseDate" id="dtp_input4" type="hidden" class="form-control" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Project Version</label>
                                    <div class="col-md-8">
                                        <spring:input path="projectVersion" class="form-control" required="required" placeHolder="Project Version" /> </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Description</label>
                                    <div class="col-md-8">
                                        <spring:textarea path="description" class="form-control" required="required" placeHolder="Description"></spring:textarea>
                                    </div>
                                </div>

                                <div class="form-group row" align="center">
                                    <div class="col-md-12">
                                        <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save"> </div>
                                </div>
                            </div>
                        </spring:form>
                    </c:if>
                </div>
                <div class="modal-footer"></div>
            </div>

        </div>
    </div>

    <div id="releaseAdd_model" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Add New Release</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${ProjectRelease!=null}">
                        <spring:form action="projectRelease_insert" method="post" class="form-group" modelAttribute="ProjectRelease">
                            <div class="col-md-12">

                                <spring:input type="hidden" path="project.projectId" class="form-control" placeHolder="Project Id" value="${ProjectId}" />

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Date of Release</label>
                                    <div class="col-md-8">

                                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input4" data-link-format="yyyy-mm-dd">
                                            <input class="form-control readonly" size="16" type="text" required="required" placeHolder="Date" >
                                            <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                        </div>
                                        <spring:input path="releaseDate" id="dtp_input4" type="hidden" class="form-control" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Project Version</label>
                                    <div class="col-md-8">
                                        <spring:input path="projectVersion" class="form-control" required="required" placeHolder="Project Version" /> </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Description</label>
                                    <div class="col-md-8">
                                        <spring:textarea path="description" class="form-control" required="required" placeHolder="Description"></spring:textarea>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <br/> </div>
                                <div class="form-group row" align="center">
                                    <div class="col-md-12">
                                        <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save"> </div>
                                </div>
                            </div>
                        </spring:form>
                    </c:if>
                </div>
                <div class="modal-footer"></div>
            </div>

        </div>
    </div>

    <div id="teamAdd_model" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Add New Member</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${TeamAdd!=null}">
                        <spring:form action="team_insert" method="post" class="form-group" modelAttribute="TeamAdd">
                            <div class="col-md-12">

                                <spring:input path="project.projectId" type="hidden" class="form-control" placeHolder="Project Id" value="${ProjectId}" />

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Department</label>
                                    <div class="col-md-8">
                                        <select class="form-control" name="department" id="department" onchange="loadDoc();" required="required">
                                            <option value="">- Select -</option>
                                            <c:forEach items="${DepartmentList}" var="department">
                                                <option value="${department.departmentId}">${department.departmentName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <script>
                                    function loadDoc() {
                                        var xhttp;
                                        var department = parseInt(document
                                            .getElementById('department').value);

                                        if (window.XMLHttpRequest) {
                                            // code for modern browsers
                                            xhttp = new XMLHttpRequest();
                                        } else {
                                            // code for IE6, IE5
                                            xhttp = new ActiveXObject(
                                                "Microsoft.XMLHTTP");
                                        }
                                        xhttp.onreadystatechange = function() {
                                            if (this.readyState == 4 && this.status == 200) {
                                                document
                                                    .getElementById("designationView").innerHTML = this.responseText;
                                            }
                                        };
                                        xhttp.open("GET",
                                            "designationView.html?departmentId=" + department, true);
                                        xhttp.send();
                                    }
                                </script>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Designation</label>
                                    <div class="col-md-8">

                                        <select name="desigantion" required="required" class="form-control" id="designationView" onchange="loadEmployee();">
                                            <option value="">- Select Department -</option>
                                        </select>
                                    </div>
                                </div>
                                <script>
                                    function loadEmployee() {
                                        var xhttp;
                                        var designation = parseInt(document.getElementById('designationView').value);

                                        if (window.XMLHttpRequest) {
                                            // code for modern browsers
                                            xhttp = new XMLHttpRequest();
                                        } else {
                                            // code for IE6, IE5
                                            xhttp = new ActiveXObject(
                                                "Microsoft.XMLHTTP");
                                        }
                                        xhttp.onreadystatechange = function() {
                                            if (this.readyState == 4 && this.status == 200) {
                                                document
                                                    .getElementById("employeeView").innerHTML = this.responseText;
                                            }
                                        };
                                        xhttp.open("GET", "employeesView.html?designationId=" + designation, true);
                                        xhttp.send();
                                    }
                                </script>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Employee</label>
                                    <div class="col-md-8">

                                        <spring:select path="employee.employeeId" class="form-control" id="employeeView" required="required">
                                            <option value="">- Select Designation -</option>
                                        </spring:select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Role </label>
                                    <div class="col-md-8">
                                        <label class="form-check-label">
                                            <spring:radiobutton class="form-check-input" path="teamRole" value="Leader" required="required" /> Leader
                                        </label>
                                        <label class="form-check-label">
                                            <spring:radiobutton class="form-check-input" path="teamRole" value="Member" required="required" /> Member
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group row" align="center">
                                    <div class="col-md-12">
                                        <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save">
                                    </div>
                                </div>

                            </div>
                        </spring:form>
                    </c:if>
                </div>
                <div class="modal-footer"></div>
            </div>

        </div>
    </div>

     <c:import url="headJs.jsp" />
    <c:if test="${message==null}">
        <c:if test="${ProjectEdit!=null}">
            <script>
                $("#project_model").modal();
            </script>
        </c:if>
    </c:if>

    <c:if test="${message==null}">
        <c:if test="${ProjectReleaseEdit!=null}">
            <script>
                $("#release_model").modal();
            </script>
        </c:if>
    </c:if>

    <c:if test="${message==null}">
        <c:if test="${ProjectRelease!=null}">
            <script>
                $("#releaseAdd_model").modal();
            </script>
        </c:if>
    </c:if>

    <c:if test="${message==null}">
        <c:if test="${TeamAdd!=null}">
            <script>
                $("#teamAdd_model").modal();
            </script>
        </c:if>
    </c:if>

    <c:if test="${message!=null}">
        <script>
            $("#project_model").modal("hide");
            $("#release_model").modal("hide");
            $("#releaseAdd_model").modal("hide");
            $("#teamAdd_model").modal("hide");
            $(function() {
                $("#dialog-confirm")
                    .dialog({
                        modal: true,
                        open: function(event, ui) {
                            $(".ui-dialog-titlebar-close",
                                ui.dialog | ui).hide();
                        },
                        buttons: {
                            Ok: function() {
                                $(this).dialog("close");
                                window.location = "project_view.html?id=" + <c:out value = '${ProjectId}' />;
                            }
                        }
                    });
            });
        </script>
    </c:if>
</body>

</html>
