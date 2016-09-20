<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope['HRMSEmployeeId']==null}">
    <c:redirect url="index.html" />
</c:if>
<c:if test="${sessionScope['HRMSRole']=='Employee'}">
    <c:redirect url="project_view.html?id=${HRMSProjectId}" />
</c:if>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Client</title>
    <link href="images/logo1.png" rel="icon" />
    <c:import url="headCss.jsp" />  </head>

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
                    <!-- Main Start -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#Client-Table" aria-controls="Client-Table" role="tab" data-toggle="tab">Clients</a>
                        </li>
                        <li role="presentation"><a href="#Client-Form" aria-controls="Client-Form" role="tab" data-toggle="tab">Add New</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="Client-Table" role="tabpanel" class="tab-pane active">
                            <div class="main-head">
                                <h1 class="title"> Client Details </h1> </div>

                            <div class="form">

                                <c:if test="${Client!=null}">
                                    <table class="TableSorting">
                                        <thead>
                                            <tr>
                                                <th>Client Id</th>
                                                <th>Client Name</th>
                                                <th>Address</th>
                                                <th>Email</th>
                                                <th>Phone Number</th>
                                                <th>WebSite</th>
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
                                            <c:forEach var="client" items="${ClientList}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${client.clientId}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${client.clientName}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${client.street}" />
                                                        <br>
                                                        <c:out value="${client.city}" />
                                                        <br>
                                                        <c:out value="${client.state}" />
                                                        <br>
                                                        <c:out value="${client.country}" />
                                                    </td>
                                                    <td>
                                                        <c:out value="${client.eMail}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${client.phoneNumber}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${client.website}"></c:out>
                                                    </td>
                                                    <td>
                                                        <a href="client_edit.html?id=<c:out value='${client.clientId} ' />" class="edit"> <i class="fa fa-pencil"></i> Edit </a> &nbsp;&nbsp;
                                                        <a href="client_delete.html?id=<c:out value='${client.clientId} ' />" class="delete"> <i class="fa fa-trash"></i> Delete </a>
                                                    </td>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </c:if>

                            </div>
                        </div>
                        <div id="Client-Form" role="tabpanel" class="tab-pane">
                            <div class="main-head">
                                <h1 class="title"> Add New Client  </h1>
                            </div>
                            <div class="single-rowform col-md-12">
                                <c:if test="${Client!=null}">
                                    <spring:form action="client_insert" method="post" class="form-group" modelAttribute="Client">
                                        <div class="col-md-12 single-rowform">

                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">Client Name</label>
                                                    <div class="col-md-8">
                                                        <spring:input path="clientName" class="form-control" id="example-text-input" placeHolder="Client Name" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Name Minimum 5 Characters" /> </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">Address </label>
                                                    <div class="col-md-8">
                                                        <spring:textarea path="street" class="form-control" id="address" required="required" placeHolder="Address" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Street Minimum 5 Characters"></spring:textarea>
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                                    <div class="col-md-8">
                                                        <spring:select path="country" class="countries form-control" id="countryId" required="required">
                                                            <option value="">Select Country</option>
                                                        </spring:select>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                                    <div class="col-md-8">
                                                        <spring:select path="state" class="states form-control" id="stateId" required="required">
                                                            <option value="">Select State</option>
                                                        </spring:select>
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                                    <div class="col-md-8">
                                                        <spring:select path="city" class="cities form-control" id="cityId" required="required">
                                                            <option value="">Select City</option>
                                                        </spring:select>
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                                    <div class="col-md-8">
                                                        <spring:input path="phoneNumber" class="form-control" id="mobile" placeHolder="Mobile Number" required="required" data-validation="number" data-validation-error-msg="Mobile Number Not Valid" />
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                                    <div class="col-md-8">
                                                        <spring:input path="eMail" class="form-control" id="email" placeHolder="Email Address" required="required" data-validation="email" data-validation-error-msg="Email Not Valid" />
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">WebSite</label>
                                                    <div class="col-md-8">
                                                        <spring:input path="website" class="form-control" id="WebSite" placeHolder="WebSite" />
                                                    </div>
                                                </div>

                                                <div class="form-group row" align="center">
                                                    <div class="col-md-12">
                                                        <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save"> </div>
                                                </div>
                                            </div>
                                        </div>
                                    </spring:form>
                                </c:if>
                            </div>
                        </div>

                    </div>

                    <!-- Main End -->
                </div>
            </div>
        </div>
    </div>
    <div id="myModal" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Client</h4> </div>
                <div class="modal-body">
                    <c:if test="${ClientEdit!=null}">
                        <spring:form action="client_update" method="post" class="form-group" modelAttribute="ClientEdit">

                            <spring:input path="clientId" type="hidden" class="form-control" id="example-text-input" placeHolder="Client Id" />
                            <div class="col-md-12">
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Client Name</label>
                                    <div class="col-md-8">
                                        <spring:input path="clientName" class="form-control" id="example-text-input" required="required" placeHolder="Client Name" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Name Minimum 5 Characters" /> </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Address </label>
                                    <div class="col-md-8">
                                        <spring:textarea path="street" class="form-control" id="address" required="required" placeHolder="Address" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Street Minimum 5 Characters"></spring:textarea>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                    <div class="col-md-8">
                                        <spring:select path="country" class="countries form-control" id="countryId" required="required">
                                            <option value="">Select Country</option>
                                        </spring:select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                    <div class="col-md-8">
                                        <spring:select path="state" class="states form-control" id="stateId" required="required">
                                            <option value="">Select State</option>
                                        </spring:select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                    <div class="col-md-8">
                                        <spring:select path="city" class="cities form-control" id="cityId" required="required">
                                            <option value="">Select City</option>
                                        </spring:select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                    <div class="col-md-8">
                                        <spring:input path="phoneNumber" class="form-control" id="mobile" placeHolder="Mobile Number" required="required" data-validation="number" data-validation-error-msg="Mobile Number Not Valid" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                    <div class="col-md-8">
                                        <spring:input path="eMail" class="form-control" id="email" placeHolder="Email Address" required="required" data-validation="email" data-validation-error-msg="Email Not Valid" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">WebSite</label>
                                    <div class="col-md-8">
                                        <spring:input path="website" class="form-control" id="WebSite" placeHolder="WebSite" required="required" />
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
                <div class="modal-footer"> </div>
            </div>

        </div>
    </div>

    <c:import url="headJs.jsp" />

    <c:if test="${message==null}">
        <c:if test="${ClientEdit!=null}">
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
                            window.location = "client.html";
                        }
                    }
                });
            });
        </script>
    </c:if>
</body>

</html>
