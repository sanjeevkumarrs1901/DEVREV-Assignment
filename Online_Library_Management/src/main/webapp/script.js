var newapp = angular.module("myApp", []);
newapp.controller("UserController", [ '$scope', '$http', function($scope, $http) {
 
    $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
    $scope.sendData = function() {
	   var p;
	   if(($scope.type1==true && $scope.type2==true))
	   {
		   alert("Please select ADMIN or Student, You Have Selected Both");
		   window.location="Login.html";
	   }
	    else if($scope.type1==true)
	    {
		   p='S';
	    }
	    else if($scope.type2==true)
	    {
		   p='A';
	    }
	    else
	    {
		    alert("Please select ADMIN or Student");
		    window.location="Login.html";
	    }
        $http({
            url : 'LoginCheck',
            method : "POST",
            data : {
	            'type': p,
                'username' : $scope.Lemail ,
                'password' : $scope.Lpassword,
                
            }
        }).then(function(response) {
           if(response.data=="false")
            {
	            alert("Email or Password is incorrect");
	            window.location="Login.html";
            }
            else if(response.data="true" && p=='A')
            {
	            alert("Logged In");
	            window.location="admin.html";
            }
            else if(response.data="true" && p=='S')
            {
	            alert("Logged In");
	            window.location="books.html";
            }
        }, function(response) {
            console.log("Failure -> " + response.data);
        });
    };
    var ctr=0;
    $scope.click=function()
    {
	     $http({
		      url:'BooksController',
		      method:'POST',
		      data:{
			     'count':ctr
		     }
	     }).then(function(response)
	     {
		      $scope.book=response.data;
		      ctr=ctr+10;
	     },function(response){
		       console.log("failure");
	     });
    };
    console.log(ctr);
    $scope.clk=function()
    {
	     ctr=ctr-10;
	     $http({
		      url:'BooksController',
		      method:'POST',
		      data:{
			     'count':ctr
		     }
	     }).then(function(response)
	     {
		      $scope.book=response.data;
		      console.log($scope.book);
	     },function(response){
		       console.log("failure");
	     });
    };
    $scope.add=function()
	{
		console.log($scope.type);
		if($scope.type==false)
	    {
		   alert("Please Confirm to Add Books");
	    }
	    else
	    {
		$http({
		      url:'AddBooks',
		      method:'POST',
		      data:{
			     'title':$scope.Ltitle,
			     'author':$scope.Lauthor,
			     'subject':$scope.Lsubject,
			     'date':$scope.Ldate,
		    }
	     }).then(function(response)
	     {
		    if(response.data=="true")
		    {
		      alert("Successfully Added Book"); 
		      window.location="admin.html"; 
		    }
	     },function(response){
		       console.log("failure");
	     });
	   }
	};
}]);