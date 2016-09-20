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
    <title>Profile Picture</title>
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

                    <div id="Department-Table" role="tabpanel" class="tab-pane active">
                        <ol class="breadcrumb">
                            <li><a href="javascript:void(0)">Personal Details</a>
                            </li>
                            <li><a href="javascript:void(0)">Communication Details</a>
                            </li>
                            <li><a href="javascript:void(0)">Education Details</a>
                            </li>
                            <li><a href="javascript:void(0)">Certification Details</a>
                            </li>
                            <li class="active">Profile Picture</li>
                        </ol>

                        <div class="main-head">
                            <h1 class="title"> Profile Picture </h1> </div>

                        <div class="form">

                            <form action="picture_add" method="post" enctype="multipart/form-data">
                                <div class="col-md-8">

                                    <input type="hidden" name="employeeId" value="<c:out value='${EmployeeId}' />" class="form-control" />

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Select Picture</label>
                                        <div class="col-md-8">
                                            <input type="file" name="employeePicture" class="form-control" onchange="readURL(this);" />
                                        </div>
                                    </div>

                                    <div class="form-group row" id="imagess">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Your Image</label>
                                        <div class="col-md-8">
                                            <img id="blah" src="#" alt="your image" />
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-md-12" align="center">
                                            <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Submit" />
                                        </div>
                                    </div>

                                </div>
                            </form>

                            <style type="text/css" rel="styleSheet">
                                #imagess {
                                    visibility: hidden;
                                }
                            </style>
                            <script>
                                function readURL(input) {
                                    if (input.files && input.files[0]) {
                                        var reader = new FileReader();

                                        reader.onload = function(e) {
                                            document.getElementById('imagess').style.visibility = 'visible';
                                            $('#blah')
                                                .attr('src', e.target.result)
                                                .width(150)
                                                .height(200);
                                        };

                                        reader.readAsDataURL(input.files[0]);
                                    }
                                }
                            </script>

                        </div>
                    </div>

                </div>
            </div>

            <!-- Main End -->
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
