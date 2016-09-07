<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

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
    }
  };
  xhttp.open("GET", "address_form.html?same="+same+"&address="+address+"&countries="+countries+"&states="+states+"&cities="+cities+"&pincode="+pincode+"&mobile="+mobile+"&email="+email, true);
  xhttp.send();
}
</script>

                        <div id="Department-Table" role="tabpanel" class="tab-pane active">
                            <div class="main-head">
                                <h1 class="title"> Communication Details </h1> </div>
                            

                            <div class="form">
                                     
                                        <form action="#" method="post" class="form-group">
                                     
                                     <div class="col-md-12">

                              
                                <div class="col-md-6">

                                    <h5> Residential Address </h5>
                                    <hr>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" id="employeeId" placeHolder="Employee Id" value="<c:out value='' />">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                        <div class="col-md-8">
                                            <textarea class="form-control" id="address" placeHolder="Address"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                        <div class="col-md-8">
                                            <select name="country" class="countries form-control" id="countryId">
                                                <option value="">Select Country</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                        <div class="col-md-8">
                                            <select name="state" class="states form-control" id="stateId">
												<option value="">Select State</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                        <div class="col-md-8">
                                           <select name="city" class="cities form-control" id="cityId">
												<option value="">Select City</option>
											</select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" id="pincode" placeHolder="Pincode">
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" id="mobile" placeHolder="Mobile Number">
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="email" id="email" placeHolder="Email Address">
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
                                                    <input class="form-check-input"  type="checkbox" name="same" id="myCheck" onchange="loadDoc();" value="Male"> Same as Residential
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="address_form">
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                        <div class="col-md-8">
                                            <textarea class="form-control" id="example-text-input" placeHolder="Address"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                        <div class="col-md-8">
                                            <select name="country1" class="countries1 form-control" id="countryId1">
                                                <option value="">Select Country</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                        <div class="col-md-8">
                                            <select name="state1" class="states1 form-control" id="stateId1">
												<option value="">Select State</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                        <div class="col-md-8">
                                           <select name="city" class="cities1 form-control" id="cityId1">
												<option value="">Select City</option>
											</select>
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" id="example-text-input" placeHolder="Pincode">
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" id="example-text-input" placeHolder="Mobile Number">
                                        </div>
                                    </div><script src="js/location.js"></script>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="email" id="example-text-input" placeHolder="Email Address">
                                        </div>
                                    </div>
                                  </div>

                                </div>


                            </div>

                            <div class="form-group row">
                                <div class="col-md-12" align="center">
                                    <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Submit">
                                </div>
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