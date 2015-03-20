var express = require('express')
  ,	mongoClient = require('mongodb').MongoClient
  , http = require('http')
  , path = require('path')
  , url = require('url')
  , redis = require('redis')
  , myModule = require('./my_module.js')
  , config = require('./config.js');

var app = express();

//global redis client for caching/retrieving purposes
redis_client = redis.createClient(config.redis.port, config.redis.host);

// all environments
app.set('port', 80);
app.set('views', './views');
app.set('view engine', 'jade');
app.use(express.static('./public'));
app.use('/public', express.static(path.resolve('./public')));

var db;

/*
 * Connection pooling to minimize database overheads
 */
mongoClient.connect("mongodb://"+config.mongo.user_name+":"+config.mongo.password+"@ds041160.mongolab.com:41160/my_mongo", function(err, database) {
  if(err)
	throw err;
  db = database;
});

app.get("/", function(req, res) {
	res.send('<h1 style="color:gray;">Welcome to My Product Search !!</h1><h3>Type the URL of product you want to search</h3><h3><em>For example : /products/samsung_tv for Samsung TV</em></h3>');
});

app.get("/products/:product", function(req, res) {
	var myurl = "/products/" + req.params.product;
	
	/*If the url is already present in cache, 
	 *fetch product details from redis server or else query database
	 */
	redis_client.exists ( myurl, function(err, reply) {
		if( reply === 1) {
			redis_client.get(myurl, function(err, reply) {
				console.log(reply);
				res.send('<strong>Cache Product Details : <strong><hr/><em>' + reply + '</em>');
			});
		} else {
			db.collection('products', function (err, connection){
				if(err){
					console.log("Error in fetching products collection : \n" + err);
					db.close();
				} else {
					myModule.findProductByUrl(res, connection, myurl, myModule.callback);
				}
			});
		}
	});
});

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
