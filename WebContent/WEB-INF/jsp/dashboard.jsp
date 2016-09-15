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
    <title>DashBoard</title>
    <link href="images/logo1.png" rel="icon" />
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/sidebar-menu.css">
    <link rel="stylesheet" href="css/animate.css"> </head>

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
            
            <div class="wow fadeInUp animated" data-wow-delay="1s" id="columnchartContainer" style="height: 300px; width: 45%; float: left; margin-left: 20px; border: 2px solid #3184D5; border-radius: 5px; ">
            </div>
	        
	        <div class="wow fadeInUp animated" data-wow-delay="1s" id="chartContainer" style="height: 300px; width: 45%; float: right; margin-right: 20px; border: 2px solid #3184D5; border-radius: 5px; ">
	        </div>
            
            <div class="wow fadeInUp animated" data-wow-delay="1s" id="getting-started">
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

    
    <script>
        $.sidebarMenu($('.sidebar-menu'));
    </script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $('#tabs').tab();
        });
    </script>

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
                            window.location = "dashboard.html";
                        }
                    }
                });
            });
        </script>
    </c:if>
    
    <script src="js/canvasjs.min.js"></script>
    <script type="text/javascript">
    window.onload = function () {
		var columnchart = new CanvasJS.Chart("columnchartContainer", {
			title: {
				text: "Employees"
			},
			data: [{
				type: "column",
				dataPoints: [
					{ y: ${DeveloperCount}, label: "Developer" },
					{ y: ${TestingCount}, label: "Testing" },
					{ y: ${HRCount}, label: "HR" },
					{ y: ${ManagementCount}, label: "Management" },
					{ y: ${OthersCount}, label: "Others" }
				]
			}]
		});
		columnchart.render();
			
			var chart = new CanvasJS.Chart("chartContainer", {
				title: {
					text: "Pie Chart of Users"
				},
				animationEnabled: true,
				theme: "theme2",
				data: [
				{
					type: "doughnut",
					indexLabelFontFamily: "Garamond",
					indexLabelFontSize: 20,
					startAngle: 0,
					indexLabelFontColor: "dimgrey",
					indexLabelLineColor: "darkgrey",
					toolTipContent: "{y}%",

					dataPoints: [
					{ y: "${AdminPercent}", indexLabel: "Admin {y}%" },
					{ y: "${EmployeePercent}", indexLabel: "Employee {y}%" }
					]
				}
				]
			});
			
			chart.render();
		}
	</script>
	<script src="js/jquery.countdown.js"></script>
	<script src="js/jquery.countdown.min.js"></script>
	<script type="text/javascript">
        $("#getting-started").countdown("${Birthday}",function(event) {
        $(this).text(
            event.strftime('%D days %H:%M:%S')
        );
        });
    </script>
</body>
</html>