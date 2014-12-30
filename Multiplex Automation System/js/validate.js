/*function chkLogin()
{
	var un = document.forms["loginForm"]["uname"].value;
	var ps = document.forms["loginForm"]["pwd"].value;

	
	if(un==null || un=="")
	{
	alert("Please Enter Username !! ");
	return false;
	}
	if(ps==null || ps=="")
	{
	alert("Please Enter Password !! ");
	return false;
	}
	
	if(un=="admin")
	{document.forms.loginForm.action="./adminLogin.html";}
	else
	{document.forms.loginForm.action="./custLogin.html";}
	
	
	document.getElementById("go").submit();
}





function chkMulOpDetails()
{
	
		
		var fn = document.forms["addMulOpForm"]["fname"].value;
		var ln = document.forms["addMulOpForm"]["lname"].value;
		var male = document.forms["addMulOpForm"]["male"].checked;
		var female = document.forms["addMulOpForm"]["female"].checked;
		var date = document.forms["addMulOpForm"]["date"].value;
		var email = document.forms["addMulOpForm"]["email"].value;
		var phno = document.forms["addMulOpForm"]["phno"].value;
		var city = document.forms["addMulOpForm"]["city"].value;
		var state = document.forms["addMulOpForm"]["state"].value;
		var loc = document.forms["addMulOpForm"]["loc"].value;
		var role = document.forms["addMulOpForm"]["role"].selectedIndex;
		var alpha = /^[a-zA-Z]+$/;
		var flg=0;
	//===========Check proper First name and Last Name =============	
	if(fn==null || fn=="")
	{
	alert("Please Enter FirstName ");
	return false;
	}
	
	
	if(!(fn.match(alpha)))
	{
	alert("Error : Enter only alphabets in FirstName !!");
	return false;
	}
	if(fn.length>20)
	{
	alert("Error : Cannot Enter FirstName Greater than 20 Characters!!");
	return false;
	
	}
	
	
	if(ln==null || ln=="" )
	{
	alert("Please Enter LastName !! ");
	return false;
	}
	if(!(ln.match(alpha)))
	{
	alert("Error : Enter only alphabets in LastName !! ");
	return false;
	}
	if(ln.length>20)
	{
	alert("Error : Cannot Enter LastName Greater than 20 Characters!!");
	return false;
	
	}
	
	
	
	
	//======Check gender ====================================
	if( male=="" || male==null)
	{
		if( female=="" || female==null)
		{
			alert("Please Select Gender !! ");
			return false;
		}
		
	}
	
	
	//=====Check date=================================
	if(date=="dd/mm/yyyy" || date==null || date=="" )
	{
	flg=1;
	alert("Please Enter Date Of Birth !! ");
	return false;
	}
	
	
	if(!chkBDate("addMulOpForm"))
	{
	flg=1;
	}
	
	//=========Check Email ID ================
	if(email==null || email=="" )
	{
	alert("Please Enter E-Mail ID !! ");
	return false;
	}
	
	
	
	var atpos=email.indexOf("@");
	var dotpos=email.lastIndexOf(".");

	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
	  {
	  alert("Enter a Valid E-mail ID !!");
	  return false;
	  }
	
	
	
	//===========Check valid phone number ==========
	if(phno==null || phno=="" )
	{
	alert("Please Enter Phone Number !! ");
	return false;
	}
	
	
	
	if(phno.length!=10 || isNaN(phno))
	{
	alert("Enter a Valid Phone Number !!");
	return false;
	}
	
	
	
	//=======Check City , State , Location================
	if(city==null || city=="" )
	{
	alert("Please Enter City !! ");
	return false;
	}
	if(state==null || state=="" )
	{
	alert("Please Enter State !! ");
	return false;
	}
	if(loc==null || loc=="" )
	{
	alert("Please Enter Location !! ");
	return false;
	}
	if((city.length + state.length + loc.length) < 20 )
	{
	alert("Error : Cannot Enter Address Less than 20 Characters!!");
	return false;
	}
	
	//=====Check Role ==========================
	if(role==0)
	{
	alert("Please Select Role !! ");
	return false;
	}
	
	
	if(flg==1)
	{
	window.location.reload();
	return false;
	}
	else
	{
	alert("Multiplex Operator entered Successfully");
	
	var i=0;
	for(i=0;i< 11;i++)
		document.forms["addMulOpForm"][i].value="";
	
	
	
	return true;
	}
	
}





function chkCustomerDetails()
{
	
		
		var fn = document.forms["addCustForm"]["fname"].value;
		var ln = document.forms["addCustForm"]["lname"].value;
		var male = document.forms["addCustForm"]["male"].checked;
		var female = document.forms["addCustForm"]["female"].checked;
		var date = document.forms["addCustForm"]["date"].value;
		var email = document.forms["addCustForm"]["email"].value;
		var phno = document.forms["addCustForm"]["phno"].value;
		var city = document.forms["addCustForm"]["city"].value;
		var state = document.forms["addCustForm"]["state"].value;
		var loc = document.forms["addCustForm"]["loc"].value;
		var alpha = /^[a-zA-Z]+$/;
		var flg=0;
	//===========Check proper First name and Last Name =============	
	if(fn==null || fn=="")
	{
	alert("Please Enter FirstName ");
	return false;
	}
	if(!(fn.match(alpha)))
	{
	alert("Error : Enter only alphabets in FirstName !!");
	return false;
	}
	if(fn.length>20)
	{
	alert("Error : Cannot Enter FirstName Greater than 20 Characters!!");
	return false;
	
	}
	
	
	if(ln==null || ln=="" )
	{
	alert("Please Enter LastName !! ");
	return false;
	}
	if(!(ln.match(alpha)))
	{
	alert("Error : Enter only alphabets in LastName !! ");
	return false;
	}
	if(ln.length>20)
	{
	alert("Error : Cannot Enter LastName Greater than 20 Characters!!");
	return false;
	
	}
	
	//======Check gender ====================================
	if( male=="" || male==null)
	{
		if( female=="" || female==null)
		{
			alert("Please Select Gender !! ");
			return false;
		}
		
	}
	
	
	//=====Check date=================================
	if(date=="dd/mm/yyyy" || date==null || date=="" )
	{
	flg=1;
	alert("Please Enter Date Of Birth !! ");
	return false;
	}
	
	
	if(!chkBDate("addCustForm"))
	{
	flg=1;
	}
	
	//=========Check Email ID ================
	if(email==null || email=="" )
	{
	alert("Please Enter E-Mail ID !! ");
	return false;
	}
	
	
	
	var atpos=email.indexOf("@");
	var dotpos=email.lastIndexOf(".");

	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
	  {
	  alert("Enter a Valid E-mail ID !!");
	  return false;
	  }
	
	
	
	//===========Check valid phone number ==========
	if(phno==null || phno=="" )
	{
	alert("Please Enter Phone Number !! ");
	return false;
	}
	
	
	
	if(phno.length!=10 || isNaN(phno))
	{
	alert("Enter a Valid Phone Number !!");
	return false;
	}
	
	
	
	//=======Check City , State , Location================
	if(city==null || city=="" )
	{
	alert("Please Enter City !! ");
	return false;
	}
	if(state==null || state=="" )
	{
	alert("Please Enter State !! ");
	return false;
	}
	if(loc==null || loc=="" )
	{
	alert("Please Enter Location !! ");
	return false;
	}
	if((city.length + state.length + loc.length) < 20 )
	{
	alert("Error : Cannot Enter Address Less than 20 Characters!!");
	return false;
	}
	
	
	if(flg==1)
	{
	window.location.reload();
	return false;
	}
	else
	{
			//===Success Validation ========================
			alert("Registration Complete !!");
			
			var i=0;
			for(i=0;i< 11;i++)
				document.forms["addCustForm"][i].value="";
			
			document.forms.loginForm.action="./index.html";
			
			
			document.getElementById("go").submit();
		return true;

	}
}





function chkMovieDetails()
{
		var ns = document.forms["addMovieForm"]["nowshowing"].checked;
		var uc = document.forms["addMovieForm"]["upcoming"].checked;
		var loc = document.forms["addMovieForm"]["loc"].value;
		var mname = document.forms["addMovieForm"]["mname"].value;
		var lang = document.forms["addMovieForm"]["lang"].selectedIndex;
		var date = document.forms["addMovieForm"]["date"].value;	
		var show = document.forms["addMovieForm"]["show"].value;
		var screen = document.forms["addMovieForm"]["screen"].selectedIndex;
		var cls = document.forms["addMovieForm"]["cls"].selectedIndex;
		var price = document.forms["addMovieForm"]["price"].value;		
		var i200 = document.forms["addMovieForm"]["i200"].checked;
		var i300 = document.forms["addMovieForm"]["i300"].checked;
		var  flg=0;
	//===========Check Location and MovieName =============	
	if(loc==null || loc=="")
	{
	alert("Please Enter Location ");
	return false;
	}
	if(loc.length > 30)
	{
	alert("Error : Enter Proper Location (Max. 30 characters) !! ");
	return false;
	}
	
	if(mname==null || mname=="")
	{
	alert("Please Enter Movie Name ");
	return false;
	}
	if(mname.length > 30)
	{
	alert("Error : Enter Proper Movie Name (Max. 30 characters) !! ");
	return false;
	}
	
	
	//=====Check Language ==========================
	if(lang==0)
	{
	alert("Please Select Language !! ");
	return false;
	}
	
	//=====Check date=================================
	if(date=="dd/mm/yyyy" || date==null || date=="" )
	{
	flg=1;
	alert("Please Enter Date Of Movie !! ");
	return false;
	}
	if(!chkNewsDate("addMovieForm"))
	{
	flg=1;
	}
	
	
	//===========Check Show =============	
	if(show==null || show=="")
	{
	alert("Please Enter Show ");
	return false;
	}
	
	
	//=====Check Screen ==========================
	if(screen==0)
	{
	alert("Please Select Screen !! ");
	return false;
	}
	
	//=====Check Class ==========================
	if(cls==0)
	{
	alert("Please Select Class !! ");
	return false;
	}
	
	//===== Check Price ===========================
	if(price==null || price=="")
	{
	alert("Please Enter Price ");
	return false;
	}
	if(isNaN(price))
	{
	alert("Error : Enter Only Digits in Price");
	return false;
	}
	
	
	//======Check Seats ====================================
	if( i200=="" || i200==null)
	{
		if( i300=="" || i300==null)
		{
			alert("Please Select Number of Seats !! ");
			return false;
		}
		
	}
	
	
	//======Check Movie type ====================================
	if( ns=="" || ns==null)
	{
		if( uc=="" || uc==null)
		{
			alert("Please Select Movie Type !! ");
			return false;
		}
		
	}
	
	
	if(flg==1)
	{
	window.location.reload();
	return false;
	}
	else
	{
	
	//===Success Validation ========================
	alert("Movie entered Successfully");
	
	var i=0;
	for(i=0;i< 11;i++)
		document.forms["addMovieForm"][i].value="";
	

	
	return true;
	}
	
}
*/


