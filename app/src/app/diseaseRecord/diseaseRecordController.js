/**
 * Created by Asus on 19/7/2559.
 */
(function () {
  'use strict';

  angular
    .module('app')
    .controller('listDiseaseRecordController', listDiseaseRecordController);
  /** @ngInject */
  function listDiseaseRecordController(diseaseRecordService,$route , productService) {

    var vm = this;
    vm.diseaseRecord = {};
    vm.newDiseaseRecord = {};
    vm.products = productService.query();

    diseaseRecordService.query(function (data) {
      vm.diseaseRecords = data;

      })

    vm.deleteDiseaseRecord = function (id) {
        var answer = confirm("Do you want to delete the diseaseRecord?");
        if (answer) {
          diseaseRecordService.delete({id: id}, function () {
            $route.reload();
          })
        }
      }
    vm.updateDiseaseRecord = function (id) {
      vm.diseaseRecord.id = id;
      diseaseRecordService.update({id:id},vm.diseaseRecord);
        $route.reload();
      }
    vm.addDiseaseRecord = function () {
      diseaseRecordService.save(vm.newDiseaseRecord);
        $route.reload();
      }
    }


})();
