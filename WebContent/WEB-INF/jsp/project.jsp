<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope['HRMSEmployeeId']==null}">
    <c:redirect url="index.html" />
</c:if>
<c:if test="${sessionScope['HRMSRole']=='Employee'}">
    <c:if test="${sessionScope['HRMSProjectId']==null}">
        <c:redirect url="employee_view.html?id=${HRMSEmployeeId}" />
    </c:if>
    <c:if test="${sessionScope['HRMSProjectId']!=null}">
        <c:redirect url="project_view.html?id=${HRMSProjectId}" />
    </c:if>
</c:if>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Project Details</title>
    <link href="images/logo1.png" rel="icon" />
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/sidebar-menu.css"> </head>

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
                        <li role="presentation" class="active"><a href="#Client-Table" aria-controls="Client-Table" role="tab" data-toggle="tab">Projects</a>
                        </li>
                        <li role="presentation"><a href="#Client-Form" aria-controls="Client-Form" role="tab" data-toggle="tab">Add New</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="Client-Table" role="tabpanel" class="tab-pane active">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Project Details </h1> </div>

                                <c:if test="${ProjectList!=null}">
                                    <table id="ProjectTable">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Project Name</th>
                                                <th>From Date</th>
                                                <th>Client Name</th>
                                                <th>Description</th>
                                                <th>Status</th>

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
                                            <c:forEach var="project" items="${ProjectList}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${project.projectId}"></c:out>
                                                    </td>
                                                    <td>
                                                      <a href="project_view.html?id=<c:out value='${project.projectId} ' />" class="edit">   <c:out value="${project.projectName}"></c:out> </a>
                                                    </td>
                                                    <td>
                                                        <c:out value="${project.fromDate}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:set value="${project.client}" var="client" />
                                                        <c:out value="${client.clientName}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${project.description}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${project.status}"></c:out>
                                                    </td>
                                                    <td>
                                                        <a href="project_delete.html?id=<c:out value='${project.projectId} ' />" class="delete"> <i class="fa fa-trash"></i> Delete </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </c:if>
                            </div>
                        </div>
                        <div id="Client-Form" role="tabpanel" class="tab-pane">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Add New Project </h1> </div>
                                <div class="single-rowform">
                                    <c:if test="${Project!=null}">
                                        <spring:form action="project_insert" method="post" class="form-group" modelAttribute="Project">
                                            <div class="col-md-12">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Project Name</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="projectName" class="form-control" id="example-text-input" placeHolder="Project Name" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Data Minimum 5 Characters" /> </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Date of Started</label>

                                                        <div class="col-md-8">

                                                            <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                                                <input class="form-control" size="16" type="text" value="" readonly placeHolder="Date of Started">
                                                                <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                                            </div>
                                                            <spring:input path="fromDate" id="dtp_input2" type="hidden" class="form-control" placeHolder="Date of Started" />
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Client</label>
                                                        <div class="col-md-8">

                                                            <spring:select path="client.clientId" class="form-control">
                                                                <spring:option value="0"> --Select --</spring:option>
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

                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Status</label>
                                                        <div class="col-md-8">
                                                            <div class="form-check">
                                                                <label class="form-check-label">
                                                                    <spring:radiobutton class="form-check-input" path="status" value="Active" checked="checked" required="required" /> Active
                                                                </label>
                                                                <label class="form-check-label">
                                                                    <spring:radiobutton class="form-check-input" path="status" value="Completed" required="required" /> Completed
                                                                </label>
                                                                <label class="form-check-label">
                                                                    <spring:radiobutton class="form-check-input" path="status" value="Dropped" required="required" /> Dropped
                                                                </label>
                                                            </div>
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

                    </div>

                    <!-- Main End -->
                </div>
            </div>
        </div>
    </div>


    <link rel="stylesheet" href="css/jquery-ui.css" />
    <script src="js/jquery-3.0.0.min.js"></script>
    <script src="js/sidebar-menu.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/bootstrap.js"></script>

    <!-- Tablesorter: required for bootstrap -->
    <link rel="stylesheet" href="css/theme.bootstrap.css">
    <script src="js/jquery.tablesorter.js"></script>
    <script src="js/jquery.tablesorter.widgets.js"></script>

    <!-- Tablesorter: optional -->
    <link rel="stylesheet" href="css/jquery.tablesorter.pager.css">
    <script src="js/jquery.tablesorter.pager.js"></script>

    <link href="css/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script src="js/jquery.form-validator.min.js"></script>
    <script>
        $.validate({
            lang: 'en',
            borderColorOnError: '#F00',
        });
    </script>
    <script type="text/javascript">
        $('.form_date').datetimepicker({
            language: 'en',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    </script>

    <script id="js">
        $(function() {
            $.tablesorter.themes.bootstrap = {
                table: 'table table-bordered table-striped',
                caption: 'caption',
                header: 'bootstrap-header',
                sortNone: '',
                sortAsc: '',
                sortDesc: '',
                active: '',
                hover: '',
                icons: '',
                iconSortNone: 'fa fa-sort',
                iconSortAsc: 'fa fa-sort-asc',
                iconSortDesc: 'fa fa-sort-desc ',
                filterRow: '',
                footerRow: '',
                footerCells: '',
                even: '',
                odd: ''
            };

            $("#ProjectTable").tablesorter({
                    theme: "bootstrap",

                    widthFixed: true,

                    headerTemplate: '{content} {icon}',

                    widgets: ["uitheme", "filter", "zebra"],

                    widgetOptions: {
                        zebra: ["even", "odd"],

                        filter_reset: ".reset",

                        filter_cssFilter: "form-control",

                    }
                })
                .tablesorterPager({

                    container: $(".ts-pager"),
                    cssGoto: ".pagenum",
                    removeRows: false,
                    output: '{startRow} - {endRow} / {filteredRows} ({totalRows})'

                });

        });
    </script>

    <script>
        $.sidebarMenu($('.sidebar-menu'));
    </script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $('#tabs').tab();
        });
    </script>

    <c:if test="${message==null}">
        <c:if test="${ProjectEdit!=null}">
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
                            window.location = "project.html";
                        }
                    }
                });
            });
        </script>
    </c:if>
</body>

</html>
