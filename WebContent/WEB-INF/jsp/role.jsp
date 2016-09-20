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
    <title>Role</title>
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
            <c:import url="side-menu.jsp" /> </div>

        <div class="content-bar">
            <c:import url="top-menu.jsp" />

            <div class="content-main">
                <div class="col-md-12">
                    <!-- Main Start -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#Role-Table" aria-controls="Role-Table" role="tab" data-toggle="tab">Roles</a>
                        </li>
                        <li role="presentation"><a href="#Role-Form" aria-controls="Role-Form" role="tab" data-toggle="tab">Add New</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="Role-Table" role="tabpanel" class="tab-pane active">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Role Details </h1> </div>

                                <c:if test="${RoleList!=null}">
                                    <table class="TableSorting">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Name</th>

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
                                            <c:forEach var="role" items="${RoleList}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${role.roleId}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${role.roleName}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:set value="${designation.department}" var="department" />
                                                        <c:out value="${department.departmentName}"></c:out>
                                                    </td>
                                                    <td>
                                                        <a href="role_edit.html?id=<c:out value='${role.roleId} ' />" class="edit"> <i class="fa fa-pencil"></i> Edit </a> &nbsp;&nbsp;
                                                        <a href="role_delete.html?id=<c:out value='${role.roleId} ' />" class="delete"> <i class="fa fa-trash"></i> Delete </a>

                                                    </td>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </c:if>
                            </div>
                        </div>
                        <div id="Role-Form" role="tabpanel" class="tab-pane">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Role Details </h1> </div>
                                <div class="single-rowform">
                                    <c:if test="${Role!=null}">
                                        <spring:form action="role_insert" method="post" class="form-group" modelAttribute="Role">
                                            <div class="col-md-12">

                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Role Name</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="roleName" class="form-control" id="example-text-input" placeHolder="Role Name" required="required" data-validation="length" data-validation-length="min3" data-validation-error-msg="Please Enter the Valid Data Minimum 3 Characters" /> </div>
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
                    <h4 class="modal-title">Edit Role</h4> </div>
                <div class="modal-body">
                    <c:if test="${RoleEdit!=null}">
                        <spring:form action="role_update" method="post" class="form-group" modelAttribute="RoleEdit">
                            <div class="col-md-12">

                                <spring:input path="roleId" type="hidden" class="form-control" id="example-text-input" placeHolder="Role Id" readonly="readOnly" />
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Role Name</label>
                                    <div class="col-md-8">
                                        <spring:input path="roleName" class="form-control" id="example-text-input" placeHolder="Role Name" required="required" data-validation="length" data-validation-length="min3" data-validation-error-msg="Please Enter the Valid Data Minimum 3 Characters" /> </div>
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
        <c:if test="${RoleEdit!=null}">
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
                            window.location = "role.html";
                        }
                    }
                });
            });
        </script>
    </c:if>
</body>

</html>
