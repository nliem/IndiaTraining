/**
 * http://usejsdoc.org/
 */

module.exports = {
		
		retrieveReviews : function(req, res){
			//make this dynamic!
			res.writeHead(200,{'Conent-Type':'application/json'});
			res.write(JSON.stringify({hotel:"Citrus", rating:"5"}));
			res.write(JSON.stringify({hotel:"Savoy Suites", rating:"4"}));
			res.end();
		},
		
		getReviews : function(){
			return {hotel:"Citrus", rating:"5"};
			//return JSON.stringify({hotel:"Citrus", rating:"5"});
		},

		putReview : function(req, res){
			//add a review
		}
		
};