function chkNewsEvents(formName)
{
	var name = document.forms[formName]["eventNewsName"].value;
	var dt = document.forms[formName]["myDate"].value;
	var hr = document.forms[formName]["hr"].value;
	var min = document.forms[formName]["min"].value;
	var img = document.forms[formName]["eventImage"].value;
	var desc = document.forms[formName]["eventNewsDescription"].value;
	var flg=0;
	
	//=====Check Name ==========================
	if(name=="" || name==null)
	{
	alert("Please Enter News / Event Name !! ");
	return false;
	}
	if(name.length < 10)
	{
	alert("Error : Enter Proper News/Event Name ( Min. 10 characters ) !!");
	return false;
	}
	if(!isNaN(name))
	{
	alert("Error : Cannot Enter only Digits in News/Event Name !!");
	return false;
	}
	
	//=====Check date=================================
	if(dt==null || dt=="" )
	{
	flg=1;
	alert("Please Enter Date Of News/Event !! ");
	return false;
	}
	if(!chkNewsDate(formName))
	{
	flg=1;
	}
	
	//=====Check Time ==========================
	if(hr=="" || hr==null || min=="" || min==null)
	{
	alert("Please Enter Time Of News/Event !! ");
	return false;
	}
	if( isNaN(hr)|| isNaN(min) || hr<0 || hr>23 || min<0 || min>59 )
	{
	alert("Error : Enter Proper Time !! ");
	return false;
	}
	
	
	

	//=====Check Image ==========================
	if(formName!="updateNewsEventsForm")
	{
		if(img=="" || img==null)
		{
		alert("Please Select News/Event Image !! ");
		return false;
		}
		
	}
	
	//=====Check Description ==========================
	if(desc=="" || desc==null)
	{
	alert("Please Enter News/Event Description !! ");
	return false;
	}
	if(desc.length < 10)
	{
	alert("Error : Enter Proper News/Event Description ( Min. 10 characters ) !!");
	return false;
	}
	
	
	if(flg==1)
	{
	window.location.reload();
	return false;
	}

	
	return true;

	
}



