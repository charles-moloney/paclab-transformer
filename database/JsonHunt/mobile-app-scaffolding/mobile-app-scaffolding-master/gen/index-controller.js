// Generated by CoffeeScript 1.9.0
(function() {
  var ctr;

  ctr = module.exports = function($scope, $location, $ocModal, $http, $modal) {

    /*
    	## sourceURL=hello.js
     */
    return $scope.goto = function(path) {
      $scope.path = path;
      return $location.path(path);
    };
  };

  ctr.$inject = ['$scope', '$location', '$ocModal', '$http', '$modal'];

}).call(this);