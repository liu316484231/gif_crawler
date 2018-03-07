var express = require('express');
var router = express.Router();
var connection = require("../db").connection;

/* GET home page. */
router.get('/', function(req, res, next) {
    res.render("index");
});

router.get('/tool', function(req, res, next) {
    res.render("tool");
});

router.get('/upload', function(req, res, next) {
    res.render("upload");
});

//CSRF（Cross-site request forgery）
router.get('/check', function(req, res, next) {
    res.render("checkCSRF");
});

router.get('/json', function(req, res, next){
    var json = {
        a : 1,
        b : "abc"
    };
    res.send(json);
    res.end();
});

router.post('/save', function (req, res, next) {
    var json = req.body;
    connection.query("insert into user(show_name, user_name) values(?,?)" , [json.showName, json.userName], function (err, results) {
        if(err){
            console.log(err);
            res.end("error");
            return;
        }
        res.end("success");
    });
});

router.get('/list', function (req, res, next) {
    connection.query("select * from user order by create_time desc" , function (err, results) {
        if(err){
            console.log(err);
            res.end("error");
            return;
        }
        res.send(results);
        res.end();
    });
});

module.exports = router;
