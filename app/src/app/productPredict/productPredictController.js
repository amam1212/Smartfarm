/**
 * Created by Asus on 19/7/2559.
 */
(function () {
  'use strict';

  angular
    .module('app')
    .controller('listProductPredictController', listProductPredictController);
  /** @ngInject */
  function listProductPredictController(productPredictService, $timeout,$route , productService, $log) {

    var vm = this;
    vm.productPreict = {};
    vm.newProductStock = {};
    vm.products = productService.query();
    vm.predict = null;
    vm.getStatistics = getStatistics;

    // productStockService.query(function (data) {
    //   vm.productStocks = data;
    //
    // })


    // productPredictService.query(function (data) {
    //   vm.productPredict = data;
    //
    // })


    function getStatistics() {
      var ProductName = vm.productPredict.product.name;
      var quantity = vm.productPredict.quantity;
     // $log.debug(ProductName, quantity)


        productPredictService
          .getP(ProductName,quantity)
          .then(function(response){
            $timeout(function(){
              vm.statistics = response;
              console.log(vm.statistics);
            },0);
          })
          .catch(function(err){
            $log.error(err);
          });



      // vm.getPrediction = function () {
      // //function getPrediction() {
      //    var ProductName = vm.productPredict.product.name;
      //    var quantity = vm.productPredict.quantity;
      //   productPredictService.getP(ProductName,quantity);
      //   console.log(ProductName,quantity);
      //
      //   productPredictService
      //     .getP(ProductName, quantity)
      //     .then(function(response){
      //       $timeout(function(){
      //         vm.predict = response;
      //       },0);
      //     })
      //     .catch(function(err){
      //       $log.error(err);
      //     });
      // }
    }
  }

})();
