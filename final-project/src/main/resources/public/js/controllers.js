angular.module('app.controllers', []).controller('UserListController', function($scope, $state, popupService, $window, User) {
  $scope.users = User.query();

  $scope.deleteUser = function(user) {
    if (popupService.showPopup('Really delete this?')) {
      user.$delete(function() {
        $scope.users = User.query(); 
        $state.go('users');
      });
    }
  };
}).controller('WelcomeController', function($scope, $http, $state, $stateParams){
  $scope.wPath = {"name":""};
  $http.get('/welcome?name='+ $scope.wPath.name).
        then(function(response) {
            $scope.welcome = response.data;
        });
  $scope.getName = function(path) {
        $scope.wPath.name = path.name;
        $state.go('users');
      };

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
