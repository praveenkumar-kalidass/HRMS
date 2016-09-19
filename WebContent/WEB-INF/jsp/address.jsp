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
</c:if>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Communication Details</title>
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
<script>
function loadDoc() {
  var xhttp;
  var same;
  var x = document.getElementById("myCheck").checked;
  if(x) {
	  same = 1;
  }
  else {
	  same = 0;
  }
  var address = document.getElementById('address').value; 
  var countries = document.getElementById('countryId').value;
  var states = document.getElementById('stateId').value;
  var cities = document.getElementById('cityId').value;
  var pincode = document.getElementById('pincode').value;
  var mobile = document.getElementById('mobile').value;
  var email = document.getElementById('email').value;
  
  if (window.XMLHttpRequest) {
    // code for modern browsers
    xhttp = new XMLHttpRequest();
    } else {
    // code for IE6, IE5
    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("address_form").innerHTML = this.responseText;
      function ajaxCall() {
          this.send = function(data, url, method, success, type) {
            type = type||'json';
            var successRes = function(data) {
                success(data);
            }

            var errorRes = function(e) {
                console.log(e);
                //alert("Error found \nError Code: "+e.status+" \nError Message: "+e.statusText);
                //$('#loader').modal('hide');
            }
              $.ajax({
                  url: url,
                  type: method,
                  data: data,
                  success: successRes,
                  error: errorRes,
                  dataType: type,
                  timeout: 60000
              });

            }

          }
      
      function locationInfo() {
    	    var rootUrl = "http://iamrohit.in/lab/php_ajax_country_state_city_dropdown/api.php";
    	    var call = new ajaxCall();
    	    this.getCities = function(id) {
    	        $(".cities option:gt(0)").remove();
    	        var url = rootUrl+'?type=getCities&stateId=' + id;
    	        var method = "post";
    	        var data = {};
    	        $('.cities').find("option:eq(0)").html("Please wait..");
    	        call.send(data, url, method, function(data) {
    	            $('.cities').find("option:eq(0)").html("Select City");
    	            if(data.tp == 1){
    	                $.each(data['result'], function(key, val) {
    	                    var option = $('<option />');
    	                    option.attr('value', val).text(val);
    	                     option.attr('cityid', key);
    	                    $('.cities').append(option);
    	                });
    	                $(".cities").prop("disabled",false);
    	            }
    	            else{
    	                 alert(data.msg);
    	            }
    	        });
    	    };
    	    
    	    this.getCities1 = function(id) {
    	        $(".cities1 option:gt(0)").remove();
    	        var url = rootUrl+'?type=getCities&stateId=' + id;
    	        var method = "post";
    	        var data = {};
    	        $('.cities1').find("option:eq(0)").html("Please wait..");
    	        call.send(data, url, method, function(data) {
    	            $('.cities1').find("option:eq(0)").html("Select City");
    	            if(data.tp == 1){
    	                $.each(data['result'], function(key, val) {
    	                    var option = $('<option />');
    	                    option.attr('value', val).text(val);
    	                     option.attr('cityid1', key);
    	                    $('.cities1').append(option);
    	                });
    	                $(".cities1").prop("disabled",false);
    	            }
    	            else{
    	                 alert(data.msg);
    	            }
    	        });
    	    };


    	    this.getStates = function(id) {
    	        $(".states option:gt(0)").remove(); 
    	        $(".cities option:gt(0)").remove(); 
    	        var url = rootUrl+'?type=getStates&countryId=' + id;
    	        var method = "post";
    	        var data = {};
    	        $('.states').find("option:eq(0)").html("Please wait..");
    	        call.send(data, url, method, function(data) {
    	            $('.states').find("option:eq(0)").html("Select State");
    	            if(data.tp == 1){
    	                $.each(data['result'], function(key, val) {
    	                    var option = $('<option />');
    	                        option.attr('value', val).text(val);
    	                        option.attr('stateid', key);
    	                    $('.states').append(option);
    	                });
    	                $(".states").prop("disabled",false);
    	            }
    	            else{
    	                alert(data.msg);
    	            }
    	        }); 
    	    };
    	    
    	    this.getStates1 = function(id) {
    	        $(".states1 option:gt(0)").remove(); 
    	        $(".cities1 option:gt(0)").remove(); 
    	        var url = rootUrl+'?type=getStates&countryId=' + id;
    	        var method = "post";
    	        var data = {};
    	        $('.states1').find("option:eq(0)").html("Please wait..");
    	        call.send(data, url, method, function(data) {
    	            $('.states1').find("option:eq(0)").html("Select State");
    	            if(data.tp == 1){
    	                $.each(data['result'], function(key, val) {
    	                    var option = $('<option />');
    	                        option.attr('value', val).text(val);
    	                        option.attr('stateid1', key);
    	                    $('.states1').append(option);
    	                });
    	                $(".states1").prop("disabled",false);
    	            }
    	            else{
    	                alert(data.msg);
    	            }
    	        }); 
    	    };

    	    this.getCountries = function() {
    	        var url = rootUrl+'?type=getCountries';
    	        var method = "post";
    	        var data = {};
    	        $('.countries').find("option:eq(0)").html("Please wait..");
    	        call.send(data, url, method, function(data) {
    	            $('.countries').find("option:eq(0)").html("Select Country");
    	            console.log(data);
    	            if(data.tp == 1){
    	                $.each(data['result'], function(key, val) {
    	                    var option = $('<option />');
    	                    option.attr('value', val).text(val);
    	                     option.attr('countryid', key);
    	                    $('.countries').append(option);
    	                });
    	                $(".countries").prop("disabled",false);
    	            }
    	            else{
    	                alert(data.msg);
    	            }
    	        }); 
    	    };
    	    
    	    
    	    this.getCountries1 = function() {
    	        var url = rootUrl+'?type=getCountries';
    	        var method = "post";
    	        var data = {};
    	        $('.countries1').find("option:eq(0)").html("Please wait..");
    	        call.send(data, url, method, function(data) {
    	            $('.countries1').find("option:eq(0)").html("Select Country");
    	            console.log(data);
    	            if(data.tp == 1){
    	                $.each(data['result'], function(key, val) {
    	                    var option = $('<option />');
    	                    option.attr('value', val).text(val);
    	                     option.attr('countryid1', key);
    	                    $('.countries1').append(option);
    	                });
    	                $(".countries1").prop("disabled",false);
    	            }
    	            else{
    	                alert(data.msg);
    	            }
    	        }); 
    	    };

    	}

    	$(function() {
    	var loc = new locationInfo();
    	loc.getCountries();
    	loc.getCountries1();
    	 $(".countries").on("change", function(ev) {
    	        var countryId = $("option:selected", this).attr('countryid');
    	        if(countryId != ''){
    	        loc.getStates(countryId);
    	        }
    	        else{
    	            $(".states option:gt(0)").remove();
    	        }
    	    });
    	 $(".countries1").on("change", function(ev) {
    	     var countryId = $("option:selected", this).attr('countryid1');
    	     if(countryId != ''){
    	     loc.getStates1(countryId);
    	     }
    	     else{
    	         $(".states1 option:gt(0)").remove();
    	     }
    	 });
    	 
    	 
    	 $(".states").on("change", function(ev) {
    	        var stateId = $("option:selected", this).attr('stateid');
    	        if(stateId != ''){
    	        loc.getCities(stateId);
    	        }
    	        else{
    	            $(".cities option:gt(0)").remove();
    	        }
    	    });
    	 $(".states1").on("change", function(ev) {
    	     var stateId = $("option:selected", this).attr('stateid1');
    	     if(stateId != ''){
    	     loc.getCities1(stateId);
    	     }
    	     else{
    	         $(".cities1 option:gt(0)").remove();
    	     }
    	 });
    	 
    	});
    }
  };
  xhttp.open("GET", "address_form.html?same="+same+"&address="+address+"&countries="+countries+"&states="+states+"&cities="+cities+"&pincode="+pincode+"&mobile="+mobile+"&email="+email, true);
  xhttp.send();
}
</script>

                        <div id="Department-Table" role="tabpanel" class="tab-pane active">
                           
                             <ol class="breadcrumb">
                                <li><a href="javascript:void(0)">Personal Details</a></li>
                                <li class="active">Communication Details</li>
                                <li><a href="javascript:void(0)">Education Details</a></li>
                                <li><a href="javascript:void(0)">Certification Details</a></li>
                                <li><a href="javascript:void(0)">Profile Picture</a></li>                                
                        </ol>
                           
                            <div class="main-head">
                                <h1 class="title"> Communication Details </h1> </div>
                            

                            <div class="form">
                                     
                                        <spring:form action="address_add" method="post" modelAttribute="Employee"  class="form-group">
                                     
                                     <div class="col-md-12">

                              
                                <div class="col-md-6">

                                    <h5> Residential Address </h5>
                                    <hr>
                                    <div class="form-group row">                                        
                                        <div class="col-md-8">
                                            <spring:input path="addresses[0].employee.employeeId" class="form-control" type="hidden" value="${Employee.employeeId}" id="employeeId" placeHolder="Employee Id" />
                                            <spring:input path="addresses[1].employee.employeeId" class="form-control" type="hidden" value="${Employee.employeeId}" id="employeeId" placeHolder="Employee Id" />
                                        </div>
                                    </div>
                                    
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                        <div class="col-md-8">
                                            <spring:textarea path="addresses[0].street" class="form-control" id="address" placeHolder="Address" required="required"  data-validation="length"  data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Street Minimum 5 Characters"></spring:textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                        <div class="col-md-8">
                                            <spring:select path="addresses[0].country" class="countries form-control" id="countryId" required="required">
                                                <option value="">Select Country</option>
                                            </spring:select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                        <div class="col-md-8">
                                           <spring:select path="addresses[0].state" class="states form-control" id="stateId" required="required">
												<option value="">Select State</option>
                                           </spring:select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                        <div class="col-md-8">
                                           <spring:select path="addresses[0].city" class="cities form-control" id="cityId" required="required">
												<option value="">Select City</option>
											</spring:select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                        <div class="col-md-8">
                                            <spring:input  path="addresses[0].pincode" class="form-control"  id="pincode" placeHolder="Pincode" required="required"  data-validation="number" data-validation-error-msg="Pin Code Not Valid"/>
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                        <div class="col-md-8">
                                           <spring:input  path="addresses[0].phoneNumber" class="form-control"  id="mobile" placeHolder="Mobile Number" data-validation="number" data-validation-error-msg="Mobile Number Not Valid" />
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                        <div class="col-md-8">
                                            <spring:input  path="addresses[0].eMail" class="form-control"  id="email" placeHolder="Email Address" required="required" data-validation="email" data-validation-error-msg="Email Address Not Valid" />
                                        </div>
                                    </div> 
                                    
                                    <div class="form-group row">                                        
                                        <div class="col-md-8">
                                            <spring:input   type="hidden"  path="addresses[0].addressType" class="form-control" value="Current" readonly="readOnly"  />
                                        </div>
                                    </div> 

                                </div>



                                <div class="col-md-6">

                                    <h5> Permanent Address </h5>
                                    <hr>

                                    <div class="form-group row">
                                        <div class="col-md-8">
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <input class="form-check-input"  type="checkbox" name="same" id="myCheck" onchange="loadDoc();" value="Male"> Same as Residential Address
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="address_form">
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                        <div class="col-md-8">
                                        <spring:textarea path="addresses[1].street" class="form-control" id="address" placeHolder="Address"  required="required" data-validation="length"  data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Street Minimum 5 Characters"></spring:textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                        <div class="col-md-8">
                                            <spring:select path="addresses[1].country" class="countries1 form-control" id="countryId1" required="required">
                                                <option value="">Select Country</option>
                                            </spring:select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                        <div class="col-md-8">
                                             <spring:select path="addresses[1].state" class="states1 form-control" id="stateId1" required="required">
												<option value="">Select State</option>
                                           </spring:select>
                                        
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                        <div class="col-md-8">
                                          <spring:select path="addresses[1].city" class="cities1 form-control" id="cityId1">
												<option value="">Select City</option>
											</spring:select>
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                        <div class="col-md-8">
                                              <spring:input  path="addresses[1].pincode" class="form-control"  id="pincode" placeHolder="Pincode" data-validation="number" data-validation-error-msg="Pincode  Not Valid" />
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                        <div class="col-md-8">
                                            <spring:input  path="addresses[1].phoneNumber" class="form-control"  id="mobile" placeHolder="Mobile Number" required="required" data-validation="number" data-validation-error-msg="Mobile Number Not Valid" />
                                        </div>
                                    </div><script src="js/location.js"></script>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                        <div class="col-md-8">
                                              <spring:input  path="addresses[1].eMail" class="form-control"  id="email" placeHolder="Email Address" required="required" data-validation="email" data-validation-error-msg="Email Not Valid" />
                                        </div>
                                    </div>
                                    
                                    
                                      <div class="form-group row">
                                        
                                        <div class="col-md-8">
                                            <spring:input type="hidden" path="addresses[1].addressType" class="form-control" value="Perment" readonly="readOnly"  />
                                        </div>
                                    </div> 
                                  </div>

                                </div>


                            </div>

                            <div class="form-group row">
                                <div class="col-md-12" align="center">
                                    <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save & Next">
                                </div>
                            </div>
                            
                         </spring:form>

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
    
    <!--  Location -->
    <script src="js/location.js"></script>
    
     <script src="js/jquery.form-validator.min.js"></script>
<script>

  $.validate({
    lang: 'en',
    borderColorOnError : '#F00',
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