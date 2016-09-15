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
    <title>Allowance Details</title>
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
                        <li role="presentation" class="active"><a href="#Department-Table" aria-controls="Department-Table" role="tab" data-toggle="tab">Designations</a>
                        </li>
                        <li role="presentation"><a href="#Department-Form" aria-controls="Department-Form" role="tab" data-toggle="tab">Add New</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="Department-Table" role="tabpanel" class="tab-pane active">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Allowance Details </h1> </div>

                                <c:if test="${AllowanceList!=null}">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Department Name</th>
                                                <th>Designation Name</th>
                                                <th>House Rent Allowance</th>
                                                <th>Dearness Allowance</th>
                                                <th>Provident Fund</th>
                                                <th>Medical Allowance</th>
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
                                            <c:forEach var="allowance" items="${AllowanceList}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${allowance.id}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:set var="designation" value="${allowance.designation}" />
                                                        <c:set var="department" value="${designation.department}" />
                                                        <c:out value="${department.departmentName}" />
                                                    </td>
                                                    <td>
                                                        <c:out value="${designation.designationName}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${allowance.houseRentAllowance}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${allowance.dearnessAllowance}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${allowance.providentFund}"></c:out>
                                                    </td>
                                                     <td>
                                                        <c:out value="${allowance.medicalAllowance}"></c:out>
                                                    </td>
                                                    <td>
                                                        <a href="allowance_edit.html?id=<c:out value='${allowance.id} ' />" class="edit"> <i class="fa fa-pencil"></i> Edit </a> &nbsp;&nbsp;
                                                        <a href="allowance_delete.html?id=<c:out value='${allowance.id} ' />" class="delete"> <i class="fa fa-trash"></i> Delete </a>

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
                                    <h1 class="title"> Add New Allowance </h1> </div>
                                <div class="single-rowform">
                                    <c:if test="${Allowance!=null}">
                                        <spring:form action="allowance_insert" method="post" class="form-group" modelAttribute="Allowance">
                                            <div class="col-md-12">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Department</label>
                                                        <div class="col-md-8">
                                                       
                                                            <select name="department" class="form-control" id="department"  onchange="loadDoc();">
                                                                <option value="0"> --Select --</option>
                                                                <c:forEach items="${DepartmentList}" var="department">
                                                                    <option value="${department.departmentId}">${department.departmentName}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                   </div>
                                                    <script>
													function loadDoc() {
 														 var xhttp;
  														 var department = parseInt(document.getElementById('department').value); 
														 if (window.XMLHttpRequest) {
    														// code for modern browsers
    														xhttp = new XMLHttpRequest();
    													    } else {
    													    // code for IE6, IE5
    														xhttp = new ActiveXObject("Microsoft.XMLHTTP");
  															}
  															xhttp.onreadystatechange = function() {
    														if (this.readyState == 4 && this.status == 200) {
      															document.getElementById("designationView").innerHTML = this.responseText;
    														}
  															};
  															xhttp.open("GET", "designationView.html?departmentId="+department, true);
  															xhttp.send();
														}
													</script>
                                                    <div class="form-group row">
                                       			    <label for="example-text-input" class="col-md-4 col-form-label">Designation</label>
                                        		    <div class="col-md-8">
		                                            <spring:select path="designation.designationId" class="form-control" id="designationView" >                                           
        		                                        <option value="0"> Select Department -- </option>	                                           											
                		                            </spring:select>                                        
                        			                </div>
                                    				</div>
                                    				
                                    				 <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">House Rent Allowance</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="houseRentAllowance" class="form-control" id="example-text-input" placeHolder="House Rent Allowance" /> </div>
                                                    </div>
                                                    
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Dearness Allowance</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="dearnessAllowance" class="form-control" id="example-text-input" placeHolder="Dearness Allowance" /> </div>
                                                    </div>
                                                    
                                                    
                                                     <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Provident Fund</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="providentFund" class="form-control" id="example-text-input" placeHolder="Provident Fund" /> </div>
                                                    </div>
                                                    
                                                    
                                                     <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Medical Allowance</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="medicalAllowance" class="form-control" id="example-text-input" placeHolder="Medical Allowance" /> </div>
                                                    </div>
                                                   
                                                     <div class="col-md-12">
                                                            <br/> </div>
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
                    <h4 class="modal-title">Edit Allowance Varient</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${AllowanceEdit!=null}">
                        <spring:form action="allowance_update" method="post" class="form-group" modelAttribute="AllowanceEdit">
                            <div class="col-md-12">
                                <spring:input path="id" type="hidden" class="form-control" id="example-text-input" placeHolder="Designation Id" readonly="readOnly" />
                                 <div class="form-group row">
                                 
                                                        <c:set var="designation" value="${AllowanceEdit.designation}" />
                                                        <c:set var="department" value="${designation.department}" />
                                                        
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Department</label>
                                                        <div class="col-md-8">

                                                            <select name="department" class="form-control" id="department"  onchange="loadDoc();">
                                                                <option value="<c:out value="${department.departmentId}" />"><c:out value="${department.departmentName}" /></option>
                                                                <option value="0"> ---------------</option>
                                                                <c:forEach items="${DepartmentList}" var="department">
                                                                    <option value="${department.departmentId}"> ${department.departmentName}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                   </div>
                                                    <script>
													function loadDoc() {
 														 var xhttp;
  														 var department = parseInt(document.getElementById('department').value); 
														 if (window.XMLHttpRequest) {
    														// code for modern browsers
    														xhttp = new XMLHttpRequest();
    													    } else {
    													    // code for IE6, IE5
    														xhttp = new ActiveXObject("Microsoft.XMLHTTP");
  															}
  															xhttp.onreadystatechange = function() {
    														if (this.readyState == 4 && this.status == 200) {
      															document.getElementById("designationView").innerHTML = this.responseText;
    														}
  															};
  															xhttp.open("GET", "designationView.html?departmentId="+department, true);
  															xhttp.send();
														}
													</script>
                                                    <div class="form-group row">
                                       			    <label for="example-text-input" class="col-md-4 col-form-label">Designation</label>
                                        		    <div class="col-md-8">
		                                            <spring:select path="designation.designationId" class="form-control" id="designationView" >     
		                                                <option value="<c:out value="${designation.designationId}" />"><c:out value="${designation.designationName}" /></option>                                      
        		                                        <option value="0">--------- </option>	                                           											
                		                            </spring:select>                                        
                        			                </div>
                                    				</div>
                                    				
                                    				 <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">House Rent Allowance</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="houseRentAllowance" class="form-control" id="example-text-input" placeHolder="House Rent Allowance" /> </div>
                                                    </div>
                                                    
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Dearness Allowance</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="dearnessAllowance" class="form-control" id="example-text-input" placeHolder="Dearness Allowance" /> </div>
                                                    </div>
                                                    
                                                    
                                                     <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Provident Fund</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="providentFund" class="form-control" id="example-text-input" placeHolder="Provident Fund" /> </div>
                                                    </div>
                                                    
                                                    
                                                     <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Medical Allowance</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="medicalAllowance" class="form-control" id="example-text-input" placeHolder="Medical Allowance" /> </div>
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

    <c:if test="${message==null}">
        <c:if test="${AllowanceEdit!=null}">
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
                            window.location = "allowance.html";
                        }
                    }
                });
            });
        </script>
    </c:if>
</body>

</html>           