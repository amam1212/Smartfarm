/**
 * Created by Asus on 19/7/2559.
 */
(function() {
  'use strict'
  angular
    .module('app')
    .factory('diseaseRecordService',diseaseRecordService);

  /** @ngInject */
  function diseaseRecordService($resource){
    return $resource('/diseaseRecord/:id', { id: '@_id' }, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }});

  }
})();
