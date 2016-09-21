<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope['HRMSEmployeeId']==null}">
    <c:redirect url="index.html" />
</c:if>
<c:if test="${sessionScope['HRMSRole']=='Employee'}">
    <c:redirect url="project_view.html?id=${HRMSProjectId}" />
</c:if>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Salary Details</title>
    <link href="images/logo1.png" rel="icon" />
     <c:import url="headCss.jsp" /> </head>

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
                    <div class="tab-content">
                        <div id="Client-Table" role="tabpanel" class="tab-pane active">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Generate Salary  </h1> </div>

                                <form method="get" action="salary_generate">
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">From:</label>
                                        <div class="col-md-8">

                                            <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input3" data-link-format="yyyy-mm-dd">
                                                <input class="form-control readonly"  size="16" type="text" required="required" placeHolder="From Date"  >
                                                <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                            </div>
                                            <input name="fromDate" id="dtp_input3" type="hidden" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">To:</label>
                                        <div class="col-md-8">

                                            <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input4" data-link-format="yyyy-mm-dd">
                                                <input class="form-control readonly"  size="16" type="text"  onchange="cldate();" required="required" placeHolder="To Date"   >
                                                <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                                            </div>
                                            <input name="toDate" id="dtp_input4" type="hidden" class="form-control" />
                                        </div>
                                    </div>

                                    <input name="noDays" type="hidden" id="noofDays" value="0" class="form-control" />
                            
                            </div>
                            
                          

                            <div class="form-group row" align="center">
                                <div class="col-md-12">
                                    <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Generate"> </div>
                            </div>
                            

                            </form>

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
                dialogConfirmation("salary.html");
            </script>
        </c:if>
        <c:import url="dialogConfirmation.jsp" />
</body>

</html>
