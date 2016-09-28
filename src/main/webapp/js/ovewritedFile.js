       
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

            $(".TableSorting").tablesorter({
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
        $.sidebarMenu($('.sidebar-menu'));
        jQuery(document).ready(function($) {
            $('#tabs').tab();
        });
        $.validate({
            lang: 'en',
            borderColorOnError: '#F00',
        });
        $('.form_date').datetimepicker({
            language: 'en',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
        $(".readonly").keydown(function(e){
            e.preventDefault();
        });
        
        
        function designationLoad() {
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
            xhttp.open("GET", "designationView.html?departmentId=" + department, true);
            xhttp.send();
        }
        
        function userNameValid() {
            var xhttp;
            var userName = document.getElementById('userName').value;

            if (window.XMLHttpRequest) {
                // code for modern browsers
                xhttp = new XMLHttpRequest();
            } else {
                // code for IE6, IE5
                xhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("userNameValid").innerHTML = this.responseText;
                }
            };
            xhttp.open("GET", "userNameValid.html?userName=" + userName, true);
            xhttp.send();
        }
        
        function loadUser() {
            var xhttp;
            var designation = parseInt(document.getElementById('designationView').value);

            if (window.XMLHttpRequest) {
                // code for modern browsers
                xhttp = new XMLHttpRequest();
            } else {
                // code for IE6, IE5
                xhttp = new ActiveXObject(
                    "Microsoft.XMLHTTP");
            }
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document
                        .getElementById("userView").innerHTML = this.responseText;
                }
            };
            xhttp.open("GET", "usersView.html?designationId=" + designation, true);
            xhttp.send();
        }
        
        $( ".personal-form" ).submit(function( event ) {
        	  if ( $("#userNameValidInput").val() === "correct" ) {
        		  
        	    return;
        	  }
        	 
        	  $( "#errorMessage" ).text( "UserName Already Exists..!" ).show().fadeOut(3000);
        	  event.preventDefault();
        	});
        
        function cldate() {
            var date1 = document.getElementById('dtp_input3').value;
            var date2 = document.getElementById('dtp_input4').value;
            var oneDay = 24 * 60 * 60 * 1000; // hours*minutes*seconds*milliseconds
            var firstDate = new Date(date1);
            var secondDate = new Date(date2);
            var diffDays = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime()) / (oneDay)));
            var dayValue = diffDays + 1;
            document.getElementById('noofDays').value = dayValue;
            if (dayValue <= 0) {
                alert("Please Select Valid Date..!");
                document.getElementById('noofDays').value = 0;
            } else {
                document.getElementById('noofDays').value = dayValue;
            }
        }
       function dialogConfirmation(page){
        $(function() {
            $("#dialog-confirm").dialog({
                modal: true,
                open: function(event, ui) {
                    $(".ui-dialog-titlebar-close", ui.dialog | ui).hide();
                },
                buttons: {
                    Ok: function() {
                        $(this).dialog("close");
                        window.location = page;
                    }
                }
            });
        });
        }
       
       function loadCertificationForm(employeeId) {
           var xhttp;
           var noof = parseInt(document.getElementById('noof').value);
           var employeeId = employeeId;
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
                       language: 'en',
                       weekStart: 1,
                       todayBtn: 1,
                       autoclose: 1,
                       todayHighlight: 1,
                       startView: 2,
                       minView: 2,
                       forceParse: 0
                   });

                   $.validate({
                       lang: 'en',
                       borderColorOnError: '#F00',
                   });
                   $(".readonly").keydown(function(e){
                       e.preventDefault();
                   });
               }
           };
           xhttp.open("GET", "certification_form.html?noof=" + noof + "&eid=" + employeeId, true);
           xhttp.send();
       }
       
       function loadEducationForm(employeeId) {
           var xhttp;
           var noof = parseInt(document.getElementById('noof').value);
           var employeeId = employeeId;
           if (window.XMLHttpRequest) {
               // code for modern browsers
               xhttp = new XMLHttpRequest();
           } else {
               // code for IE6, IE5
               xhttp = new ActiveXObject("Microsoft.XMLHTTP");
           }
           xhttp.onreadystatechange = function() {
               if (this.readyState == 4 && this.status == 200) {
                   document.getElementById("education_form").innerHTML = this.responseText;
                   $('.form_date').datetimepicker({
                       language: 'en',
                       weekStart: 1,
                       todayBtn: 1,
                       autoclose: 1,
                       todayHighlight: 1,
                       startView: 2,
                       minView: 2,
                       forceParse: 0
                   });
                   $.validate({
                       lang: 'en',
                       borderColorOnError: '#F00',
                   });
                   $(".readonly").keydown(function(e){
                       e.preventDefault();
                   });
               }
           };
           xhttp.open("GET", "education_form.html?noof=" + noof + "&eid=" + employeeId, true);
           xhttp.send();
       }
      
