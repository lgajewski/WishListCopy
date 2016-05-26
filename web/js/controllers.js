'use strict';

angular.module('wishlist.controllers', [])

    .controller('GreetingController', function ($scope, $state, GreetingService) {
        $scope.greeting = GreetingService.get();
    })
    .controller('LoginController', function ($scope, $state, $location, Restangular) {
        
        $scope.login = function(){
            // alert('username=' + $scope.credentials.username + '&password=' + $scope.credentials.password);

            Restangular.all('login').post('username=' + $scope.credentials.username
                + '&password=' + $scope.credentials.password).then(function(response){
                var resp = response;
                console.log(resp);
                $location.path("/gifts");

            }, function(resp){
                console.log(resp);
            });
            // Restangular.all('users').getList().then(function(response){
            //     $scope.users = response;
            //     console.log($scope.users);
            // })

        };
        $scope.logout = function(){
            // alert('username=' + $scope.credentials.username + '&password=' + $scope.credentials.password);

            Restangular.all('logout').post().then(function(response){
                var resp = response;
                console.log(resp);
            }, function(resp){
                console.log(resp);
            });
            $location.path('login');
            // Restangular.all('users').getList().then(function(response){
            //     $scope.users = response;
            //     console.log($scope.users);
            // })



        };

        $scope.usersM = function(){
            // alert('username=' + $scope.credentials.username + '&password=' + $scope.credentials.password);

            Restangular.all('users').getList().then(function(response){
                $scope.users = response;
                console.log($scope.users);
            }, function(resp){
                console.log(resp);
            })



        };


    })
    .controller('FriendController', function ($scope, $state, Restangular) {
        $scope.getFriends = function() {
            Restangular.all('friends').getList().then(function (resp) {
                $scope.friends = resp;
                for (var i = 0; i < $scope.friends.size; i++) {
                    Restangular.all('gifts').one($scope.friends[i].username).getList().then(function (response, i) {
                        $scope.friends[i].gifts = response;
                    })
                }
                console.log($scope.friends);
            });
        };
        $scope.getFriends();

        $scope.showDetail = function (item) {
            if ($scope.active != item.id) {
                $scope.active = item.id;
            }
            else {
                $scope.active = null;
            }
        };
        $scope.deleteFriend = function (friend) {
            Restangular.all('friends').one('delete', friend.username).remove().then(function () {
                $scope.getFriends();
            });
        };

        $scope.addFriend = function (friendId) {
            Restangular.all('friends').one('add').one(friendId).customPUT().then(function(){
                $scope.getFriends();
            }, function () {
                $scope.getFriends();
            });
        }

    })
    .controller('GiftController', function ($scope, $state, Restangular) {
        $scope.getGifts = function() {
            Restangular.all('gifts').getList().then(function (resp) {
                $scope.gifts = resp;
                console.log($scope.gifts);
            });
        };
        $scope.getGifts();

        $scope.deleteGift = function (gift) {
            Restangular.all('gifts').one('remove').one(gift.id).remove().then(function () {
                $scope.getGifts();
            });
        };

        $scope.addGift = function (gift) {
            Restangular.all('gifts').customPOST(gift, 'add', undefined, {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }).then(function () {
                $scope.getGifts();
            });
        }

});

