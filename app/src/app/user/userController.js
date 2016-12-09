/**
 * Created by Asus on 19/8/2559.
 */
(function () {
  'use strict'
  angular.module('app').controller('registerController',registerController)
    .controller('accountRequestController',accountRequestController);
  /**ngInject*/
  function registerController(userService,$location,$log,$timeout,$rootScope) {
    var vm = this;

    var password = document.getElementById("password")
      , confirm_password = document.getElementById("confirm-password");

    function validatePassword(){
      if(password.value != confirm_password.value) {
        confirm_password.setCustomValidity("Passwords Don't Match");
      } else {
        confirm_password.setCustomValidity('');
      }
    }

    vm.register = function (user) {
      $log.debug(user);
      userService.save(user, function () {
        vm.RegisterFailAlert= true;
        vm.RegisterMessage =" send register request, please wait for system admin.";
          $timeout(function () {
            $location.path('/login');
          }, 2000);
        })
    }

    vm.changePassword = function () {

      userService.get(function (user) {
        $rootScope.user = user;
        // $log.debug('user',user);
      });
      $log.debug($rootScope.user.username);
    }
  }

  function accountRequestController(queryAccountRequestService,userService,$route,approveUserService) {

    var vm = this;
    vm.newUser = {};
    queryAccountRequestService.query(function (data) {
      vm.newUsers = data;
    })


    vm.deleteNewUser = function (id) {
      var answer = confirm("Do you want to delete the newUsers?");
      if (answer) {
        userService.delete({id: id}, function () {
          $route.reload();
        })
      }
    }

    vm.approveNewUser = function (id) {

      // vm.newUser.id = id;
      // var updateUser = vm.newUsers.filter(function (user) {
      //   return user.id == id
      // }).pop();
      // updateUser.roles = '';

      // var i;
      // for(i=0;i<vm.newUsers.length;i++)
      // {
      //
      //   if(vm.newUsers[i].id == vm.newUser.id) {
      //     vm.newUser.id = vm.newUsers[i].id;
      //     vm.newUser.username = vm.newUsers[i].username;
      //     vm.newUser.name = vm.newUsers[i].name;
      //     vm.newUser.lastName = vm.newUsers[i].lastName;
      //     vm.newUser.email = vm.newUsers[i].email;
      //     vm.newUser.password = vm.newUsers[i].password;
      //     vm.newUser.dob = vm.newUsers[i].dob;
      //     vm.newUser.phoneNumber = vm.newUsers[i].phoneNumber;
      //     vm.newUser.roles = vm.newUsers[i].roles;
      //   }
      // }

      approveUserService.approve({id:id});
      console.log(vm.newUser);
      console.log(vm.newUser.id);
      $route.reload();
    }

  }

})();
