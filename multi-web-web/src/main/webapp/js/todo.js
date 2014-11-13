{

    $(document).ready(function(){
        alert("第一种方法。");
    });

	function TodoListController($scope,$http,$location){
		
//		$scope.todoList=[{"todoId":"14","todoTitle":"23","finished":true,"createdAt":1415609639011},{"todoId":"3acc963c-897b-48e9-ac3a-5ba78f334bb9","todoTitle":"123123","finished":false,"createdAt":1415609099774},{"todoId":"587ff197-04cd-486b-a4bf-148f63121059","todoTitle":"123123","finished":false,"createdAt":1415609250047},{"todoId":"d2c00bad-9828-43bc-85ca-cfa483d9c927","todoTitle":"123123","finished":false,"createdAt":1415609058472},{"todoId":"993cae9e-940b-4f7e-be90-7a2e4e0d4a1e","todoTitle":"123123","finished":false,"createdAt":1415609538661}];
        $scope.todoList={};
        $scope.todoTitle = "input";
        
        $(function(){
        	 $http({  method: 'GET',  url: 'http://localhost:8080/multi-web-web/todos'}).
             success(function(data, status, headers, config) {
                 $scope.todoList = data;
 	        }).error(function(data, status, headers, config) {
 	            alert("error");
 	        });
        });

		$scope.createTodo =  function() {
			
            $http({  method: 'POST',  url: 'http://localhost:8080/multi-web-web/todos?todoTitle=' + $scope.todoTitle}).
            success(function(data, status, headers, config) {
                $scope.todoList = data;
	        }).error(function(data, status, headers, config) {
	            alert("error");
	        });
        }

        $scope.todoFinish = function (todoId) {
            $http({  method: 'PUT',  url: 'http://localhost:8080/multi-web-web/todos/' + todoId}).
            success(function(data, status, headers, config) {
                $scope.todoList = data;
	        }).error(function(data, status, headers, config) {
	            alert("error");
	        });
        }

        $scope.todoDelete = function (todoId, index) {
            $http({  method: 'DELETE',  url: 'http://localhost:8080/multi-web-web/todos/' + todoId}).
            success(function(data, status, headers, config) {
            	$scope.todoList.splice(index, 1);
	        }).error(function(data, status, headers, config) {
	            alert("error");
	        });
            
        }
        
	}
	
}