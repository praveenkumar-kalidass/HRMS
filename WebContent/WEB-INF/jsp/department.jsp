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
    <c:import url="headCss.jsp" /> </head>

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
            <c:import url="side-menu.jsp" /> 
            
         </div>

        <div class="content-bar">
            <c:import url="top-menu.jsp" />

            <div class="content-main">
                <div class="col-md-12">
                    <!-- Main Start -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#Department-Table" aria-controls="Department-Table" role="tab" data-toggle="tab">Departments</a>
                        </li>
                        <li role="presentation"><a href="#Department-Form" aria-controls="Department-Form" role="tab" data-toggle="tab">Add New</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="Department-Table" role="tabpanel" class="tab-pane active">
                            <div class="main-head">
                                <h1 class="title"> Department Details </h1> </div>

                            <div class="form">

                                <c:if test="${Department!=null}">
                                    <table class="TableSorting">
                                        <thead>
                                            <tr>
                                                <th>Department Id</th>
                                                <th>Department Name</th>
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
                                            <c:forEach var="department" items="${DepartmentList}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${department.departmentId}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${department.departmentName}"></c:out>
                                                    </td>
                                                    <td>
                                                        <a href="department_edit.html?id=<c:out value='${department.departmentId} ' />" class="edit"> <i class="fa fa-pencil"></i> Edit </a> &nbsp;&nbsp;
                                                        <a href="department_delete.html?id=<c:out value='${department.departmentId} ' />" class="delete"> <i class="fa fa-trash"></i> Delete </a>
                                                    </td>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </c:if>

                            </div>
                        </div>
                        <div id="Department-Form" role="tabpanel" class="tab-pane">
                            <div class="main-head">
                                <h1 class="title"> Add New Department  </h1>
                            </div>
                            <div class="single-rowform col-md-12">
                                <c:if test="${Department!=null}">
                                    <spring:form action="department_insert" method="post" class="form-group" modelAttribute="Department">
                                        <div class="col-md-12 single-rowform">

                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">Department Name</label>
                                                    <div class="col-md-8">
                                                        <spring:input path="departmentName" class="form-control" id="example-text-input" placeHolder="Department Name" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Data Minimum 5 Characters" /> </div>
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
    <div id="myModal" class="modal fade" role="dialog" aria-hidden="false" data-backdrop="static" >
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Department</h4> </div>
                <div class="modal-body">
                    <c:if test="${DepartmentEdit!=null}">
                        <spring:form action="department_update" method="post" class="form-group" modelAttribute="DepartmentEdit">
                            <div class="col-md-12">

                                <spring:input path="departmentId" type="hidden" class="form-control" id="example-text-input" placeHolder="Department Id" readonly="readOnly" />

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Department Name</label>
                                    <div class="col-md-8">
                                        <spring:input path="departmentName" class="form-control" placeHolder="Department Name" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Data Minimum 5 Characters" /> </div>
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
                                window.location = "department.html";
                            }
                        }
                    });
                });
            </script>
        </c:if>
</body>

</html>
