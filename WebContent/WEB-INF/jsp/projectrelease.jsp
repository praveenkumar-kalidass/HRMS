<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ProjectRelease Details</title>
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
                        <li role="presentation" class="active"><a href="#Project-Table" aria-controls="Project-Table" role="tab" data-toggle="tab">ProjectReleases</a>
                        </li>
                        <li role="presentation"><a href="#Project-Form" aria-controls="Project-Form" role="tab" data-toggle="tab">Add New</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="Project-Table" role="tabpanel" class="tab-pane active">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> ProjectRelease Details </h1> </div>

                                <c:if test="${ProjectReleaseList!=null}">
                                    <table id="ReleaseTable">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Project Name</th>
                                                <th>Release Date</th>
                                                <th>Version</th>
                                                <th>Description</th>
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
                                            <c:forEach var="projectRelease" items="${ProjectReleaseList}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${projectRelease.releaseId}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:set value="${projectRelease.project}" var="project" />
                                                        <c:out value="${project.projectName}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${projectRelease.releaseDate}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${projectRelease.projectVersion}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${projectRelease.description}"></c:out>
                                                    </td>
                                                    <td>
                                                        <a href="projectRelease_edit.html?id=<c:out value='${projectRelease.releaseId} ' />" class="edit"> <i class="fa fa-pencil"></i> Edit </a> &nbsp;&nbsp;
                                                        <a href="projectRelease_delete.html?id=<c:out value='${projectRelease.releaseId} ' />" class="delete"> <i class="fa fa-trash"></i> Delete </a>

                                                    </td>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </c:if>




                            </div>
                        </div>
                        <div id="Project-Form" role="tabpanel" class="tab-pane">
                            <div class="form">
                                <div class="main-head">
                                    <h1 class="title"> Add New ProjectRelease </h1> </div>
                                <div class="single-rowform">
                                    <c:if test="${ProjectRelease!=null}">
                                        <spring:form action="projectRelease_insert" method="post" class="form-group" modelAttribute="ProjectRelease">
                                            <div class="col-md-12">
                                                <div class="col-md-6">

                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Project</label>
                                                        <div class="col-md-8">

                                                            <spring:select path="project.projectId" class="form-control" >
                                                                <spring:option value="0"> --Select --</spring:option>
                                                                <c:forEach items="${ProjectList}" var="project">
                                                                    <spring:option value="${project.projectId}">${project.projectName}</spring:option>
                                                                </c:forEach>
                                                            </spring:select>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">To:</label>
                                                        <div class="col-md-8">
                                           
                                                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input4" data-link-format="yyyy-mm-dd">
             								            <input class="form-control" size="16" type="text" value="" readonly>            										      
														<span class="input-group-addon"><span class="fa fa-calendar"></span></span>
               											</div>
												        <spring:input path="releaseDate" id="dtp_input4" type="hidden" class="form-control"    />
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Project Version</label>
                                                        <div class="col-md-8">
                                                            <spring:input path="projectVersion" class="form-control" id="example-text-input" placeHolder="Project Version" /> </div>
                                                        </div>
                                                        
                                                        <div class="form-group row">
                                                        <label for="example-text-input" class="col-md-4 col-form-label">Description</label>
                                                        <div class="col-md-8">
                                                            <spring:textarea path="description" class="form-control" id="example-text-input" placeHolder="Description" ></spring:textarea> </div>
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
                    <h4 class="modal-title">Edit ProjectRelease</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${ProjectReleaseEdit!=null}">
                        <spring:form action="projectRelease_update" method="post" class="form-group" modelAttribute="ProjectReleaseEdit">
                            <div class="col-md-12">

                                <spring:input path="releaseId" type="hidden" class="form-control" id="example-text-input" placeHolder="ProjectRelease Id" readonly="readOnly" /> </div>
                                
                                <div class="form-group row">
                                <label for="example-text-input" class="col-md-4 col-form-label">Project</label>
                                <div class="col-md-8">
                                    <spring:select path="project" class="form-control">
                                        <c:set value="${ProjectReleaseEdit.project}" var="dep" />
                                        <spring:option value="${dep.projectId}">${dep.projectName}</spring:option>
                                        <spring:option value="0"> -------</spring:option>
                                        <c:forEach items="${ProjectList}" var="project">
                                            <spring:option value="${project.projectId}">${project.projectName}</spring:option>
                                        </c:forEach>
                                    </spring:select>
                                </div>
                            </div>
                            
                            <div class="form-group row">
                                                    <label for="example-text-input" class="col-md-4 col-form-label">To:</label>
                                                        <div class="col-md-8">
                                           
                                                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input4" data-link-format="yyyy-mm-dd">
             								            <input class="form-control" size="16" type="text" value="<c:out value='${ProjectReleaseEdit.releaseDate}' />" readonly>            										      
														<span class="input-group-addon"><span class="fa fa-calendar"></span></span>
               											</div>
												        <spring:input path="releaseDate" id="dtp_input4" type="hidden" class="form-control"    />
                                                        </div>
                                                    </div>
                            
                            <div class="form-group row">
                                <label for="example-text-input" class="col-md-4 col-form-label">Project Version</label>
                                <div class="col-md-8">
                                    <spring:input path="projectVersion" class="form-control" id="example-text-input" placeHolder="Project Version" /> </div>
                            </div>

                            <div class="form-group row">
                                <label for="example-text-input" class="col-md-4 col-form-label">Description</label>
                                <div class="col-md-8">
                                    <spring:textarea path="description" class="form-control" id="example-text-input" placeHolder="Description" ></spring:textarea> </div>
                            </div>
                            
                            <div class="form-group row" align="center">
                                <div class="col-md-12">
                                    <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save"> </div>
                            </div>
                </spring:form>
                </c:if>
                </div>
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


            $("#ReleaseTable").tablesorter({
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
        <c:if test="${ProjectReleaseEdit!=null}">
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
                            window.location = "projectrelease.html";
                        }
                    }
                });
            });
        </script>
    </c:if>
    
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    
    <link href="css/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">
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
</body>

</html>