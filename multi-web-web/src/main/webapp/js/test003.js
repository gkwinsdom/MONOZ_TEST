{
    var test003Module = angular.module("Test003Module",[]);

    test003Module.config(test003Config);

    function test003Config($routeProvider){
        $routeProvider.when('/', {
            controller:TestsController, templateUrl: '../page/test003_01.html'
        }).when('/detail/:id',{
            controller:TestController, templateUrl: '../page/test003_02.html'
        }).otherwise({
            redirectTo: '/'
        });
    }

    var testsData = [{id:0, name:'郭凯',age:25, address: '陪封小区'},{id:1, name:'winsdom',age:25, address: '陪封小区'}];

    function TestsController($scope){
        $scope.tests = testsData;
    }

    function TestController($scope, $routeParams){
        $scope.test = testsData[$routeParams.id];
    }

}

