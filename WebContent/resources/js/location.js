
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

