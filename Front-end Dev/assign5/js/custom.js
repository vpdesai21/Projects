locations = null;

$(function() {
  
	var storelist = JSON.parse(storelistjson);
	locations = storelist.location;

  	initMap();

});


function initMap() {

    var map = new google.maps.Map(document.getElementById('map-canvas'),{
	    zoom: 9,
	    center: {lat: 37.3382, lng: -121.8863}
	  });

    for (var key in locations)
	{
	   if (locations.hasOwnProperty(key))
	   {

	      var lat = locations[key].latitude;
	      var lng = locations[key].longitude;
	      var addr = locations[key].address;
	      var type = locations[key].type;
        var rev = locations[key].$revenue;

        /// default red pin
        var image = new google.maps.MarkerImage(
            "images/red-pin.png",
            null,
            null,
            null, 
            new google.maps.Size(20, 32)
        ); 


        if(type == "Distribution Facility") {
          image = new google.maps.MarkerImage(
            "images/red-pin.png",
            null,
            null,
            null, 
            new google.maps.Size(20, 32)
          ); 
        }
        if(type == "RetailLocation") {
          image = new google.maps.MarkerImage(
            "images/green-pin.png",
            null,
            null,
            null, 
            new google.maps.Size(20, 32)
        ); 
        }
        if(type == "Call Center") {
          image = new google.maps.MarkerImage(
            "images/blue-pin.png",
            null,
            null,
            null, 
            new google.maps.Size(20, 32)
        ); 
        }
        if(type == "HeadQuarters") {
          image = new google.maps.MarkerImage(
            "images/white-pin.png",
            null,
            null,
            null, 
            new google.maps.Size(20, 32)
        ); 
        }
	      
	      var marker = new google.maps.Marker({
                                          map: map,
                                          position: {lat: lat, lng: lng},
                                          title: addr,
                                          icon: image
                                          });

        var revCircle = new google.maps.Circle({
          strokeColor: '#969696',
          strokeOpacity: 0.8,
          strokeWeight: 2,
          fillColor: '#969696',
          fillOpacity: 0.35,
          map: map,
          center: {lat: lat, lng: lng},
          radius: Math.sqrt(rev) * 2
        });
	   }
	}
}
   
    
var storelistjson = '{'+
    '"location": ['+
        '{'+
            '"id": "0001",'+
            '"type": "RetailLocation",'+
            '"address": "Fremont, CA 94538",'+
            '"latitude": 37.542571,'+
            '"longitude": -121.993037,'+
            '"$revenue": 10000000'+
        '},'+
        '{'+
        '"id": "0002",'+
        '"type": "RetailLocation",'+
        '"address": "Newark, CA",'+
        '"latitude": 37.525400,'+
        '"longitude":-122.037764,'+
        '"$revenue": 3000000'+
      '},'+
      '{'+
        '"id": "0003",'+
        '"type": "RetailLocation",'+
        '"address": "4100-4198 Pleiades Pl,Union City, CA 94587",'+
        '"latitude": 37.587546,'+
        '"longitude":-122.066716,'+
        '"$revenue": 120000000'+
      '},'+
      '{'+
      '"id": "0004",'+
      '"type": "RetailLocation",'+
      '"address": "4100-4198 Pleiades Pl,Union City, CA 94587",'+
      '"latitude": 37.587546,'+
      '"longitude":-122.066716,'+
      '"$revenue": 120000000'+
    '},'+
      '{'+
        '"id": "0005",'+
        '"type": "RetailLocation",'+
        '"address": "Burbank,Hayward, CA",'+
        '"latitude": 37.660284,'+
        '"longitude": -122.089396,'+
        '"$revenue": 5000000'+
      '},'+
      '{'+
        '"id": "0006",'+
        '"type": "Distribution Facility",'+
        '"address": "Sugarloaf San Mateo, CA",'+
        '"latitude": 37.527798,'+
        '"longitude": -122.312989,'+
        '"$revenue": 300000'+
      '},'+
      '{'+
        '"id": "0007",'+
        '"type": "RetailLocation",'+
        '"address": "San Carlos, CA",'+
        '"latitude": 37.492686,'+
        '"longitude": -122.249346,'+
        '"$revenue": 3002000'+
      '},'+
      '{'+
        '"id": "0008",'+
        '"type": "RetailLocation",'+
        '"address": "Santa Cruz County CA",'+
        '"latitude": 37.007888,'+
        '"longitude": -122.067355,'+
        '"$revenue": 88999090'+
      '},'+
      '{'+
        '"id": "0009",'+
        '"type": "RetailLocation",'+
        '"address": "Santa Clara County CA",'+
        '"latitude": 37.113164,'+
        '"longitude": -121.651485,'+
        '"$revenue": 88999090'+
      '},'+
      '{'+
        '"id": "0010",'+
        '"type": "Distribution Facility",'+
        '"address": "Santa Cruz County CA",'+
        '"latitude": 37.006852,'+
        '"longitude": -122.064148,'+
        '"$revenue": 1000000'+
      '},'+
      '{'+
      '"id": "0011",'+
      '"type": "Call Center",'+
      '"address": "Santa Clara, CA",'+
      '"latitude": 37.344717,'+
      '"longitude":  -121.979666,'+
      '"$revenue": 1000000'+
    '},'+
    '{'+
      '"id": "0012",'+
      '"type": "RetailLocation",'+
      '"address": "Pleasanton, CA",'+
      '"latitude": 37.638625,'+
      '"longitude":  -121.911430,'+
      '"$revenue": 1000000'+
    '},'+
      '{'+
        '"id": "0013",'+
        '"type": "HeadQuarters",'+
        '"address": "Mission District San Francisco, CA",'+
        '"latitude": 37.753038,'+
        '"longitude":  -122.423198,'+
        '"$revenue": 1000000'+
      '},'+
      '{'+
        '"id": "0014",'+
        '"type": "RetailLocation",'+
        '"address": "Pacifica, CA",'+
        '"latitude": 37.594870,'+
        '"longitude":  -122.473562,'+
        '"$revenue": 50000'+
      '},'+
      '{'+
        '"id": "0015",'+
        '"type": "RetailLocation",'+
        '"address": "Gilroy, CA",'+
        '"latitude": 36.995174,'+
        '"longitude": -121.602745,'+
        '"$revenue": 50000'+
      '}'+       
    ']'+
'}';                             
                              