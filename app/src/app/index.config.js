(function() {
  'use strict';

  angular
    .module('app')
    .config(config);

  /** @ngInject */
  function config($logProvider, toastrConfig, $httpProvider) {
    // Enable log
    $logProvider.debugEnabled(true);

    // Set options third-party lib
    toastrConfig.allowHtml = true;
    toastrConfig.timeOut = 3000;
    toastrConfig.positionClass = 'toast-top-right';
    toastrConfig.preventDuplicates = true;
    toastrConfig.progressBar = true;

    var exampleAppConfig = {
      /* When set to false a query parameter is used to pass on the auth token.
       * This might be desirable if headers don't work correctly in some
       * environments and is still secure when using https. */
      useAuthTokenHeader: true
    };

    $httpProvider.interceptors.push(function ($q,$rootScope){
      return {
        'request' : function(config){
          if (angular.isDefined($rootScope.authToken)){
            var authToken = $rootScope.authToken;
            if (exampleAppConfig.useAuthTokenHeader){
              config.headers['X-Auth-Token'] = authToken;
            }else{
              config.url = config.url + "?token=" + authToken;
            }
          }
          return config || $q.when(config);
        }

      }
    })
  }

})();
