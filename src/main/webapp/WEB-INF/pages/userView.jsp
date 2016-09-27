<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Details</title>
    <link href="images/logo1.png" rel="icon" />
   <c:import url="headCss.jsp" />
</head>

<body>
  
    <div class="containe">
        <div class="side-menu">
            <!-- Side Menu -->
            <c:import url="side-menu.jsp" />
        </div>

        <div class="content-bar">
            <c:import url="top-menu.jsp" />
            <c:set value="${User}" var="user" />

            <div class="content-main">
                <div class="col-md-12">
                    <!-- Main Start -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#Personal-Details" aria-controls="Department-Table" role="tab" data-toggle="tab">Personal Details</a>
                        </li>
                        <li role="presentation"><a href="#Communication-Details" aria-controls="Department-Table" role="tab" data-toggle="tab">Communication
								Details</a>
                        </li>
                        <li role="presentation"><a href="#Education-Details" aria-controls="Department-Table" role="tab" data-toggle="tab">Education
								Details</a>
                        </li>
                        <li role="presentation"><a href="#Certification-Details" aria-controls="Department-Table" role="tab" data-toggle="tab">Certification
								Details</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="Personal-Details" role="tabpanel" class="tab-pane active">
                            <div class="main-head">
                                <h1 class="title" style="float: left; width: 80%;">
									Personal Details</h1>
									<c:if test="${sessionScope['currentRole']=='ROLE_ADMIN'}">
                                <a href="personal_edit.html?id=<c:out value='${user.id}' />" style="float: right; width: 20%; padding-top: 26px;" class="edit"> <i class="fa fa-pencil"></i> Edit Personal Details
                                </a>
                                </c:if>
                            </div>

                            <div class="form">
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <div class="col-md-12">
                                            <img src="upload/<c:out value='${user.picture}' />" width="250" height="300" />
                                        </div>
                                        <div class="col-md-12" style="padding-top: 10px; margin-left: 65px;">
                                            <a href="picture_edit.html?id=<c:out value='${user.id}' />" class="edit">
                                                <button class="btn btn-info">
                                                    <i class="fa fa-pencil"></i> Edit Picture
                                                </button>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="form-group row"></div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Employee Id </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${user.id}' />
                                            </label>
                                        </div>
                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> First Name </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${user.firstName}' />
                                            </label>
                                        </div>
                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Last Name </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${user.lastName}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Date of Birth </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${user.dateOfBirth}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Gender</label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${user.gender}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Marital Status</label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${user.maritalStatus}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Date of Joining </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${user.dateOfJoining}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Department</label>
                                            <c:set value="${user.designation}" var="designation" />
                                            <c:set value="${designation.department}" var="department" />

                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${department.departmentName}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Designation</label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${designation.designationName}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Account Number </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${user.bankAccountNumber}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> User Name</label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${user.username}' />
                                            </label>
                                        </div>

                                        
                                    </div>

                                </div>

                            </div>
                        </div>
                        <div id="Communication-Details" role="tabpanel" class="tab-pane">
                            <div class="main-head">
                                <h1 class="title">Communication Details</h1>
                            </div>
                            <div class="col-md-12">

                                <c:forEach items="${AddressList}" var="address">

                                    <div class="col-md-6">
                                        <div class="col-md-12" style="margin: 0px; padding: 0px;">
                                            <h5 class="title" style="float: left; width: 80%;">
												<c:out value='${address.addressType}' />
												Details
											</h5>
                                            <a href="address_edit.html?id=<c:out value='${address.addressId}' />" style="float: right; width: 20%; padding-top: 5px;" class="edit"> <i class="fa fa-pencil"></i> Edit
                                            </a>
                                            <div class="col-md-12" style="margin: 0px; padding: 0px;">
                                                <hr style="margin-top: 5px;">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Address </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${address.street}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> City </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${address.city}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> State </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${address.state}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Country </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${address.country}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Pin Code </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${address.pincode}' />
                                            </label>
                                        </div>
                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Phone Number </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${address.phoneNumber}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Email </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${address.eMail}' />
                                            </label>
                                        </div>

                                    </div>
                                </c:forEach>

                            </div>

                        </div>

                        <div id="Education-Details" role="tabpanel" class="tab-pane">
                            <div class="main-head">
                                <h1 class="title">Education Details</h1>
                            </div>
                            <c:forEach items="${EducationList}" var="education">

                                <div class="col-md-12">
                                    <div class="col-md-12" style="margin: 0px; padding: 0px;">
                                        <h5 class="title" style="float: left; width: 80%;">
											<c:out value='${education.type}' />
											Details
										</h5>
                                        <a href="education_edit.html?id=<c:out value='${education.educationId}' />" style="float: right; width: 20%; padding-top: 5px;" class="edit"> <i class="fa fa-pencil"></i> Edit
                                        </a>
                                        <div class="col-md-12" style="margin: 0px; padding: 0px;">
                                            <hr style="margin-top: 5px;">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Course Name </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${education.qualification}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> From Date </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${education.fromDate}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> To Date </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${education.toDate}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Institute Name </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${education.institution}' />
                                        </label>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Board/University Name </label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${education.board}' />
                                        </label>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-6 col-form-label"> Percentage</label>
                                        <label for="example-text-input" class="col-md-6">
                                            <c:out value='${education.percentage}' />
                                        </label>
                                    </div>

                                </div>

                            </c:forEach>

                        </div>

                        <div id="Certification-Details" role="tabpanel" class="tab-pane">
                            <div class="main-head">
                                <h1 class="title">Certification Details</h1>
                            </div>

                            <c:if test="${CertificationList!=null}">
                                <c:forEach items="${CertificationList}" var="certification">

                                    <div class="col-md-12">
                                        <div class="col-md-12" style="margin: 0px; padding: 0px;">
                                            <h5 class="title" style="float: left; width: 80%;">
												<c:out value='${certification.courseName}' />
												Details
											</h5>
                                            <a href="certification_edit.html?id=<c:out value='${certification.certificationId}' />" style="float: right; width: 20%; padding-top: 5px;" class="edit"> <i class="fa fa-pencil"></i> Edit
                                            </a>
                                            <div class="col-md-12" style="margin: 0px; padding: 0px;">
                                                <hr style="margin-top: 5px;">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Course Name </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${certification.courseName}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> From Date </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${certification.fromDate}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> To Date </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${certification.toDate}' />
                                            </label>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-6 col-form-label"> Institute Name </label>
                                            <label for="example-text-input" class="col-md-6">
                                                <c:out value='${certification.institution}' />
                                            </label>
                                        </div>

                                    </div>

                                </c:forEach>
                            </c:if>
                            <c:if test="${CertificationList==null}">

                                <h5>No Certifications</h5>

                            </c:if>

                        </div>

                    </div>

                    <!-- Main End -->
                </div>
            </div>
        </div>
    </div>

    <div id="certification_model" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Certification Details</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${CertificateEdit!=null}">
                        <spring:form action="certification_update" method="post" class="form-group" modelAttribute="CertificateEdit" enctype="multipart/form-data">
                            <div class="col-md-12">

                                <spring:input path="user.id" type="hidden" class="form-control" id="example-text-input" placeHolder="Department Id" readonly="readOnly" />
                                <spring:input path="certificationId" type="hidden" class="form-control" id="example-text-input" placeHolder="Department Id" readonly="readOnly" />

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Course Name </label>
                                    <div class="col-md-8">
                                        <spring:input path="courseName" class="form-control"  required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Name Minimum 5 Characters" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">From Date
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
                                            <input class="form-control" size="16" type="text" value="<c:out value='${CertificateEdit.fromDate}' />" readonly> <span class="input-group-addon"><span
												class="fa fa-calendar"></span></span>
                                        </div>
                                        <spring:input path="fromDate" id="dtp_input1" type="hidden" class="form-control" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">To Date
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                            <input class="form-control" size="16" type="text" value="<c:out value='${CertificateEdit.toDate}' />" readonly>
                                            <span class="input-group-addon"><span
												class="fa fa-calendar"></span></span>
                                        </div>
                                        <spring:input path="toDate" id="dtp_input2" type="hidden" class="form-control" />

                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Name of the Institution</label>
                                    <div class="col-md-8">
                                        <spring:input path="institution" class="form-control" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Name Minimum 5 Characters" />
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
    <div id="education_model" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Education Details</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${EducationEdit!=null}">
                        <spring:form action="education_update" method="post" class="form-group" modelAttribute="EducationEdit" enctype="multipart/form-data">
                            <div class="col-md-12">

                                <spring:input path="user.id" type="hidden" class="form-control" id="example-text-input" placeHolder="Department Id" readonly="readOnly" />
                                <spring:input path="educationId" type="hidden" class="form-control" id="example-text-input" placeHolder="Department Id" readonly="readOnly" />
                                <spring:input path="type" type="hidden" class="form-control" id="example-text-input" placeHolder="Department Id" readonly="readOnly" />

                                <c:if test="${EducationEdit.type!='SSLC' && EducationEdit.type!='HSC'}">
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Degree & Course Name
                                            <br> Ex : BE(CSE)
                                        </label>
                                        <div class="col-md-8">
                                            <spring:input path="qualification" class="form-control" required="required" />
                                        </div>
                                    </div>
                                </c:if>

                                <c:if test="${EducationEdit.type=='HSC'}">
                                    <div class="form-group row">
                                        <spring:input path="qualification" type="hidden" class="form-control" required="required" />

                                    </div>
                                </c:if>

                                <c:if test="${EducationEdit.type =='SSLC'}">
                                    <div class="form-group row">
                                        <spring:input path="qualification" type="hidden" class="form-control" required="required" />
                                    </div>
                                </c:if>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">From Date
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
                                            <input class="form-control" size="16" type="text" value="<c:out value='${EducationEdit.fromDate}' />" readonly>
                                            <span class="input-group-addon"><span
												class="fa fa-calendar"></span></span>
                                        </div>
                                        <spring:input path="fromDate" id="dtp_input1" type="hidden" class="form-control" />

                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">To Date
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                            <input class="form-control" size="16" type="text" value="<c:out value='${EducationEdit.toDate}' />" readonly>
                                            <span class="input-group-addon"><span
												class="fa fa-calendar"></span></span>
                                        </div>
                                        <spring:input path="toDate" id="dtp_input2" type="hidden" class="form-control" />

                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Name of the Institution</label>
                                    <div class="col-md-8">
                                        <spring:input path="institution" class="form-control" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Name Minimum 5 Characters" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Board/ University
                                    </label>
                                    <div class="col-md-8">
                                        <spring:input path="board" class="form-control" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Board Minimum 5 Characters" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Percentage</label>
                                    <div class="col-md-8">
                                        <spring:input path="percentage" class="form-control" required="required" data-validation="number" data-validation-allowing="float" data-validation-error-msg="Enter valid Percentage"  />
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

    <div id="address_model" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Address Details</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${AddressEdit!=null}">
                        <spring:form action="address_update" method="post" class="form-group" modelAttribute="AddressEdit" enctype="multipart/form-data">
                            <div class="col-md-12">

                                <spring:input path="user.id" type="hidden" class="form-control" id="example-text-input" placeHolder="Department Id" readonly="readOnly" />
                                <spring:input path="addressId" type="hidden" class="form-control" id="example-text-input" placeHolder="Department Id" readonly="readOnly" />

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                    <div class="col-md-8">
                                        <spring:textarea path="street" class="form-control" id="address" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Street Minimum 5 Characters" placeHolder="Address" required="required"></spring:textarea>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                    <div class="col-md-8">
                                        <spring:select path="country" class="countries form-control" id="countryId" required="required">
                                            <option value="">-----------------</option>
                                        </spring:select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                    <div class="col-md-8">
                                        <spring:select path="state" class="states form-control" id="stateId" required="required">
                                            <option value="<c:out value='${AddressEdit.state}' />">
                                                <c:out value="${AddressEdit.state}" />
                                            </option>
                                            <option value="">-----------------</option>
                                        </spring:select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                    <div class="col-md-8">
                                        <spring:select path="city" class="cities form-control" id="cityId" required="required">
                                            <option value="<c:out value='${AddressEdit.city}' />">
                                                <c:out value="${AddressEdit.city}" />
                                            </option>
                                            <option value="">-----------------</option>
                                        </spring:select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                    <div class="col-md-8">
                                        <spring:input path="pincode" class="form-control" id="pincode" required="required" placeHolder="Pincode" data-validation="number" data-validation-error-msg="Pin Code Not Valid" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number
                                    </label>
                                    <div class="col-md-8">
                                        <spring:input path="phoneNumber" class="form-control" id="mobile" placeHolder="Mobile Number" required="required" data-validation="number" data-validation-error-msg="Mobile Number Not Valid" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Email Address
                                    </label>
                                    <div class="col-md-8">
                                        <spring:input path="eMail" class="form-control" id="email" placeHolder="Email Address" required="required" data-validation="email" data-validation-error-msg="Email Address Not Valid"/>
                                    </div>
                                </div>
                                <spring:input path="addressType" type="hidden" class="form-control" id="email"  />
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

    <div id="picture_model" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Update Picture</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${PictureEdit!=null}">
                        <spring:form action="picture_update" method="post" class="form-group" modelAttribute="PictureEdit" enctype="multipart/form-data">
                            <div class="col-md-12">

                                <spring:input path="id" type="hidden" class="form-control" id="example-text-input" placeHolder="Department Id" readonly="readOnly" />

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">New Picture
                                    </label>
                                    <div class="col-md-8">
                                        <spring:input path="picture" class="form-control" type="file" required="required"  placeHolder="Select Image" />
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
    <div id="personal_model" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Personal Details</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${PersonalEdit!=null}">
                        <spring:form action="personal_update" method="post" class="form-group" modelAttribute="PersonalEdit">
                            <div class="col-md-12">

                                <spring:input path="id" type="hidden" class="form-control" id="example-text-input" readonly="readOnly" />
                                <spring:input path="picture" type="hidden" class="form-control" id="example-text-input" readonly="readOnly" />

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">First Name
                                    </label>
                                    <div class="col-md-8">
                                        <spring:input path="firstName" class="form-control" placeHolder="First Name" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Name Minimum 5 Characters" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Last Name
                                    </label>
                                    <div class="col-md-8">
                                        <spring:input path="lastName" class="form-control" placeHolder="Last Name" required="required" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Gender</label>
                                    <div class="col-md-8">
                                        <div class="form-check">
                                            <c:if test="${PersonalEdit.gender == 'Male'}">
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="gender" checked="checked" value="Male" required="required" /> Male
                                                </label>
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="gender" value="Female" required="required" /> Female
                                                </label>
                                            </c:if>

                                            <c:if test="${PersonalEdit.gender == 'Female'}">
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="gender" value="Male" required="required" /> Male
                                                </label>
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="gender" checked="checked" value="Female" required="required" /> Female
                                                </label>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Date of Birth</label>
                                    <div class="col-md-8">
                                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                            <input class="form-control" size="16" type="text" value="<c:out value='${PersonalEdit.dateOfBirth}' />" readonly> <span class="input-group-addon"><span
												class="fa fa-calendar"></span></span>
                                        </div>
                                        <spring:input path="dateOfBirth" id="dtp_input2" type="hidden" class="form-control" placeHolder="Date of Birth" />
                                    </div>

                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Marital Status
                                    </label>
                                    <div class="col-md-8">
                                        <div class="form-check">
                                            <c:if test="${PersonalEdit.maritalStatus == 'Married'}">
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="maritalStatus" checked="checked" value="Married" required="required" /> Married
                                                </label>
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="maritalStatus" value="Unmarried" required="required" /> Unmarried
                                                </label>
                                            </c:if>

                                            <c:if test="${PersonalEdit.maritalStatus == 'Unmarried'}">
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="maritalStatus" value="Married" required="required" /> Married
                                                </label>
                                                <label class="form-check-label">
                                                    <spring:radiobutton class="form-check-input" path="maritalStatus" checked="checked" value="Unmarried" required="required" /> Unmarried
                                                </label>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Date of Joining</label>
                                        <div class="col-md-8">

                                            <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input3" data-link-format="yyyy-mm-dd">
                                                <input class="form-control" size="16" type="text" value="<c:out value='${PersonalEdit.dateOfJoining}' />" readonly> <span class="input-group-addon"><span
												class="fa fa-calendar"></span></span>
                                            </div>
                                            <spring:input path="dateOfJoining" id="dtp_input3" type="hidden" class="form-control" placeHolder="Date of Joining" />
                                        </div>
                                    </div>
                               

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Department</label>
                                        <div class="col-md-8">
                                            <select class="form-control" name="department" id="department" onchange="designationLoad();" required="required">
                                                <c:set value="${PersonalEdit.designation}" var="Personaldesignation" />
                                                <c:set value="${Personaldesignation.department}" var="Personaldepartment" />
                                                <option value="<c:out value='${Personaldepartment.departmentId}' />">
                                                    <c:out value='${Personaldepartment.departmentName}' />
                                                </option>
                                                <option value="">---------</option>
                                                <c:forEach items="${DepartmentList}" var="department">
                                                    <option value="${department.departmentId}">${department.departmentName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                   
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Designation</label>
                                        <div class="col-md-8">

                                            <spring:select path="designation.designationId" class="form-control" id="designationView" required="required">
                                                <option value="${Personaldesignation.designationId}">${Personaldesignation.designationName}</option>
                                            </spring:select>
                                        </div>
                                    </div>
                               
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Bank Account Number</label>
                                        <div class="col-md-8">
                                            <spring:input path="bankAccountNumber" class="form-control" placeHolder="Account Number" required="required" data-validation="number" data-validation-error-msg="Enter valid AccountNumber" />
                                        </div>
                                    </div>
                               
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Basic Pay
                                        </label>
                                        <div class="col-md-8">
                                            <spring:input path="basicPay" class="form-control" placeHolder="Basic Pay" required="required" data-validation="number" data-validation-allowing="float" data-validation-error-msg="Enter valid Basic Pay" />
                                        </div>
                                    </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">User Name
                                    </label>
                                    <div class="col-md-8">
                                        <spring:input path="username" class="form-control" placeHolder="Username" required="required" />
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label"> Password
                                    </label>
                                    <div class="col-md-8"> 
                                        <spring:input path="password" type="password" class="form-control" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Strong Password Minimum 5 Characters" placeHolder="Password" />
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
        <c:if test="${PictureEdit!=null}">
            <script>
                $("#picture_model").modal();
            </script>
        </c:if>
    </c:if>

    <c:if test="${message==null}">
        <c:if test="${PersonalEdit!=null}">
            <script>
                $("#personal_model").modal();
            </script>
        </c:if>
    </c:if>

    <c:if test="${message==null}">
        <c:if test="${EducationEdit!=null}">
            <script>
                $("#education_model").modal();
            </script>
        </c:if>
    </c:if>

    <c:if test="${message==null}">
        <c:if test="${CertificateEdit!=null}">
            <script>
                $("#certification_model").modal();
            </script>
        </c:if>
    </c:if>

    <c:if test="${message==null}">
        <c:if test="${AddressEdit!=null}">
            <script>
                $("#address_model").modal();
            </script>
        </c:if>
    </c:if>
     <c:if test="${message!=null}">
            <script>
               $("#picture_model").modal("hide");
               $("#personal_model").modal("hide");
               $("#address_model").modal("hide");
               $("#education_model").modal("hide");
               $("#certification_model").modal("hide");
               dialogConfirmation("user_view.html?id=" + <c:out value = '${UserId}' />);
            </script>
        </c:if>
        <c:import url="dialogConfirmation.jsp" />
</body>

</html>
