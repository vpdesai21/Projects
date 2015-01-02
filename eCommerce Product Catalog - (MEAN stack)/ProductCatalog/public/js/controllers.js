function ProductCatalog($scope, $http) {
  $http.get('/api/productCatalog').
    success(function(data, status, headers, config) {
      $scope.products = data.products;
    });
}

function CategoryProducts($scope, $http, $routeParams) {
	$http.get('/api/productCatalog/' + $routeParams.category).
	success(function(data, status, headers, config) {
		$scope.products = data.products;
	});
}

function Product($scope, $http, $routeParams) {
	$http.get('/api/productCatalog/' + $routeParams.category + "/" + $routeParams.productId).
	success(function(data, status, headers, config) {
		$scope.product = data.product;
	});
}
