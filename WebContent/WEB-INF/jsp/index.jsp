<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<c:if test="${sessionScope['HRMSEmployeeId']!=null}" >
   <c:redirect url="dashboard.html" /> 
</c:if>
<head>
<title>Human Resource Management System @Ideas2IT</title>
<!--Custom Theme files -->
<link href="images/logo1.png" rel="icon" />
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css/login.css" type="text/css" rel="stylesheet" media="all">

<!-- //Custom Theme files -->
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<!--//end-animate-->
</head>
<body>
 <div id="dialog-confirm" title="Alert" style="display:none;">
        <p>
            <c:if test="${Error!=null}">
                <c:out value="${Error}" /></c:if>
        </p>
    </div>

	<!--banner-->
	<div class="banner">
		<!--navigation-->
		<div class="top-nav">
			<div class="container">
				<div class="navbar-header logo">
                                        <div class="wow fadeInUp animated" data-wow-delay=".5s"><a href="index.html"><img src="images/logo.png" alt=""/></a></div>
				</div>
			</div>
		</div>
		<!--//navigation-->
		<div class="banner-text">
			<div class="bnr-title wow zoomIn animated" data-wow-delay=".5s"><img src="images/logo1.png" width="40%" alt=""/></div>	
			<p class="wow fadeInUp animated" data-wow-delay=".7s">Human Resource Management System</p>	
			<div class="more">
			<nav class="main-nav">
				<a href="javascript:void(0);" class="button scroll cd-signin" id="click_button" data-text="login">LogIn</a>
			</nav>
			</div>
			<div class="social-icons wow slideInUp animated" data-wow-delay=".9s">
				<ul>
                    <li><a href="http://www.ideas2it.com/" class="ideas"></a></li>
					<li><a href="https://www.facebook.com/Ideas2itTechnologies/"> </a></li>
					<li><a href="https://www.linkedin.com/company/ideas2it" class="in"> </a></li>
					<li><a href="https://twitter.com/ideas2it" class="twi"> </a></li>
				</ul>
			</div>
		</div>	
	</div>
	<div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
		<div class="cd-user-modal-container"> <!-- this is the container wrapper -->			
			<div id="cd-login"> <!-- log in form -->
				<form class="cd-form" method="post" action="login.html">
					<p class="fieldset">
						<label class="image-replace cd-email" for="signin-email">User Name</label>
						<input class="full-width has-padding has-border" id="signin-email" name="uname" type="text" placeholder="Username" required="required">
						<span class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signin-password">Password</label>
						<input class="full-width has-padding has-border" id="signin-password" type="password" name="password"  placeholder="Password" required="required">
						
						<a href="#0" class="hide-password">Show</a>
						<span class="cd-error-message">Error message here!</span>
					</p>

					
					<p class="fieldset">
						<input class="full-width" type="submit" value="Login">
					</p>
				</form>
				
				
				<!-- <a href="#0" class="cd-close-form">Close</a> -->
			</div> <!-- cd-login -->

			<div id="cd-reset-password"> <!-- reset password form -->
				<p class="cd-form-message">Lost your password? Please enter your Username address. You will receive a link no your e-mail to create a new password.</p>

				<form class="cd-form">
					<p class="fieldset">
						<label class="image-replace cd-email" for="reset-email">Username</label>
						<input class="full-width has-padding has-border" id="reset-email" type="text" placeholder="Username">
						<span class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<input class="full-width has-padding" type="submit" value="Reset password">
					</p>
				</form>

				<p class="cd-form-bottom-message"><a href="#0">Back to log-in</a></p>
			</div> <!-- cd-reset-password -->
			<a href="#0" class="cd-close-form">Close</a>
		</div> <!-- cd-user-modal-container -->
	</div> <!-- cd-user-modal -->
  <link rel="stylesheet" href="css/jquery-ui.css" />
    <script src="js/jquery-3.0.0.min.js"></script>
<script src="js/main.js"></script>
    <script src="js/sidebar-menu.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/bootstrap.js"></script>
<c:if test="${Error!=null}">
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
                            window.location = "index.html";
                        }
                    }
                });
            });
        </script>
    </c:if>
</body>
</html>
