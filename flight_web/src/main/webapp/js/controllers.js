var app = angular.module('flight', []);
var base_url = "http://localhost:8080/flight_web/"; 


/*
 *'INDEX' PAGE CONTROLLER
 * */
app.controller("indexCtrl", function($scope, $http) {
	$scope.test = "Ca marche !!";
	$scope.id = 0;
	$scope.ws = "/mvc/rest/vols/all";

	$http.get("http://localhost:8080/flight_web/mvc/rest/vols/all").
    then(function(response) {
        $scope.vols = response.data;
    });
	
});


/*
 *'RESA' PAGE CONTROLLER
 * */
app.controller("resaCtrl", function($scope, $http) {
	$scope.test = "Ca marche !!";
	$scope.id = 0;
	$scope.ws = "/mvc/rest/vols/all";

	$http.get("http://localhost:8080/flight_web/mvc/rest/vols/all").
    then(function(response) {
        $scope.vols = response.data;
    });
	
});
