angular.module('app.controllers', [])
.controller('UserListController', function($scope, $state, popupService, $window, User) {
  $scope.users = User.query();

  $scope.deleteUser = function(user) {
    if (popupService.showPopup('Really delete this?')) {
      user.$delete(function() {
        $scope.users = User.query(); 
        $state.go('users');
      });
    }
  };
}).controller('WelcomeController', function($scope, $rootScope, $http, $state){ 
	if(angular.isUndefined($rootScope.userName)){
		$scope.path = "";
	}else{
		$scope.path = "?name=" + $rootScope.userName;
	}
	$http.get('/welcome' + $scope.path).
	then(function(response) {
		$scope.welcome = response.data;
	});
  
	$scope.setName = function(){
		$rootScope.userName = $scope.name;
		$state.go('users');
	}
}).controller('UserViewController', function($scope, $stateParams, User) {
  $scope.user = User.get({ id: $stateParams.id });
}).controller('UserCreateController', function($scope, $state, $stateParams, User) {
  $scope.user = new User();

  $scope.addUser = function() {
    $scope.user.$save(function() {
      $state.go('users');
    });
  };
}).controller('UserEditController', function($scope, $state, $stateParams, User) {
  $scope.updateUser = function() {
    $scope.user.$update(function() {
      $state.go('users');
    });
  };

  $scope.loadUser = function() {
    $scope.user = User.get({ id: $stateParams.id });
  };

  $scope.loadUser();
});
