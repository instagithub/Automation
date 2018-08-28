(function() {
        window.fireflyAPI = window.fireflyAPI || {};
        window.fireflyAPI._log = window.fireflyAPI._log || function(){};
        window.fireflyChatAPI = window.fireflyChatAPI || {};
        fireflyChatAPI.ready=function(x){if(typeof x=="function")x=[x];fireflyChatAPI.onLoaded=fireflyChatAPI.onLoaded||[];for(var i=0;i<x.length;i++){if(fireflyChatAPI.isLoaded){x[i]();}else{fireflyChatAPI.onLoaded.push(x[i]);}}};

        fireflyChatAPI.skipQueueSelection = true;

        fireflyChatAPI.type = "visitor";
        fireflyChatAPI.token = "0dca9538f69811e79413ff4077c66c33";
        fireflyChatAPI.serverHostUrl = "https://chatdev.usefirefly.com";
        fireflyChatAPI.assetHostUrl = "https://chatdev.usefirefly.com";
        fireflyChatAPI.publishSettingsToS3 = true;
        fireflyChatAPI.s3HostUrl = "https://pega-chat-dev.s3.amazonaws.com";

        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "https://chatdev.usefirefly.com/scripts/loaders/chatLoader.js";
        script.async = true;
        var firstScript = document.getElementsByTagName("script")[0];
        firstScript.parentNode.insertBefore(script, firstScript);
      })();