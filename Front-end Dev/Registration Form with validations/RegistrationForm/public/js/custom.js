$(document).ready(function(){
	var isValidPassword = false;
	var isPasswordMatch = false;
	var isValidEmail = false;
	var isValidPhone = false;
	
	var characters = 0;
	var capitalletters = 0;
	var loweletters = 0;
	var number = 0;
	var special = 0;

	var upperCase= new RegExp('[A-Z]');
	var lowerCase= new RegExp('[a-z]');
	var numbers = new RegExp('[0-9]');
	var specialchars = new RegExp('([!,%,&,@,#,$,^,*,?,_,~])');

	////////////////////////////////////////////////////////////////////////////////////
	$("#password").keyup(function(){
		var passStr = $("#password").val();
		var val = $("#password").val().length * 5;
			
		var strength = check_strength(passStr);
		
		if(passStr.length < 8 || strength < 4) {
			isValidPassword = false;
			val = val > 30 ? 30 : val;
			$("#password_strength").removeClass().addClass("progress-bar progress-bar-danger progress-bar-striped active");
		} else if(passStr.length >= 8 && passStr.length < 12) {
			isValidPassword = false;
			val = val > 60 ? 60 : val;
			$("#password_strength").removeClass().addClass("progress-bar progress-bar-warning progress-bar-striped active");
		} else {
			$("#password_strength").removeClass().addClass("progress-bar progress-bar-success progress-bar-striped active");
			isValidPassword = true;
		}
		$("#password_strength").attr("aria-valuenow" , val);
		$("#password_strength").css({width : val+"%"});	
	}).focusout(function( event ) {
		var passStr = $("#password").val();
		var username = $("#userid").val();
		if(passStr == username) {
			isValidPassword = false;
			$("#opass_indicator").removeClass().addClass("nomatch");
		}
	}).keydown(function( event ) {
	  if ( event.which == 13 ) {
		event.preventDefault();
	  }
	});
	
	$("#password").focusin(function() {
		$("#opass_indicator").removeClass();
	});
	
	
	$("#confirm_password").focusout(function() {
		var passStr = $("#confirm_password").val();
		var passLen = $("#confirm_password").val().length;
		
		var val = $("#password").val();
		var len = $("#password").val().length;

		if(passLen == len) {
			if(passStr == val) {
				isPasswordMatch = true;
				$("#pass_indicator").removeClass().addClass("match");
			} else {
				isPasswordMatch = false;
				$("#pass_indicator").removeClass().addClass("nomatch");
			}
		} else {
			isPasswordMatch = false;
			$("#pass_indicator").removeClass().addClass("nomatch");
		}
	}).focusin(function() {
		$("#pass_indicator").removeClass();
	});
	
	function check_strength(thisval){
		if (thisval.length > 7) { characters = 1; } else { characters = -1; };
		if (thisval.match(upperCase)) { capitalletters = 1} else { capitalletters = 0; };
		if (thisval.match(lowerCase)) { loweletters = 1}  else { loweletters = 0; };
		if (thisval.match(numbers)) { number = 1}  else { number = 0; };
		if (thisval.match(special)) { special = 1}  else { special = 0; };

		var total = characters + capitalletters + loweletters + number + special;
		
		if (!thisval.length) {total = -1;}
		
		return total;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	$("#confirm_email").focusout(function() {
		var passStr = $("#confirm_email").val();
		var passLen = $("#confirm_email").val().length;
		
		var val = $("#email").val();
		var len = $("#email").val().length;

		if(passLen == len) {
			if(passStr == val) {
				isValidEmail = true;
				$("#email_indicator").removeClass().addClass("match");
			} else {
				isValidEmail = false;
				$("#email_indicator").removeClass().addClass("nomatch");
			}
		} else {
			isValidEmail = false;
			$("#email_indicator").removeClass().addClass("nomatch");
		}
	}).focusin(function() {
		$("#email_indicator").removeClass();
	});
	
	///////////////////////////////////////////////////////////////////////////////////
	$("#phone").focusout(function() {
		var phoneStr = $("#phone").val();
		var len = $("#phone").val().length;
		
		if(len == 10) {
			if(isNaN(phoneStr)) {
				isValidPhone = false;
				$("#phone_indicator").removeClass().addClass("nomatch");
			} else {
				isValidPhone = true;
				$("#phone_indicator").removeClass().addClass("match");
			}
		} else {
			isValidPhone = false;
			$("#phone_indicator").removeClass().addClass("nomatch");
		}
	}).focusin(function() {
		$("#phone_indicator").removeClass();
	});
	
	//////////////////////////////////////////////////////////////////////////////////////////
	$("#submit").click(function(e){
		if(isValidPassword && isPasswordMatch && isValidEmail && isValidPhone) {
			var dataObj = $('#registerform').serializeObject();
			var formURL = $("#registerform").attr("action");
			$.ajax({
				url : formURL,
				type: "POST",
				data: dataObj,
				datatype: "json",
				success:function(data, textStatus, jqXHR) {
					successMessageDisplay();
				},
				error: function(jqXHR, textStatus, errorThrown) {
					errorMessageDisplay();
				}
			});
			e.preventDefault(); 
		}
	});
	
	
	$.fn.serializeObject = function()
	{
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name] !== undefined) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	};
	
	function successMessageDisplay() {
		$("#failure-image").hide();
		$("#success-image").show();
		$(".modal-title").html("Registration Success !!");
		$(".modal-body p").html("Congratulations !! You have successfully registered and subscribed to the service!!");
		$('#myModal').modal('show');
	}
	
	function errorMessageDisplay() {
		$("#success-image").hide();
		$("#failure-image").show();
		$(".modal-title").html("Registration Failure !!");
		$(".modal-body p").html("Sorry !! You have not entered proper information. Kindly re-submit the form!!");
		$('#myModal').modal('show');
	}
});