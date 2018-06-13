var app = angular.module('flight', [ 'ngRoute' ]);

var base_url = "http://localhost:8080/flight_web/";

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "views/vols.html",
		controller : 'volsCtrl'
	}).when("/resa/:idClient/:idVol", {
		templateUrl : "views/resa.html",
		controller : 'resaCtrl'
	}).when("/client/:id", {
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
	$idVol = $routeParams["idVol"];
	$idClient = $routeParams["idClient"];

	$http.get("http://localhost:8080/flight_web/mvc/rest/vol/" + $idVol).then(
			function(response) {
				$scope.vol = response.data;
			});
	
	$http.get("http://localhost:8080/flight_web/mvc/rest/client/" + $idClient).then(
			function(response) {
				$scope.client = response.data;
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

	$http.get("http://localhost:8080/flight_web/mvc/rest/client/"+$id).then(
			function(response) {
				$scope.client = response.data;
			})
			
	$scope.edit = function (client) {
		var body = JSON.stringify({
			id : client.id,
			nom : client.nom,
			prenom : client.prenom,
			email : client.email,
			telephone : client.telephone,
			login : { username : client.login.username,
						password : client.login.password}
		})
		$http.put("http://localhost:8080/flight_web/mvc/rest/client/", body).then(
				function(response) {
					$scope.client = response.data;
				})
	}

});