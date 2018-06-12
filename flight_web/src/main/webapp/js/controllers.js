var app = angular.module('flight', ['ngRoute']);
var base_url = "http://localhost:8080/flight_web/";

app.config(function ($routeProvider) {
	'use strict';
    $routeProvider
        .when("/", {
            templateUrl: "views/vols.html",
            controller : 'indexCtrl'
        })
        .when("/#/test/", {
            templateUrl: "views/vols.html",
            controller : 'indexCtrl'
        })
        .when("/resa/:idVol", {
            templateUrl: "mvc/views/resa.html",
            controller : 'indexCtrl'
        })
        .when("/clients", {
            templateUrl: "views/clients.jsp",
            controller : 'resaCtrl'
        });
});

/*
 *'INDEX' PAGE CONTROLLER
 * */
app.controller("indexCtrl", function ($scope, $http, $routeParams) {
    $scope.test = "Ca marche !!";
    $scope.id = 0;

    $http.get("http://localhost:8080/flight_web/mvc/rest/vols").
    then(function (response) {
        $scope.vols = response.data;
    });
    
    $scope.example = function () {
    	$scope.popo =  $scope.popo.toUpperCase();
    }
});


/*
 *'RESA' PAGE CONTROLLER
 * */
app.controller("resaCtrl", function ($scope, $http, $routeParams) {
    $scope.test = "Ca marche !!";
    $id = $routeParams["idVol"];

    $http.get("http://localhost:8080/flight_web/mvc/rest/resa/"+$id).
    then(function (response) {
        $scope.vols = response.data;
    });

});
