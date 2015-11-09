locations = null;

$(function() {
  
	var storelist = JSON.parse(storelistjson);
	locations = storelist.location;

  	initMap();

});


function initMap() {

    var map = new google.maps.Map(document.getElementById('map-canvas'),{
	    zoom: 6,
	    center: {lat: 37.3382, lng: -121.8863}
	  });

    for (var key in locations)
	{
	   if (locations.hasOwnProperty(key))
	   {

			var lat = locations[key].latitude;
			var lng = locations[key].longitude;
			var name = locations[key].name;
			var id = locations[key].id;

	        var marker = new google.maps.Marker({
	                                          map: map,
	                                          position: {lat: lat, lng: lng},
	                                          title: name
	                                          });
        }

		marker.addListener('click', function() {
			$("#myButton").trigger('click')
		});
    }
}


var storelistjson = '{'+
    '"location": ['+
        '{'+
            '"id": "0001",'+
            '"name": "Lake Shasta",'+
            '"latitude": 40.6781,'+
            '"longitude": -122.3700'+
        '},'+
        '{'+
            '"id": "0002",'+
            '"name": "Trinity Lake",'+
            '"latitude": 40.8225,'+
            '"longitude": -122.7650'+
        '},'+
        '{'+
            '"id": "0003",'+
            '"name": "Lake Oroville",'+
            '"latitude": 39.5372,'+
            '"longitude": -121.4833'+
        '},'+
        '{'+
            '"id": "0004",'+
            '"name": "Folsom Lake",'+
            '"latitude": 38.7206,'+
            '"longitude": -121.1339'+
        '},'+
        '{'+
            '"id": "0005",'+
            '"name": "New Melones Lake",'+
            '"latitude": 37.9990,'+
            '"longitude": -120.5212'+
        '},'+
        '{'+
            '"id": "0006",'+
            '"name": "Don Pedro Reservoir",'+
            '"latitude": 37.7415,'+
            '"longitude": -120.3735'+
        '},'+
        '{'+
            '"id": "0007",'+
            '"name": "New Exchequer Dam",'+
            '"latitude": 37.5861,'+
            '"longitude": -120.2694'+
        '},'+
        '{'+
            '"id": "0008",'+
            '"name": "San Luis Lake",'+
            '"latitude": 35.2347,'+
            '"longitude": -119.8932'+
        '},'+
        '{'+
            '"id": "0009",'+
            '"name": "Millerton Lake",'+
            '"latitude": 37.0425,'+
            '"longitude": -119.6545'+
        '},'+
        '{'+
            '"id": "0010",'+
            '"name": "Pine FLat Lake",'+
            '"latitude": 36.8325,'+
            '"longitude": -119.3259'+
        '},'+
        '{'+
            '"id": "0011",'+
            '"name": "Pyramid Lake",'+
            '"latitude": 34.6548333,'+
            '"longitude": -118.7751843'+
        '},'+
        '{'+
            '"id": "0012",'+
            '"name": "Castaic Lake",'+
            '"latitude": 34.5247,'+
            '"longitude": -118.5876'+
        '}'+
    ']'+
'}';
     