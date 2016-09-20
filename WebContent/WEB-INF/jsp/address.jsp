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
    <title>Communication Details</title>
    <link href="images/logo1.png" rel="icon" />
    <c:import url="headCss.jsp" />
    </head>

<body>
    <div id="dialog-confirm" title="Alert" style="display:none;">
        <p>
            <c:if test="${message!=null}">
                <c:out value="${message}" /></c:if>
        </p>
    </div>
    <div class="containe">
        <div class="side-menu">
            <!-- Side Menu -->
            <c:import url="side-menu.jsp" /> </div>

        <div class="content-bar">
            <c:import url="top-menu.jsp" />

            <div class="content-main">
                <div class="col-md-12">
                    <script src="js/addressAjax.js" ></script>

                    <div id="Department-Table" role="tabpanel" class="tab-pane active">

                        <ol class="breadcrumb">
                            <li><a href="javascript:void(0)">Personal Details</a>
                            </li>
                            <li class="active">Communication Details</li>
                            <li><a href="javascript:void(0)">Education Details</a>
                            </li>
                            <li><a href="javascript:void(0)">Certification Details</a>
                            </li>
                            <li><a href="javascript:void(0)">Profile Picture</a>
                            </li>
                        </ol>

                        <div class="main-head">
                            <h1 class="title"> Communication Details </h1> </div>

                        <div class="form">

                            <spring:form action="address_add" method="post" modelAttribute="Employee" class="form-group">

                                <div class="col-md-12">

                                    <div class="col-md-6">

                                        <h5> Residential Address </h5>
                                        <hr>
                                        <div class="form-group row">
                                            <div class="col-md-8">
                                                <spring:input path="addresses[0].employee.employeeId" class="form-control" type="hidden" value="${Employee.employeeId}" id="employeeId" placeHolder="Employee Id" />
                                                <spring:input path="addresses[1].employee.employeeId" class="form-control" type="hidden" value="${Employee.employeeId}" id="employeeId" placeHolder="Employee Id" />
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                            <div class="col-md-8">
                                                <spring:textarea path="addresses[0].street" class="form-control" id="address" placeHolder="Address" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Street Minimum 5 Characters"></spring:textarea>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                            <div class="col-md-8">
                                                <spring:select path="addresses[0].country" class="countries form-control" id="countryId" required="required">
                                                    <option value="">Select Country</option>
                                                </spring:select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                            <div class="col-md-8">
                                                <spring:select path="addresses[0].state" class="states form-control" id="stateId" required="required">
                                                    <option value="">Select State</option>
                                                </spring:select>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                            <div class="col-md-8">
                                                <spring:select path="addresses[0].city" class="cities form-control" id="cityId" required="required">
                                                    <option value="">Select City</option>
                                                </spring:select>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                            <div class="col-md-8">
                                                <spring:input path="addresses[0].pincode" class="form-control" id="pincode" placeHolder="Pincode" required="required" data-validation="number" data-validation-error-msg="Pin Code Not Valid" />
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                            <div class="col-md-8">
                                                <spring:input path="addresses[0].phoneNumber" class="form-control" id="mobile" placeHolder="Mobile Number" data-validation="number" data-validation-error-msg="Mobile Number Not Valid" />
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                            <div class="col-md-8">
                                                <spring:input path="addresses[0].eMail" class="form-control" id="email" placeHolder="Email Address" required="required" data-validation="email" data-validation-error-msg="Email Address Not Valid" />
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <div class="col-md-8">
                                                <spring:input type="hidden" path="addresses[0].addressType" class="form-control" value="Current" readonly="readOnly" />
                                            </div>
                                        </div>

                                    </div>

                                    <div class="col-md-6">

                                        <h5> Permanent Address </h5>
                                        <hr>

                                        <div class="form-group row">
                                            <div class="col-md-8">
                                                <div class="form-check">
                                                    <label class="form-check-label">
                                                        <input class="form-check-input" type="checkbox" name="same" id="myCheck" onchange="loadDoc();" value="Male"> Same as Residential Address
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="address_form">
                                            <div class="form-group row">
                                                <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                                <div class="col-md-8">
                                                    <spring:textarea path="addresses[1].street" class="form-control" id="address" placeHolder="Address" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Street Minimum 5 Characters"></spring:textarea>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                                <div class="col-md-8">
                                                    <spring:select path="addresses[1].country" class="countries1 form-control" id="countryId1" required="required">
                                                        <option value="">Select Country</option>
                                                    </spring:select>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                                <div class="col-md-8">
                                                    <spring:select path="addresses[1].state" class="states1 form-control" id="stateId1" required="required">
                                                        <option value="">Select State</option>
                                                    </spring:select>

                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                                <div class="col-md-8">
                                                    <spring:select path="addresses[1].city" class="cities1 form-control" id="cityId1">
                                                        <option value="">Select City</option>
                                                    </spring:select>
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                                <div class="col-md-8">
                                                    <spring:input path="addresses[1].pincode" class="form-control" id="pincode" placeHolder="Pincode" data-validation="number" data-validation-error-msg="Pincode  Not Valid" />
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                                <div class="col-md-8">
                                                    <spring:input path="addresses[1].phoneNumber" class="form-control" id="mobile" placeHolder="Mobile Number" required="required" data-validation="number" data-validation-error-msg="Mobile Number Not Valid" />
                                                </div>
                                            </div>
                                            <script src="js/location.js"></script>

                                            <div class="form-group row">
                                                <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                                <div class="col-md-8">
                                                    <spring:input path="addresses[1].eMail" class="form-control" id="email" placeHolder="Email Address" required="required" data-validation="email" data-validation-error-msg="Email Not Valid" />
                                                </div>
                                            </div>

                                            <div class="form-group row">

                                                <div class="col-md-8">
                                                    <spring:input type="hidden" path="addresses[1].addressType" class="form-control" value="Perment" readonly="readOnly" />
                                                </div>
                                            </div>
                                        </div>

                                    </div>

                                </div>

                                <div class="form-group row">
                                    <div class="col-md-12" align="center">
                                        <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save & Next">
                                    </div>
                                </div>

                            </spring:form>

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
        <c:if test="${DepartmentEdit!=null}">
            <script>
                $("#myModal").modal();
            </script>
        </c:if>
    </c:if>

    <c:if test="${message!=null}">
        <script>
            $("#myModal").modal("hide");
            $(function() {
                $("#dialog-confirm").dialog({
                    modal: true,
                    open: function(event, ui) {
                        $(".ui-dialog-titlebar-close", ui.dialog | ui).hide();
                    },
                    buttons: {
                        Ok: function() {
                            $(this).dialog("close");
                            window.location = "employee.html";
                        }
                    }
                });
            });
        </script>

    </c:if>

</body>

</html>
