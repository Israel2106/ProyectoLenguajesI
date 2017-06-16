
var app = angular.module("app",[]);
             
             app.controller('control', function ($scope, $http) {
               $http.get("json/productos.json").success(function(producto){
               $scope.productos = producto;
              
        });
    });
    
var miapp = angular.module("miapp",[]);
    miapp.controller('control2', function($scope, $http){
    $http.get("json/productos.json").success(function(producto){
               $scope.productos = producto;
               alert(producto);
           });
           $scope.toggleActive = function(s){
		s.active = !s.active;
            };
            $scope.total = function(){

		var total = 0;
		angular.forEach($scope.productos, function(s){
			if (s.active){
				total += s.precio;
                                
			}
		});

		return total;
	};
            
            
            
          });  





