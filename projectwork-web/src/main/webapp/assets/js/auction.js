var app = angular.module('auctionAppp', []);


app.controller('auctionCtrl', function($rootScope,$scope, $http, $interval,$timeout) {
	
	
	$scope.loadUserProfile = function(){
		var response = $http.get('../rest/user/get');
		
		response.success(function(data, status, headers, config) {
			 $scope.userProfile = data;
		});
		
	};
	
	$scope.loadAuctions = function(){
		var response = $http.get('../rest/auction/list');
		
		response.success(function(data, status, headers, config) {
			$scope.auctions = data;
			
		});
		
	};
	
	$scope.loadAuction = function(oid){
		console.log('carico '+oid);
		var response = $http.get('../rest/auction/get/' + oid);
		
		response.success(function(data, status, headers, config) {
			console.log('carico su id'+oid,data);
			$scope.selectedAuction = data;
		});
		
		var response2 = $http.get('../rest/auction/activeChannels/' + oid);
		response2.success(function(data, status, headers, config) {
			
			var websocketChannelActive = false;
			var emailChannelActive = false;
			 
 			for (var i = 0; i < data.length; i++) {
 			     if(data[i].type == 'WEBSOCKET'){
					  websocketChannelActive = true;
				  } else if(data[i].type == 'EMAIL'){
					  emailChannelActive = true; 
				  }
 			}
			
			 $scope.websocketChannelActive = websocketChannelActive;
			 $scope.emailChannelActive = emailChannelActive;
		});	
		
	};
	
	$scope.addBid = function(bidPrice){
		
		var parameter = JSON.stringify({auctionOid:$scope.selectedAuction.oid, 
		auctionVersion:$scope.selectedAuction.version, price:bidPrice});
		
		var response = $http.post('../rest/auction/addBid/',parameter);
		
		response.success(function(data, status, headers, config) {
			$scope.displayMessage("offerta inserita correttamente");
			$scope.selectedAuction =  data;
		});
		
		 response.error(function(data, status, headers, config) {
	            $scope.displayMessage("Non e' stato possibile inserire l'offerta: " + data.messages,'error');
	        });
		
		
	} 
	
	$scope.registerChannel = function(channelType){
		
		var parameter = JSON.stringify({auctionOid:$scope.selectedAuction.oid, type:channelType});
		
		var response = $http.post('../rest/auction/registerChannel/',parameter);
		
		response.success(function(data, status, headers, config) {
			$scope.loadAuction($scope.selectedAuction.oid);
			$scope.displayMessage('Registrazione al canale ok');
		});
		
	} 
	
	$scope.deregisterChannel = function(channelType){
		
		var parameter = JSON.stringify({auctionOid:$scope.selectedAuction.oid, type:channelType});
		
		var response = $http.post('../rest/auction/deregisterChannel/',parameter);
		
		response.success(function(data, status, headers, config) {
			$scope.loadAuction($scope.selectedAuction.oid);
			$scope.displayMessage('Degistrazione al canale ok');
		});
		
	} 
	
	
	//initial load

	$scope.connectWS = function() {
        var wsURI = 'ws://localhost:8080/projectwork-web/websocket/auction';
        $scope.websocket = new WebSocket(wsURI);

        $scope.websocket.onopen = function() {
        	$scope.displayMessage('Connection is now open');
        };
        $scope.websocket.onmessage = function(event) {
            // log the event     
            var data = JSON.parse(event.data);
            //console.log(data);
            if($scope.selectedAuction.oid==data.auctionOid){
            	$scope.loadAuction(data.auctionOid);
            }
            $scope.displayMessage('New bid '+data.pricing+' for auction '+data.auctionOid);
            
        };
        $scope.websocket.onerror = function(event) {
            // log the event
            $scope.displayMessage('Error! ' + event.data, 'error','error');
        };
        $scope.websocket.onclose = function() {
        	$scope.displayMessage('The connection was closed','error');
        };
    }
	
	
	$scope.disconnectWS = function(){
		if ($scope.websocket !== null) {
            $scope.websocket.close();
            $scope.websocket = null;
        }
	}
	
	$scope.displayMessage = function(msg,type){
		$scope.classMessage = type==null?'info':type;
		$scope.message = msg;
		$timeout(function(){
			$scope.clearMessage();
		},2000);
	}
	
	$scope.clearMessage = function(){
		$scope.message = null;
		$scope.classMessage = null;
	}
	
	$scope.loadUserProfile();	
	$scope.loadAuctions();	
	$scope.connectWS();
	//refresh data every 5 seconds
	//$interval( function(){ $scope.loadUserProfile(); $scope.loadAuctions(); $scope.loadAuctions(selectedAuction.oid);}, 5000);
    
});