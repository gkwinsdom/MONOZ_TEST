{
	function TodoListController($scope, $location){
		$scope.todoTitle="请输入数字"
		
		$scope.createTodo =  function(){
		    $.ajax("localhost:8080/multi-web-web/todo/create", {
		        type : "POST",
		        data : $scope.todoTitle,
		        dataType : "json", // (14)

		    }).done(function(datas) {
		    	$scope。todo_list = datas;
		    }).fail(function(xhr) {
		    	alert("错误");
		    });
		}
	}
}