/**
 * Created by Asus on 19/7/2559.
 */
(function() {
  'use strict'
  angular
    .module('app')
    .factory('productPredictService', productPredictService);

  function productPredictService($http, $q, $log, backendUrl) {
    return {
      getP: function (productName, quantity) {
        var path = backendUrl + '/getPrediction/' + productName + '/' + quantity;
        var deferred = $q.defer();
        $http
          .get(path)
          .then(function (response) {
            return deferred.resolve(response.data);
          })
          .catch(function (err) {
            return deferred.reject(err);
          });
        return deferred.promise;
      }
    }
  }
})();
