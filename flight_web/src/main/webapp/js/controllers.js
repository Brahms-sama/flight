var app = angular.module('flight', [ 'ngRoute' ]);

var base_url = "http://localhost:8080/flight_web/";

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "views/vols.html",
		controller : 'volsCtrl'
	}).when("/connexion/", {
		templateUrl : "views/connexion.html",
		controller : 'loginCtrl'
	}).when("/resa/:idVol", {
		templateUrl : "views/resa.html",
		controller : 'resaCtrl'
	}).when("/client/{id}", {
		templateUrl : "views/client.html",
		controller : 'clientCtrl'
	});
});

/*
 * 'INDEX' PAGE CONTROLLER
 */
app.controller("indexCtrl", function($scope, $http, $routeParams) {

	$scope.test = "Ca marche !!";
	$scope.appName = "FLIGHT";
	// $scope.status = AuthService.status;
	$scope.check = function(login) {

		var body = JSON.stringify({
			username : login.username,
			password : login.password
		})
		$http.post("http://localhost:8080/flight_web/mvc/rest/login/", body)
				.then(function(response) {
					$scope.client = response.data;
					$scope.connected = true;
				})
	}

});

/*
 * 'VOLS' PAGE CONTROLLER
 */
app.controller("volsCtrl", function($scope, $http, $routeParams) {

	$scope.test = "Ca marche !!";
	// $scope.status = AuthService.status;

	$http.get("http://localhost:8080/flight_web/mvc/rest/vols").then(
			function(response) {
				$scope.vols = response.data;
			});

});

/*
 * 'RESA' PAGE CONTROLLER
 */
app.controller("resaCtrl", function($scope, $http, $routeParams) {
	$scope.test = "Ca marche !!";
	$id = $routeParams["idVol"];

	$http.get("http://localhost:8080/flight_web/mvc/rest/resa/" + $id).then(
			function(response) {
				$scope.vol = response.data;
			});

});

/*
 * 'LOGIN' PAGE CONTROLLER
 */
app.controller("loginCtrl", function($scope, $http, $routeParams) {
	$scope.test = "Ca marche !!";

	$scope.check = function(login) {

		var body = JSON.stringify({
			username : login.username,
			password : login.password
		})
		$http.post("http://localhost:8080/flight_web/mvc/rest/login/", body)
				.then(function(response) {
					$scope.client = response.data;
					// AuthService.status = true;
				})
		// .catch(function (response) {
		// $scope.connected = false;
		// });
	}

});

/*
 * 'Client' PAGE CONTROLLER
 */
app.controller("clientCtrl", function($scope, $http, $routeParams) {
	$scope.test = "Ca marche !!";
	$id = $routeParams["id"];

	$http.get("http://localhost:8080/flight_web/mvc/rest/client/").then(
			function(response) {
				$scope.client = response.data;
			})

});