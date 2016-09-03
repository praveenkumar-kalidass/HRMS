<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Department</title>
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
                                    <li role="presentation" class="active"><a href="#Department-Table" aria-controls="Department-Table" role="tab" data-toggle="tab">Departments</a>
                                    </li>
                                    <li role="presentation"><a href="#Department-Form" aria-controls="Department-Form" role="tab" data-toggle="tab">Add New</a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div id="Department-Table" role="tabpanel" class="tab-pane active">
                                        <div class="form">
                                            <div class="main-head">
                                                <h1 class="title"> Department Details </h1> </div>
                                            <c:if test="${Department!=null}">
                                                <table class="pricing-table">
                                                    <thead>
                                                        <tr>
                                                            <th class="price-top first" onclick="sort_table(people, 0, asc1); asc1 *= -1; asc4 = 1; asc3 = 1; asc2 = 1;">
                                                                <div class="fil-name">Department Id</div>
                                                                <div class="fil-ico"><span class="arrow-up"></span><span class="arrow-space"></span><span class="arrow-down"></span> </div>
                                                            </th>
                                                            <th class="price-top last" onclick="sort_table(people, 1, asc2); asc2 *= -1; asc4 = 1; asc3 = 1; asc1 = 1;">
                                                                <div class="fil-name">Department Name</div>
                                                                <div class="fil-ico"><span class="arrow-up"></span><span class="arrow-space"></span><span class="arrow-down"></span> </div>
                                                            </th>

                                                        </tr>

                                                    </thead>

                                                    <tbody id="people">
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
                                        <div class="form">
                                            <div class="main-head">
                                                <h1 class="title"> Department Details </h1> </div>
                                            <div class="single-rowform">
                                                <c:if test="${Department!=null}">
                                                    <spring:form action="department_insert" method="post" class="form-group" modelAttribute="Department">
                                                        <div class="col-md-12">

                                                            <div class="col-md-6">
                                                                <div class="form-group row">
                                                                    <label for="example-text-input" class="col-md-4 col-form-label">Department Name</label>
                                                                    <div class="col-md-8">
                                                                        <spring:input path="departmentName" class="form-control" id="example-text-input" placeHolder="Department Name" /> </div>
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
                                <h4 class="modal-title">Edit Department</h4> </div>
                            <div class="modal-body">
                                <c:if test="${DepartmentEdit!=null}">
                                    <spring:form action="department_update" method="post" class="form-group" modelAttribute="DepartmentEdit">
                                        <div class="col-md-12">

                                            <div class="form-group row">
                                                <label for="example-text-input" class="col-md-4 col-form-label">Department Id</label>
                                                <div class="col-md-8">
                                                    <spring:input path="departmentId" class="form-control" id="example-text-input" placeHolder="Department Id" readonly="readOnly" /> </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="example-text-input" class="col-md-4 col-form-label">Department Name</label>
                                                <div class="col-md-8">
                                                    <spring:input path="departmentName" class="form-control" id="example-text-input" placeHolder="Department Name" /> </div>
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
                <script type="text/javascript">
                    var people, asc1 = 1,
                        asc2 = 1,
                        asc3 = 1,
                        asc4 = 1;
                    window.onload = function() {
                        people = document.getElementById("people");
                    }

                    function sort_table(tbody, col, asc) {
                            var rows = tbody.rows,
                                rlen = rows.length,
                                arr = new Array(),
                                i, j, cells, clen; // fill the array with values from the table 
                                for (i = 0; i < rlen; i++) { cells = rows[i].cells; clen = cells.length; arr[i] = new Array(); for (j = 0; j < clen; j++) { arr[i][j] = cells[j].innerHTML; } } 
                                // sort the array by the specified column number (col) and order (asc) 
                                arr.sort(function (a, b) { return (a[col] == b[col]) ? 0 : ((a[col] > b[col]) ? asc : -1 * asc); }); 
                                // replace existing rows with new rows created from the sorted array 
                                for (i = 0; i < rlen; i++) { rows[i].innerHTML = "<td>" + arr[i].join("</td><td>") + "</td>"; }
                                }
                </script>
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