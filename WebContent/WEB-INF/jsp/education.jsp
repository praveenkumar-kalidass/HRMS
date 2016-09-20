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
   <c:import url="headCss.jsp" /></head>

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
                    <script>
                        function loadDoc() {
                            var xhttp;
                            var noof = parseInt(document.getElementById('noof').value);
                            var employeeId = <c:out value ='${EmployeeId}' /> ;
                            if (window.XMLHttpRequest) {
                                // code for modern browsers
                                xhttp = new XMLHttpRequest();
                            } else {
                                // code for IE6, IE5
                                xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                            }
                            xhttp.onreadystatechange = function() {
                                if (this.readyState == 4 && this.status == 200) {
                                    document.getElementById("education_form").innerHTML = this.responseText;
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
                                    $.validate({
                                        lang: 'en',
                                        borderColorOnError: '#F00',
                                    });
                                    $(".readonly").keydown(function(e){
                                        e.preventDefault();
                                    });
                                }
                            };
                            xhttp.open("GET", "education_form.html?noof=" + noof + "&eid=" + employeeId, true);
                            xhttp.send();
                        }
                    </script>

                    <div id="Department-Table" role="tabpanel" class="tab-pane active">
                        <ol class="breadcrumb">
                            <li><a href="javascript:void(0)">Personal Details</a>
                            </li>
                            <li><a href="javascript:void(0)">Communication Details</a>
                            </li>
                            <li class="active">Education Details</li>
                            <li><a href="javascript:void(0)">Certification Details</a>
                            </li>
                            <li><a href="javascript:void(0)">Profile Picture</a>
                            </li>
                        </ol>

                        <div class="main-head">
                            <h1 class="title"> Education Details </h1> </div>

                        <div class="form">
                            <div class="col-md-12" style="padding-left: 100px;">
                                <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">Highest Qualification Degree</label>
                                    <div class="col-md-6">
                                        <select onchange="loadDoc();" class="form-control" id="noof">
                                            <option value="0">--Select--</option>
                                            <option value="1">SSLC</option>
                                            <option value="2">HSC</option>
                                            <option value="3">Under Graduation</option>
                                            <option value="4">Post Graduation</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12" style="padding-left: 100px;">
                                <div id="education_form">
                                </div>
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
