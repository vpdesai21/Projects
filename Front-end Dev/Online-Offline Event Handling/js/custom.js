$(document).ready(function () {
			if(!navigator.offline) {
				$("#status").removeClass().addClass("online");
				$("#status").html("You are now online . .");
			} else {
				$("#status").removeClass().addClass("offline");
				$("#status").html("Network connection down .. Going offline . .");
			}
			
			isOnline = function() {
							 $( "#status" ).animate({
								opacity: 0
								}, 50 );
							 $("#status").html("You are now online . .");
							 $("#status").removeClass().addClass("online");
							 $( "#status" ).animate({
								opacity: 1
								}, 1500 );
						};
						
			isOffline = function() {
							$( "#status" ).animate({
								opacity: 0
								}, 50 );
							$("#status").html("Network connection down .. Going offline . .");
							$("#status").removeClass().addClass("offline");
							$( "#status" ).animate({
								opacity: 1
								}, 1500 );
						};
			
			if (window.addEventListener) {
				window.addEventListener("online", isOnline, false);
				window.addEventListener("offline", isOffline, false);
			}
			else {
				document.body.ononline = isOnline;
				document.body.onoffline = isOffline;
			}
		});