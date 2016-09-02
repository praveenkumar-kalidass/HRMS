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
                <link rel="stylesheet" href="css/sidebar-menu.css">
            </head>

            <body>
                <div id="dialog-confirm" title="Alert" style="display:none;">
                    <p><c:if test="${message!=null}"><c:out value="${message}" /></c:if></p>
                </div>
                
                <div class="containe">
                   
                    <div class="side-menu">
                        <!-- Side Menu -->
                        <c:import url="side-menu.jsp" />
                    </div>

                    
                    <div class="content-bar">
                        <c:import url="top-menu.jsp" />


                        <div class="content-main">
                           <div class="col-md-12">
                            <!--  Main Start -->
                            
                            
                             <ul class="tab">
                                <li><a href="#" class="tablinks" onclick="openEvent(event, 'Department-Table')">Departments</a></li>
                                <li><a href="#" class="tablinks" onclick="openEvent(event, 'Department-Form')">Add New</a></li>
                            </ul>
                           
                           
                            <div id="Department-Form" class="tabcontent">
                            <div class="form">
                            <div class="main-head">
                                <h1 class="title"> Department Details </h1>
                            </div>
                                <c:if test="${Department!=null}">
                                    <spring:form action="department_insert" method="post" class="form-group" modelAttribute="Department">
                                            <div class="col-md-12">

                                                <div class="col-md-6">
                                                    
                                                    
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Department Id</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="departmentId" class="form-control" id="example-text-input" placeHolder="Department Id" />
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Department Name</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="departmentName" class="form-control" id="example-text-input" placeHolder="Department Name" />
                                                        </div>
                                                        </div>
                                                   
                                                   
                                                    </div>

                                            <div class="form-group row">
                                                <div class="col-md-12" align="center">
                                                    <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save">
                                                </div>
                                            </div>

                                        </div>
                                    </spring:form>
                                </c:if>
                                </div>
                                </div>
                          
                           
                        
                        <div id="Department-Table" class="tabcontent">
                            <div class="form">
                            <div class="main-head">
                                <h1 class="title"> Department Details </h1>
                            </div>
                                <c:if test="${Department!=null}">
<table class="pricing-table">
<thead>
<tr>
<th class="price-top" onclick="sort_table(people, 0, asc1); asc1 *= -1; asc4 = 1; asc3 = 1; asc2 = 1;">Department-Id<div class="arrow-up"></div><div class="arrow-space"></div><div class="arrow-down"></div></th>
<th class="price-top" onclick="sort_table(people, 1, asc2); asc2 *= -1; asc4 = 1; asc3 = 1; asc1 = 1;">Department-Name<div class="arrow-up"></div><div class="arrow-space"></div><div class="arrow-down"></div></th>
</tr>
</thead>

<tbody id="people">
<c:forEach var="department" items="${DepartmentList}">
<tr>
<td><c:out value="${department.departmentId}"></c:out></td>
<td><c:out value="${department.departmentName}"></c:out></td>
</tr>
</c:forEach>
</tbody>
</table>
                                </c:if>
                                </div>
                                </div>

                            <!--  Main End -->
                              </div>
                             </div>
                            
                                </div>
                            </div>
                            

                <link rel="stylesheet" href="css/jquery-ui.css" />
                <script src="js/jquery-3.0.0.min.js"></script>
                <script src="js/sidebar-menu.js"></script>
                <script src="js/jquery-ui.js"></script>
                <script src="js/bootstrap.js"></script>
                
<c:if test="${message!=null}">
  <script>
  $( function() {
    $( "#dialog-confirm" ).dialog({
      modal: true,
      open: function(event, ui) {
        $(".ui-dialog-titlebar-close", ui.dialog | ui).hide();
      },
      buttons: {
        Ok: function() {
          $( this ).dialog( "close" );
          window.location ="department.html";
        }
      }
    });
  } );
  </script>   
  </c:if>
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
        window.onload = function () {
            people = document.getElementById("people");
        }

        function sort_table(tbody, col, asc) {
            var rows = tbody.rows,
                rlen = rows.length,
                arr = new Array(),
                i, j, cells, clen;
            // fill the array with values from the table
            for (i = 0; i < rlen; i++) {
                cells = rows[i].cells;
                clen = cells.length;
                arr[i] = new Array();
                for (j = 0; j < clen; j++) {
                    arr[i][j] = cells[j].innerHTML;
                }
            }
            // sort the array by the specified column number (col) and order (asc)
            arr.sort(function (a, b) {
                return (a[col] == b[col]) ? 0 : ((a[col] > b[col]) ? asc : -1 * asc);
            });
            // replace existing rows with new rows created from the sorted array
            for (i = 0; i < rlen; i++) {
                rows[i].innerHTML = "<td>" + arr[i].join("</td><td>") + "</td>";
            }
        }
    </script>
            </body>

            </html>
