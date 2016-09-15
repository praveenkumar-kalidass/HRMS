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
<c:if test="${sessionScope['HRMSRole']=='Employee'}">
	<c:redirect url="employee_view.html?id=${HRMSEmployeeId}" />
</c:if>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DashBoard</title>
<link href="images/logo1.png" rel="icon" />
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" href="css/sidebar-menu.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/animate.css">

<!-- bootstrap-css -->
<link href="css/bootstrap1.css" rel="stylesheet" type="text/css"
	media="all" />
<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="css/style1.css" type="text/css" media="all" />
<!--// css -->
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<!--animate-->
<link href="css/animate1.css" rel="stylesheet" type="text/css"
	media="all">
<script src="js/wow.min.js"></script>
<script>
		 new WOW().init();
	</script>
<!--//end-animate-->

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

                <div class="wow fadeInUp animated" data-wow-delay="1s">
				<div class="birthday">
					<center>
						<h3>Birthday Countdown</h3>
					</center>
					<div class="birthday-days-block">
						<div class="birthday-days" id="days"></div>
						<center>
							<h5>Days</h5>
						</center>
					</div>
					<div class="birthday-days-block">
						<div class="birthday-days" id="Bhours"></div>
						<center>
							<h5>Hours</h5>
						</center>
					</div>
					<div class="birthday-days-block">
						<div class="birthday-days" id="minutes"></div>
						<center>
							<h5>Minutes</h5>
						</center>
					</div>
					<div class="birthday-days-block">
						<div class="birthday-days" id="seconds"></div>
						<center>
							<h5>Seconds</h5>
						</center>
					</div>
					<div class="birthday-image">
						<img class="bdayimage" src="images/birthday.jpg" />
					</div>
				</div>
				</div>

				<!-- content-top-grids -->
				<div class="wow fadeInUp animated" data-wow-delay="1s">
				<div class="analog-clock">
					<div class="clock-grids wow fadeInUp animated" data-wow-delay=".5s">
						<div class="clock-heading">
							<h3>My Clock</h3>
						</div>
						<div class="clock-left">
							<div id="myclock"></div>
						</div>
						<div class="clock-bottom">
							<div class="clock">
								<div id="Date"></div>
								<ul>
									<li id="hours"></li>
									<li id="point">:</li>
									<li id="min"></li>
									<li id="point">:</li>
									<li id="sec"></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				</div>

				<div class="wow fadeInUp animated" data-wow-delay="1s"
					id="columnchartContainer"
					style="height: 300px; width: 45%; float: right; margin-top: 10px; margin-right: 50px; border: 2px solid #3184D5; border-radius: 5px;">
				</div>

				<div class="wow fadeInUp animated" data-wow-delay="1s"
					id="chartContainer"
					style="height: 300px; width: 45%; float: left; margin-top: 10px; margin-left: 20px; border: 2px solid #3184D5; border-radius: 5px;">
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
					text: "Users"
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
        $("#days").countdown("${Birthday}",function(event) {
        $(this).text(
            event.strftime('%D')
        );
        });
        $("#Bhours").countdown("${Birthday}",function(event) {
            $(this).text(
                event.strftime('%H')
            );
        });
        $("#minutes").countdown("${Birthday}",function(event) {
            $(this).text(
                event.strftime('%M')
            );
        });
        $("#seconds").countdown("${Birthday}",function(event) {
            $(this).text(
                event.strftime('%S')
            );
        });
    </script>

		<!-- clock -->
		<script language="javascript" type="text/javascript"
			src="js/jquery.thooClock.js"></script>
		<script language="javascript">
		var intVal, myclock;

		$(window).resize(function(){
			window.location.reload()
		});

		$(document).ready(function(){

			var audioElement = new Audio("");

			//clock plugin constructor
			$('#myclock').thooClock({
				size:$(document).height()/1.4,
				onAlarm:function(){
					//all that happens onAlarm
					$('#alarm1').show();
					alarmBackground(0);
					//audio element just for alarm sound
					document.body.appendChild(audioElement);
					var canPlayType = audioElement.canPlayType("audio/ogg");
					if(canPlayType.match(/maybe|probably/i)) {
						audioElement.src = 'alarm.ogg';
					} else {
						audioElement.src = 'alarm.mp3';
					}
					// erst abspielen wenn genug vom mp3 geladen wurde
					audioElement.addEventListener('canplay', function() {
						audioElement.loop = true;
						audioElement.play();
					}, false);
				},
				showNumerals:true,
				brandText:'THOOYORK',
				brandText2:'Germany',
				onEverySecond:function(){
					//callback that should be fired every second
				},
				//alarmTime:'15:10',
				offAlarm:function(){
					$('#alarm1').hide();
					audioElement.pause();
					clearTimeout(intVal);
					$('body').css('background-color','#FCFCFC');
				}
			});

		});



		$('#turnOffAlarm').click(function(){
			$.fn.thooClock.clearAlarm();
		});


		$('#set').click(function(){
			var inp = $('#altime').val();
			$.fn.thooClock.setAlarm(inp);
		});

		
		function alarmBackground(y){
				var color;
				if(y===1){
					color = '#CC0000';
					y=0;
				}
				else{
					color = '#FCFCFC';
					y+=1;
				}
				$('body').css('background-color',color);
				intVal = setTimeout(function(){alarmBackground(y);},100);
		}
	</script>

		<!-- //clock -->
		<!-- clock-bottom -->
		<script type="text/javascript">
	$(document).ready(function() {
	// Create two variable with the names of the months and days in an array
	var monthNames = [ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ]; 
	var dayNames= ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]

	// Create a newDate() object
	var newDate = new Date();
	// Extract the current date from Date object
	newDate.setDate(newDate.getDate());
	// Output the day, date, month and year    
	$('#Date').html(dayNames[newDate.getDay()] + " " + newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' + newDate.getFullYear());

	setInterval( function() {
		// Create a newDate() object and extract the seconds of the current time on the visitor's
		var seconds = new Date().getSeconds();
		// Add a leading zero to seconds value
		$("#sec").html(( seconds < 10 ? "0" : "" ) + seconds);
		},1000);
		
	setInterval( function() {
		// Create a newDate() object and extract the minutes of the current time on the visitor's
		var minutes = new Date().getMinutes();
		// Add a leading zero to the minutes value
		$("#min").html(( minutes < 10 ? "0" : "" ) + minutes);
		},1000);
		
	setInterval( function() {
		// Create a newDate() object and extract the hours of the current time on the visitor's
		var hours = new Date().getHours();
		// Add a leading zero to the hours value
		$("#hours").html(( hours < 10 ? "0" : "" ) + hours);
		}, 1000);
		
	}); 
	</script>
		<!-- clock-bottom -->
</body>
</html>