/* global malarkey:false, moment:false */
(function() {
  'use strict';

  angular
    .module('app')
    .constant('malarkey', malarkey)
    .constant('moment', moment)
    .constant('backendUrl', 'http://localhost:8080')
    .constant('backendWsUrl', 'ws://localhost:8080');

})();
