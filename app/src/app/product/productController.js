(function () {
  'use strict';

  angular
    .module('app')
    .controller('listProductController', listProductController);


  /** @ngInject */
  function listProductController(productService,$route) {
    var vm = this;
    vm.product = {};
    vm.newProduct = {};
    productService.query(function (data) {
      vm.products = data;
    })


    vm.deleteProduct = function (id) {
      var answer = confirm("Do you want to delete the product?");
      if (answer) {
        productService.delete({id: id}, function () {
          $route.reload();
        })
      }
    }
    vm.updateProduct = function (id) {
      vm.product.id = id;
      productService.update({id:id},vm.product);
      console.log(vm.product.id);
      console.log(vm.product);
      $route.reload();
    }
    vm.addProduct = function () {
      // if(vm.newProduct.name!=vm.products.name) {
       var i;
      var check = true;


        for(i=0;i<vm.products.length;i++)
       {
       console.log(vm.products[i].name);
         if(vm.products[i].name == vm.newProduct.name) {
          check = false;
         }
       }

       if(check==true) {
        if (vm.newProduct.name != null && vm.newProduct.unit != null) {
          productService.save(vm.newProduct);
        }
        else {
          alert("Incorrect Format");
        }
      }
      else {
        alert("Product exist..");
      }
      $route.reload();
    }
  }
})();
/**
 * Created by Asus on 19/7/2559.
 */
