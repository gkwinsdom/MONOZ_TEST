function MyController($scope, $timeout) {

    $scope.clock = new Date();

    setInterval(function() {
        $scope.$apply(function(){
            $scope.clock = new Date();
        });
    }, 1000);
}