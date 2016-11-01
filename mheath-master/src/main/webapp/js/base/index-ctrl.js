/**
 * Created by heren on 2016/10/29.
 */

var indexCtrl = indexApp.controller("indexCtrl",['$scope','$http',function($scope,$http){

    $scope.menus=[] ;//菜单
    $scope.loginInfo={} ;//登陆信息

    $scope.menuData={} ;


    for(var i = 0 ;i<10;i++){
        var menu={}  ;
        menu.menuName = "测试菜单";
        menu.menuHref="http://www.baidu.com" ;
        menu.sort=i ;
        $scope.menus.push(menu) ;
        menu.children=[] ;
        menu.children.push(menu) ;
    }

    //加载菜单信息
    $http.get("/api/menu/list").success(function(data){
        $scope.menuData = data ;
    }) ;

}]) ;