function validateamenitiesForm()
{
	var ckName = /^[A-Za-z0-9 .]{1,20}$/;

	var name=document.forms["amenitiesForm"]["amenityName"].value;
	var amenityImage=document.forms["amenitiesForm"]["amenityImage"].value;
	var amenityTypeId=document.forms["amenitiesForm"]["amenityTypeId"].value;
	var amenityDescription=document.forms["amenitiesForm"]["amenityDescription"].value;
	if (name==null || name=="")
	{
		document.getElementById("1").innerHTML=" Name must be filled out";
		return false;
	}else if (!ckName.test(name)) {
		document.getElementById("1").innerHTML=" Alphabets, numbers and space(' ')" +
				" no special characters min 1 and max 20 characters. ";
		return false;
	}else if(name.length>20)
	{	document.getElementById("1").innerHTML="name. must   be less then 20 char";
		return false;
	}
	else document.getElementById("1").innerHTML="";
/*	if (amenityImage==null || amenityImage=="")
	{
		document.getElementById("2").innerHTML=" amenityImage must be filled out";
		return false;
	}
	else document.getElementById("2").innerHTML="";*/
	if (amenityDescription==null || amenityDescription=="")
	{
		document.getElementById("3").innerHTML=" amenityDescription must be filled out";
		return false;
	}else if(amenityDescription.length<10 || amenityDescription.length>256)
	{	document.getElementById("3").innerHTML="amenityDescription must   be between 10 to 256 char";
		return false;
	}
	else document.getElementById("3").innerHTML="";
	
	
	return confirm("confirm it");
	
}
function validateAmenityDelete(){
	return confirm("confirm Delete!");
}

