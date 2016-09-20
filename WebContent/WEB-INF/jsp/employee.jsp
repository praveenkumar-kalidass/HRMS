<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${sessionScope['HRMSEmployeeId']==null}">
    <c:redirect url="index.html" />
</c:if>
<c:if test="${sessionScope['HRMSRole']=='Employee'}">
    <c:redirect url="employee_view.html?id=${HRMSEmployeeId}" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee</title>
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

                    <div id="Employee-Table" role="tabpanel" class="tab-pane active">
                        <div class="main-head">
                            <h1 class="title"> Employee Details </h1>

                        </div>

                        <div class="form">
                            <div style="padding-top:10px; padding-bottom: 10px;">
                                <a href="personal.html">
                                    <button class="btn btn-info"> <i class="fa fa-plus-circle"></i> Add New </button>
                                </a>
                            </div>
                            <c:if test="${EmployeeList!=null}">
                                <table>
                                    <thead>
                                        <tr>
                                            <th> Employee Id </th>
                                            <th> Name</th>
                                            <th> Department </th>
                                            <th> Designation</th>
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
                                        <c:forEach var="employee" items="${EmployeeList}">
                                            <tr>
                                                <td>
                                                    <c:out value="${employee.employeeId}"></c:out>
                                                </td>
                                                <td>
                                                    <a href="employee_view.html?id=<c:out value='${employee.employeeId} ' />" class="edit"> <c:out value="${employee.employeeFirstName}"></c:out> &nbsp;<c:out value="${employee.employeeLastName}"></c:out> </a>
                                                </td>
                                                <td>
                                                    <c:set value="${employee.employeeDesignation}" var="designation" />
                                                    <c:set value="${designation.department}" var="department" />
                                                    <c:out value="${department.departmentName}"></c:out>
                                                </td>
                                                <td>
                                                    <c:out value="${designation.designationName}"></c:out>
                                                </td>
                                                <td>
                                                    <a href="attendance_view.html?id=<c:out value='${employee.employeeId} ' />" > <i class="fa fa-edit"></i> View Attendance </a>
                                                </td>
                                                <td>
                                                    <a href="employee_delete.html?id=<c:out value='${employee.employeeId} ' />" class="delete"> <i class="fa fa-trash"></i> Delete </a>
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
                    <h4 class="modal-title">Edit Employee</h4> </div>
                <div class="modal-body">
                    <c:if test="${EmployeeEdit!=null}">
                        <spring:form action="employee_update" method="post" class="form-group" modelAttribute="EmployeeEdit">
                            <div class="col-md-12">

                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Employee Id</label>
                                    <div class="col-md-8">
                                        <spring:input path="employeeId" class="form-control" id="example-text-input" placeHolder="Employee Id" readonly="readOnly" /> </div>
                                </div>
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Employee First Name</label>
                                    <div class="col-md-8">
                                        <spring:input path="employeeFirstName" class="form-control" id="example-text-input" placeHolder="Employee First Name" /> </div>
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

    <link rel="stylesheet" href="css/jquery-ui.css" />
    <script src="js/jquery-3.0.0.min.js"></script>
    <script src="js/sidebar-menu.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/bootstrap.js"></script>
    <!-- jQuery -->

    <!-- Tablesorter: required for bootstrap -->
    <link rel="stylesheet" href="css/theme.bootstrap.css">
    <script src="js/jquery.tablesorter.js"></script>
    <script src="js/jquery.tablesorter.widgets.js"></script>

    <!-- Tablesorter: optional -->
    <link rel="stylesheet" href="css/jquery.tablesorter.pager.css">
    <script src="js/jquery.tablesorter.pager.js"></script>

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

            $("table").tablesorter({
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

    <script>
        function openEvent(evt, cityName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(cityName).style.display = "block";
            evt.currentTarget.className += " active";
        }
    </script>
    <c:if test="${message==null}">
        <c:if test="${EmployeeEdit!=null}">
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
