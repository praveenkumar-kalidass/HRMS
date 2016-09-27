<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${sessionScope['currentRole']=='ROLE_USER'}">
    <c:redirect url="../../user_view.html?id=${currentUserId}" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Certification</title>
    <link href="images/logo1.png" rel="icon" />
    <c:import url="headCss.jsp" />
</head>

<body>
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
                            <li class="active">Certification Details</li>
                            <li><a href="javascript:void(0)">Profile Picture</a>
                            </li>
                        </ol>

                        <div class="main-head">
                            <h1 class="title"> Certification Details </h1> </div>
                        <div class="form">
                            <div class="form-group row">
                                <label for="example-text-input" class="col-md-4 col-form-label">No of Course Completed</label>
                                <div class="col-md-6">
                                    <input type="number" class="form-control" name="noof" id="noof" onchange="loadCertificationForm(<c:out value ='${UserId}' />);" value="0" maxlength="10" placeHolder="No of Courses" /> </div>
                            </div>

                            <div class="col-md-12" style="padding-left: 100px;">
                                <div id="certifcation_form">
                                </div>
                            </div>

                            <div>
                                <a href="picture.html?eid=<c:out value='${UserId}' />">
                                    <button class="btn btn-primary btn-lg"> Skip this Step </button>
                                </a>
                            </div>
                        </div>
                    </div>

                    <!-- Main End -->
                </div>
            </div>
        </div>
    </div>

    <c:import url="headJs.jsp" />
    <c:if test="${message!=null}">
        <script>
            $("#myModal").modal("hide");
            dialogConfirmation("user.html");
        </script>
    </c:if>
    <c:import url="dialogConfirmation.jsp" />

</body>

</html>