function chkRewardPoints()
{
	
	var st = document.forms["addRewardPointsForm"]["start"].value;
	var en = document.forms["addRewardPointsForm"]["end"].value;
	var pt = document.forms["addRewardPointsForm"]["points"].value;
	//alert(st+" "+en);
	//===========Check proper Starting Range =============	
	if(st=="select")
	{
		alert("please select starting range");
		return false;
	}
	if(st==null || st=="")
	{
	alert("Please Enter Starting Range ");
	return false;
	}
	if(isNaN(st))
	{
	alert("Error : Enter only Digits in Starting Range !!");
	return false;
	}
	if(parseInt(st) < 0)
	{
	alert("Error : Enter Proper starting Range \n( Greater than 0) ");
	return false;
	}	
	//alert(st+" -->"+en);
	//===========Check proper Ending Range =============	
	if(en==null || en=="")
	{
	alert("Please Enter Ending Range ");
	return false;
	}
	if(isNaN(en))
	{
	alert("Error : Enter only Digits in Ending Range !!");
	return false;
	}
	//alert(st+" --"+en);
	if(parseInt(en) < 0 || parseInt(en) <= parseInt(st))
	{
	alert("Error : Enter Proper Ending Range \n( Greater than 0 and/or Starting Range) ");
	return false;
	}

	
	//===========Check proper Reward Points =============	
	if(pt==null || pt=="")
	{
	alert("Please Enter Reward Points ");
	return false;
	}
	if(isNaN(pt))
	{
	alert("Error : Enter only Digits in Reward Points !!");
	return false;
	}
	if(parseInt(pt) < 0)
	{
	alert("Error : Enter Proper reward points\n( Greater than 0) ");
	return false;
	}
	//===Success Validation ========================
	//alert("Reward Points entered Successfully");
	
	//var i=0;
	//for(i=0;i< 11;i++)
		//document.forms["addRewardPointsForm"][i].value="";
return true;
}

