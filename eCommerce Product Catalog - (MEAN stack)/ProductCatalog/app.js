
/**
 * Module dependencies.
 */

var express = require('express')
  //, angular = require('angular')
  ,	mongoClient = require('mongodb').MongoClient
  , http = require('http')
  , path = require('path');

var app = express();

// all environments
app.set('port', process.env.PORT || 3000);
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(express.bodyParser());
app.use(express.methodOverride());

app.use(app.router);
app.use(express.static(__dirname +'/public'));
app.use('/public', express.static(path.resolve('./public')));

//-----Default home page----------------
app.get("/", function(req, res){
	res.send('<img src="/images/Thank You.jpg" /> <br/> <a href="/productCatalog" >Click here to go to Product Catalog</a>');
});

//----------Product Page Home Catalog-------------
app.get("/productCatalog", function(req, res){
	mongoClient.connect("mongodb://127.0.0.1:27017/sampleProject", function(err, db){
	if(err) {
		throw err;
	}
	var collection = db.collection('products');
	collection.find().toArray(function(err, results) {
		db.close();
		res.render('productCatalog/products', { products: results });
		});
	});
});


//----------Redirect to external page---------------
app.get("/productCatalog/redirect/:productId",	function(req, res) {
	var productIdLocal = req.params.productId;
	res.redirect('http://localhost:8181/ClientApp/public/jsp/redirect.jsp?productId='+productIdLocal);
});

//----------Redirect to each category page---------------
app.get("/productCatalog/:category",	function(req, res) {
	mongoClient.connect("mongodb://127.0.0.1:27017/sampleProject", function(err, db){
		if(err) {
			throw err;
		}
		var categoryLocal = req.params.category;
		var collection = db.collection('products');
		collection.find({productCategory: categoryLocal}).toArray(function(err, results) {
			db.close();
			res.render('productCatalog/products', { products: results, categoryName: categoryLocal});
		});
	});
});


//----------Redirect to each product page-------------
app.get("/productCatalog/:category/:productId",	function(req, res) {
	mongoClient.connect("mongodb://127.0.0.1:27017/sampleProject", function(err, db){
		if(err) {
			throw err;
		}
		
		var categoryLocal = req.params.category;
		var productIdLocal = req.params.productId;
		var collection = db.collection('products');
		
		collection.find({productCategory: categoryLocal, productId: productIdLocal}).toArray(function(err, results) {
			db.close();
			res.render("productCatalog/product", {product : results[0]});
		});
	});
});

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
