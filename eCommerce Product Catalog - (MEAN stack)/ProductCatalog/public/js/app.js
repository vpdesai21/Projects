angular.module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives']).
  config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
    $routeProvider.
      when('/productCatalog', {
          templateUrl: 'productCatalog/products',
          controller: ProductCatalog
       }).
       when('/productCatalog/:category', {
            templateUrl: 'productCatalog/products',
            controller: CategoryProducts
       }).
       when('/productCatalog/:category/:productId', {
           templateUrl: 'productCatalog/product',
           controller: Product
      }).
       otherwise({
           redirectTo: '/productCatalog'
         });
    	$locationProvider.html5Mode(true);
  }]);