/*function chkBookingDetails()
{

	var loc = document.forms["bookMovieForm"]["loc"].selectedIndex;
	var mname = document.forms["bookMovieForm"]["mname"].selectedIndex;
	var lang = document.forms["bookMovieForm"]["lang"].selectedIndex;
	var date = document.forms["bookMovieForm"]["date"].value;
	var show = document.forms["bookMovieForm"]["show"].selectedIndex;
	var screen = document.forms["bookMovieForm"]["screen"].selectedIndex;
	var seats = document.forms["bookMovieForm"]["seats"].selectedIndex;
	var cls = document.forms["bookMovieForm"]["cls"].selectedIndex;
	var email = document.forms["bookMovieForm"]["email"].value;
	var phno = document.forms["bookMovieForm"]["phno"].value;
	var flg =0;
	
	//=====Check Location=============
	if(loc==0)
	{
	alert("Please Select Location !! ");
	return false;
	}
	
	//=====Check Name=============
	if(mname==0)
	{
	alert("Please Select Movie !! ");
	return false;
	}
	
	//=====Check Language=============
	if(lang==0)
	{
	alert("Please Select Language !! ");
	return false;
	}
	
	
	//=====Check date=================================
	if(date=="dd/mm/yyyy" || date==null || date=="" )
	{
	flg=1;
	alert("Please Enter Date Of Movie !! ");
	return false;
	}
	if(!chkDate())
	{
	flg=1;
	}
	
	//=====Check Show=============
	if(show==0)
	{
	alert("Please Select Show !! ");
	return false;
	}
	
	
	
	//=====Check Screen=============
	if(screen==0)
	{
	alert("Please Select Screen !! ");
	return false;
	}
	
	//=====Check Seats=============
	if(seats==0)
	{
	alert("Please Select Seats !! ");
	return false;
	}
	
	//=====Check Class=============
	if(cls==0)
	{
	alert("Please Select Class !! ");
	return false;
	}
	
	
	//=========Check Email ID ================
	if(email==null || email=="" )
	{
	alert("Please Enter E-Mail ID !! ");
	return false;
	}
	
	
	
	var atpos=email.indexOf("@");
	var dotpos=email.lastIndexOf(".");

	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
	  {
	  alert("Enter a Valid E-mail ID !!");
	  return false;
	  }
	
	
	
	//===========Check valid phone number ==========
	if(phno==null || phno=="" )
	{
	alert("Please Enter Phone Number !! ");
	return false;
	}
	
	
	
	if(phno.length!=10 || isNaN(phno))
	{
	alert("Enter a Valid Phone Number !!");
	return false;
	}
	
	
	if(flg==1)
	{
	window.location.reload();
	return false;
	}
	else
	{
		//===Success Validation ========================
		
		
		alert("Tickets Booked Successfully ");
		
		var i=0;
		for(i=0;i< 11;i++)
			document.forms["bookMovieForm"][i].value="";
		
		self.close();
		
		return true;
	}
	
	
}




function autoPrice()
{
	var cls = document.forms["bookMovieForm"]["cls"].selectedIndex;

	
	if(cls==1)
	{
	document.forms["bookMovieForm"]["price"].selectedIndex =3;
	}
	else if(cls==2)
	{
	document.forms["bookMovieForm"]["price"].selectedIndex =2;
	}
	else if(cls==3)
	{
	document.forms["bookMovieForm"]["price"].selectedIndex =1;
	}
}



//For booking date validation ---------
function chkDate()
{


	var dt = new Date();
	var flag=0;
	var date = document.forms["bookMovieForm"]["date"].value;
	
	var udd = date.split("/")[0];
	var umm = date.split("/")[1] - 1;
	var uyy = date.split("/")[2];

	var udt = new Date();
	udt.setFullYear(uyy,umm,udd);
	
	
	var difference = (Date.parse(udt) - Date.parse(dt)) / (86400000 * 3);
	if(udt < dt || difference > 1)
	{
	alert("Error : Select Proper Date (Select within 3 Days ) ");
	return false;
	}
		
return true;	
}



//for not having future date as BDate ------
function chkBDate(fname)
{
	
	var dt = new Date();
	var date = document.forms[fname]["date"].value;
	
	var udd = date.split("/")[0];
	var umm = date.split("/")[1] - 1;
	var uyy = date.split("/")[2];

	var udt = new Date();
	udt.setFullYear(uyy,umm,udd);
	
	
	var difference = (Date.parse(udt) - Date.parse(dt));
	if(udt >= dt || difference >= 0)
	{
	alert("Error : Select Proper BirthDate !!");
	return false;
	}
		
return true;	
}

*/



// for not having past date as event / movie date -----
function chkNewsDate(fname)
{
	
	var dt = new Date();
	var date = document.forms[fname]["myDate"].value;
	
	var umm = date.split("/")[0];
	var udd = date.split("/")[1] - 1;
	var uyy = date.split("/")[2];

	var udt = new Date();
	udt.setFullYear(uyy,umm,udd);
	
	
	var difference = (Date.parse(udt) - Date.parse(dt));
	if(udt <= dt || difference <= 0)
	{
	alert("Error : Select Proper Date !!");
	return false;
	}
		
return true;	
}

//For confirming RESET

function confirmReset()
{
var confReset = confirm("Pressing Reset Button will reset all the fields. Press OK to confirm or CANCEL to exit");
	if(confReset==true)
		{
			document.forms.adduserForm1.reset();

		}
	else{
			return false;
		}
}
