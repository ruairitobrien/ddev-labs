var express = require("express");
var request = require("request");
var mustacheExpress = require("mustache-express");
var os = require("os");
var primes = require("./primes.js");

var app = express();
app.set("view engine", "html");
app.engine("html", mustacheExpress()); // register file extension
app.set("views", __dirname);

app.get("/", function(req, res) {
  res.status(200).send("Pets Demo Application");
});

app.get("/pet", function(req, res) {
  var hostname = os.hostname();
  getPet(function(url) {
    res.render("index", {
      url: url,
      hostname: hostname
    });
  });
});

var getPet = function(callback) {
  request.get("http://api:8080/api/pet", function(err, res, body) {
    let url = JSON.parse(body).url;
    callback(url);
  });
};

app.get("/isPrime/:number", function(req, res) {
  res.status(200).send(primes.isPrime(req.params.number) + "\n");
});

var server = app.listen(3000, "0.0.0.0", function() {
  console.log("Express server listening on 0.0.0.0:3000");
});

exports.stop = function() {
  server.close();
};
