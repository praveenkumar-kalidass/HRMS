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
    <title>Allowance Details</title>
   <c:import url="headCss.jsp" />

<body>
    <div class="containe">
        <div class="side-menu">
            <!-- Side Menu -->
            <c:import url="side-menu.jsp" /> </div>

        <div class="content-bar">
            <c:import url="top-menu.jsp" />

            <div class="content-main">
                <div class="col-md-12">
                   
                    <div class="tab-content">
                        <div id="Department-Table" role="tabpanel" class="tab-pane active">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Allowance Details </h1> </div>

                                <c:if test="${AllowanceList!=null}">
                                    <table class="TableSorting">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Department Name</th>
                                                <th>Designation Name</th>
                                                <th>House Rent Allowance</th>
                                                <th>Dearness Allowance</th>
                                                <th>Provident Fund</th>
                                                <th>Medical Allowance</th>
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
                                            <c:forEach var="allowance" items="${AllowanceList}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${allowance.id}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:set var="designation" value="${allowance.designation}" />
                                                        <c:set var="department" value="${designation.department}" />
                                                        <c:out value="${department.departmentName}" />
                                                    </td>
                                                    <td>
                                                        <c:out value="${designation.designationName}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${allowance.houseRentAllowance}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${allowance.dearnessAllowance}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${allowance.providentFund}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${allowance.medicalAllowance}"></c:out>
                                                    </td>
                                                    <td>
                                                        <a href="allowance_edit.html?id=<c:out value='${allowance.id} ' />" class="edit"> <i class="fa fa-pencil"></i> Edit </a> &nbsp;&nbsp;

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
    <div id="myModal" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Allowance Varient</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${AllowanceEdit!=null}">
                        <spring:form action="allowance_update" method="post" class="form-group" modelAttribute="AllowanceEdit">
                            <div class="col-md-12">
                                <spring:input path="id" type="hidden" class="form-control" id="example-text-input" placeHolder="Designation Id" readonly="readOnly" />
                                
                                
                                 <spring:input path="designation.designationId" type="hidden" class="form-control" id="designationView" />

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">House Rent Allowance</label>
                                    <div class="col-md-8">
                                        <spring:input path="houseRentAllowance" class="form-control" id="example-text-input" placeHolder="House Rent Allowance" required="required" data-validation="number" data-validation-allowing="float" data-validation-error-msg="Enter valid Allowance" /> </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Dearness Allowance</label>
                                    <div class="col-md-8">
                                        <spring:input path="dearnessAllowance" class="form-control" id="example-text-input" placeHolder="Dearness Allowance" required="required" data-validation="number" data-validation-allowing="float" data-validation-error-msg="Enter valid Allowance" /> </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Provident Fund</label>
                                    <div class="col-md-8">
                                        <spring:input path="providentFund" class="form-control" id="example-text-input" placeHolder="Provident Fund" required="required" data-validation="number" data-validation-allowing="float" data-validation-error-msg="Enter valid Allowance" /> </div>
                                </div>

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Medical Allowance</label>
                                    <div class="col-md-8">
                                        <spring:input path="medicalAllowance" class="form-control" id="example-text-input" placeHolder="Medical Allowance" required="required" data-validation="number" data-validation-allowing="float" data-validation-error-msg="Enter valid Allowance" /> </div>
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
        <c:if test="${AllowanceEdit!=null}">
            <script>
                $("#myModal").modal();
            </script>
        </c:if>
    </c:if>

     <c:if test="${message!=null}">
            <script>
                $("#myModal").modal("hide");
                dialogConfirmation("allowance.html");
            </script>
      </c:if>
      <c:import url="dialogConfirmation.jsp" />
</body>

</html>
