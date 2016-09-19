<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope['HRMSEmployeeId']==null}" >
   <c:redirect url="index.html" /> 
</c:if>
<c:if test="${sessionScope['HRMSRole']=='Employee'}">
   <c:redirect url="employee_view.html?id=${HRMSEmployeeId}" />
</c:if>f>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Certification</title>
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


                        <div id="Department-Table" role="tabpanel" class="tab-pane active">
                             <ol class="breadcrumb">
                                <li><a href="javascript:void(0)">Personal Details</a></li>
                                <li><a href="javascript:void(0)">Communication Details</a></li>
                                <li><a href="javascript:void(0)">Education Details</a></li>
                                <li  class="active">Certification Details</li>
                                <li><a href="javascript:void(0)">Profile Picture</a></li>                                
                        </ol>
                            
                            
                            <div class="main-head">
                                <h1 class="title"> Certification Details </h1> </div>
                         
<script>
function loadDoc() {
  var xhttp;
  var noof = parseInt(document.getElementById('noof').value);
  var employeeId = <c:out value='${EmployeeId}' />;
  if (window.XMLHttpRequest) {
    // code for modern browsers
    xhttp = new XMLHttpRequest();
    } else {
    // code for IE6, IE5
    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("certifcation_form").innerHTML = this.responseText;
      $('.form_date').datetimepicker({
          language:  'en',
          weekStart: 1,
          todayBtn:  1,
  		autoclose: 1,
  		todayHighlight: 1,
  		startView: 2,
  		minView: 2,
  		forceParse: 0
      });
      
      $.validate({
  	    lang: 'en',
  	    borderColorOnError : '#F00',
   });
  	
    }
  };
  xhttp.open("GET", "certification_form.html?noof="+noof+"&eid="+employeeId, true);
  xhttp.send();
}
</script>
                            <div class="form">
                                 <div class="form-group row">
                                    <label for="example-text-input" class="col-md-4 col-form-label">No of Course Completed</label>
                                     <div class="col-md-6">
                                      <input type="number" class="form-control" name="noof" id="noof" onchange="loadDoc()" value="0" maxlength="10" placeHolder="No of Courses" /> </div>
                             </div>
                    
                               
                              <div class="col-md-12" style="padding-left: 100px;">
                               <div id="certifcation_form">
                               </div>
						    </div>
						    
						    
						    <div>
						     <a href="picture.html?eid=<c:out value='${EmployeeId}' />"> <button class="btn btn-primary btn-lg"> Skip this Step  </button> </a>
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
    <!-- jQuery -->


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
    borderColorOnError : '#F00',
  });
</script> 
   <script type="text/javascript">
   
	$('.form_date').datetimepicker({
        language:  'en',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
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