<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope['HRMSEmployeeId']==null}">
	<c:redirect url="index.html" />
</c:if>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Attendance Details</title>
<link href="images/logo1.png" rel="icon" />
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" href="css/sidebar-menu.css">
</head>

<body>
	<div id="dialog-confirm" title="Alert" style="display: none;">
		<p>
			<c:if test="${message!=null}">
				<c:out value="${message}" />
			</c:if>
		</p>
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
					<!-- Main Start -->

					<div class="tab-content">
						<div id="Employee-Table" role="tabpanel" class="tab-pane active">
							<div class="form">
								<div class="main-head">
									<div class="main-head">
										<h1 class="title" style="float: left; width: 90%;">
											Employee Attendance Details</h1>
									</div>

									<div id="chartContainer"
										style="float: left; margin-bottom: 10px; height: 400px; width: 100%;">
									</div>
									<div style="padding-top: 30px; margin-top: 30px;">

										<c:if test="${AttendanceList!=null}">
											<table>
												<thead>
													<tr>
														<th>Date</th>
														<th>Time-In</th>
														<th>Time-Out</th>
												</thead>
												<tfoot>

													<tr>
														<th colspan="7" class="ts-pager form-horizontal">
															<button type="button" class="btn first">
																<i class="fa fa-fast-backward "></i>
															</button>
															<button type="button" class="btn prev">
																<i class="fa fa-step-backward "></i>
															</button> <span class="pagedisplay"></span> <!-- this can be any element, including an input -->
															<button type="button" class="btn next">
																<i class="fa fa-step-forward"></i>
															</button>
															<button type="button" class="btn last">
																<i class="fa fa-fast-forward"></i>
															</button> <select class="pagesize input-mini"
															title="Select page size">
																<option selected="selected" value="10">10</option>
																<option value="20">20</option>
																<option value="30">30</option>
																<option value="40">40</option>
																<option value="50">50</option>
														</select> <select class="pagenum input-mini"
															title="Select page number"></select>
														</th>
													</tr>
												</tfoot>
												<tbody>
													<c:forEach var="attendance" items="${AttendanceList}">
														<tr>
															<td><c:out value="${attendance.date}"></c:out></td>
															<td><c:out value="${attendance.timeIn}"></c:out></td>
															<td><c:out value="${attendance.timeOut}"></c:out></td>

														</tr>
													</c:forEach>

												</tbody>
											</table>
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

		<c:if test="${message!=null}">
			<script>
                $(function() {
                    $("#dialog-confirm").dialog({
                        modal: true,
                        open: function(event, ui) {
                            $(".ui-dialog-titlebar-close", ui.dialog | ui).hide();
                        },
                        buttons: {
                            Ok: function() {
                                $(this).dialog("close");
                                window.location = "attendance.html";
                            }
                        }
                    });
                });
            </script>
		</c:if>
		<script src="js/canvasjs.min.js"></script>
		<script type="text/javascript">
		window.onload = function () {
			var chart = new CanvasJS.Chart("chartContainer", {
				title: {
					text: "Attendance Plot",
					fontSize: 30
				},
				animationEnabled: true,
				axisX: {
					gridColor: "Silver",
					tickColor: "silver",
					valueFormatString: "DD/MMM"
				},
				toolTip: {
					shared: true
				},
				theme: "theme2",
				axisY: {
					gridColor: "Silver",
					tickColor: "silver",
				},
				legend: {
					verticalAlign: "center",
					horizontalAlign: "right"
				},
				data: [	
				{
					type: "line",
					showInLegend: true,
					lineThickness: 2,
					name: "Time-Out",
					markerType: "square",
					color: "#F08080",
					dataPoints: [
                    <c:forEach var="attendance" items="${AttendanceList}">
					{ x: new Date(new Date("${attendance.date}").getFullYear(),new Date("${attendance.date}").getMonth(),new Date("${attendance.date}").getDate()), y: new Date("Jan 1, 2000 ${attendance.timeOut}").getHours() },
					</c:forEach>
					]
				},
				{
					type: "line",
					showInLegend: true,
					name: "Time-In",
					color: "#20B2AA",
					lineThickness: 2,
					dataPoints: [
                    <c:forEach var="attendance" items="${AttendanceList}">
                    { x: new Date(new Date("${attendance.date}").getFullYear(),new Date("${attendance.date}").getMonth(),new Date("${attendance.date}").getDate()), y: new Date("Jan 1, 2000 ${attendance.timeIn}").getHours() },
                    </c:forEach>
					]
				}
				],
				legend: {
					cursor: "pointer",
					itemclick: function (e) {
						if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
							e.dataSeries.visible = false;
						}
						else {
							e.dataSeries.visible = true;
						}
						chart.render();
					}
				}
			});

			chart.render();
		}
	</script>
</html>
