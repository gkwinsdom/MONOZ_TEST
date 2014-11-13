{
    {
        var homeModule = angular.module('HomeModule', []);

        homeModule.filter('titleCase', function() {
            var titleCaseFilter = function(input) {
                var words = input.split(' ');
                for (var i = 0; i < words.length; i++) {
                    words[i] = words[i].charAt(0).toUpperCase() + words[i].slice(1);
                }
                return words.join(' ');
            };
            return titleCaseFilter;
        });

        function HomeController($scope) {
            $scope.pageHeading = 'behold the majesty of your page title';
        }
    }

    {
        var test001Module = angular.module('Test001Module',[]);

        test001Module.filter('titleCase', function() {
            var titleCaseFilter = function(input) {
                var words = input.split(' ');
                for (var i = 0; i < words.length; i++) {
                    words[i] = words[i].charAt(0).toUpperCase() + words[i].slice(1);
                }
                return words.join(' ');
            };
            return titleCaseFilter;
        });

        function Test001Controller($scope) {
            $scope.test001Title = 'behold the majesty of your page title';
        }
    }

}