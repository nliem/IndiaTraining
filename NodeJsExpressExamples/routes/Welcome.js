/**
 * http://usejsdoc.org/
 */

exports.index = function(req, res){
  res.send('Welcome.html', { title: 'Express' });
};