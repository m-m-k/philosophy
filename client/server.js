const express = require('express');
const path = require('path');
const request = require('request');
const http = require('http');

const app = express();

app.use(express.static(path.join(__dirname, 'build')));

app.get('/', function (req, res) {
      res.sendFile(path.join(__dirname, 'build', 'index.html'));
      });

app.get('/v1/api/:page', function(req, res) {getJson(req.params.page, function(data) {res.json(data)})});


function getJson(page, callback) {
     request('http://app:8080/v1/api?page=' + page, function (error, response, body) {
        if (!error) {
            callback(JSON.parse(body));
       } else {
          console.log(error);
       }
    });
}

console.log("starting server on port 80");
http.createServer(app).listen(80);
