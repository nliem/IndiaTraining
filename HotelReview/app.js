
/**
 * Module dependencies.
 */

var MongoClient = require('mongodb').MongoClient;

var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , http = require('http')
  , path = require('path')
  , reviews = require('./routes/ReviewMaster');

var app = express();

// all environments
app.set('port', process.env.PORT || 3000);
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));

var url = 'mongodb://localhost:27017/test';

var connection;

MongoClient.connect(url, function(err, db){
	connection = db;
	console.log("Connected correctly to server " + connection);
});

// development only
if ('development' === app.get('env')) {
  app.use(express.errorHandler());
}

app.get('/', routes.index);
app.get('/users', user.list);

app.get('/submitReview', function(req, res){
	res.sendfile('./views/SubmitReview.html');
});

app.get('/hotelReviews', function(req, res){
	
	connection.collection('reviews').find().toArray(function(err, result){
	console.log(result);
	res.render('ShowReviews.ejs', {list:result});
	});
	
});

app.post('/addReview', function(req, res){
	console.log("Inside addReview function");
	connection.collection('reviews').insertOne(req.body);
	res.sendfile('./views/Success.html');
});

//connection.colleciton('reviews').addone(req.body);

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
