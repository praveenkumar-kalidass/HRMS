<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Attendance Details</title>
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
                        <li role="presentation" class="active"><a href="#Employee-Table" aria-controls="Employee-Table" role="tab" data-toggle="tab">Attendances</a>
                        </li>
                        <li role="presentation"><a href="#Employee-Form" aria-controls="Employee-Form" role="tab" data-toggle="tab">Check-In</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="Employee-Table" role="tabpanel" class="tab-pane active">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Attendance Details </h1> </div>

                                <c:if test="${AttendanceList!=null}">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Date</th>
                                                <th>Time-In</th>
                                                <th>Time-Out</th>
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
                                            <c:forEach var="attendance" items="${AttendanceList}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${attendance.attendanceId}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${attendance.date}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${attendance.timeIn}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${attendance.timeOut}"></c:out>
                                                    </td>
                                                    <td>
                                                        <a href="attendance_edit.html?id=<c:out value='${attendance.attendanceId} ' />" class="edit"> <i class="fa fa-pencil"></i> Checkout </a> &nbsp;&nbsp;
                                                    </td>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </c:if>




                            </div>
                        </div>
                        <div id="Employee-Form" role="tabpanel" class="tab-pane">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Check-In </h1> </div>
                                <div class="single-rowform">
                                    <c:if test="${Attendance!=null}">
                                        <spring:form action="attendance_insert" method="post" class="form-group" modelAttribute="Attendance">
                                            <div class="col-md-12">
                                                <div class="col-md-6">
                                                    

                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Employee Check-In</label>
                                                        <div class="col-md-8">

                                                            <spring:hidden path="employee.employeeId" value="${Employee.employeeId}"></spring:hidden>
                                                            
                                                            
                                                            <spring:hidden path="date" value="${Date.getYear()+1900}-${Date.getMonth()+1}-${Date.getDate()}"></spring:hidden>
                                                            
                                                            
                                                            <spring:hidden path="timeIn" value="${Date.getHours()}:${Date.getMinutes()}:${Date.getSeconds()}"></spring:hidden>
                                                            
                                                            
                                                        </div>

                                                        <div class="col-md-12">
                                                            <br/> </div>
                                                        <div class="form-group row" align="center">
                                                            <div class="col-md-12">
                                                                <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Check-In"> </div>
                                                        </div>



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
                    <h4 class="modal-title">Employee Check-Out</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${AttendanceEdit!=null}">
                        <spring:form action="attendance_update" method="post" class="form-group" modelAttribute="AttendanceEdit">
                            <div class="col-md-12">
                                <h4 class="modal-title">Click here to Check-out</h4>
                                <spring:input path="attendanceId" type="hidden" class="form-control" id="example-text-input" readonly="readOnly" /> </div>
                            <div class="form-group row">
                                <div class="col-md-8">
                                    
                                    <spring:hidden path="timeOut" value="${Date.getHours()}:${Date.getMinutes()}:${Date.getSeconds()}"></spring:hidden>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-8">
                                    <spring:input type="hidden" path="timeIn" value="${AttendanceEdit.timeIn}" readonly="readOnly"></spring:input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-8">
                                    <spring:hidden path="date" value="${AttendanceEdit.date}" readonly="readOnly"></spring:hidden>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-8">
                                    <spring:hidden path="employee.employeeId" value="${Employee.employeeId}" readonly="readOnly"></spring:hidden>
                                </div>
                            </div>
                            <div class="form-group row" align="center">
                                <div class="col-md-12">
                                    <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Check-out"> </div>
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
                    removeRows: false,x
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
        <c:if test="${AttendanceEdit!=null}">
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
                            window.location = "attendance.html";
                        }
                    }
                });
            });
        </script>
    </c:if>

</html>           