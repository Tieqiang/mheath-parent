/**
 * Created by heren on 2016/10/29.
 */

var indexApp = angular.module("indexApp", []).factory('httpInterceptor', ['$q', '$injector', function ($q, $injector) {
    var httpInterceptor = {
        'responseError': function (response) {
            if(response.status=='500'){
                parent.layer.alert(response.data, {
                    skin: 'layui-layer-molv',
                    shift: 4
                })
            }
            return $q.reject(response);
        },
        'response': function (response) {
            console.log("response")
            return response;
        },
        'request': function (config) {
            console.log("config")
            return config;
        },
        'requestError': function (config) {
            console.log("requestError")
            return $q.reject(config);
        }
    }
    return httpInterceptor;
}]).config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push('httpInterceptor');
}])

