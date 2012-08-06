(ns railtime-http.views.routes
  (use noir.core)
  (:require [noir.response :as response]
            [railtime-http.api :as rt]
            [cheshire.core :as json]))
            
(def ^:const url-domain "http://metrarail.com/content/metra/en/home/jcr:content/trainTracker.lataexport.html")
(def ^:const url-tracker "http://12.205.200.243/AJAXTrainTracker.svc/GetAcquityTrainData")
        
(defpage [:get "/railtime"] []
    (json/generate-string 
      (rt/request-lines-stations url-domain)))
  
(defpage [:get "/railtime/:line"] {:keys [line]}
    (json/generate-string 
      ((keyword (.toUpperCase line)) (rt/request-lines-stations url-domain))))

  
(defpage [:get "/railtime/:line/:origin/:destination"] 
  {:keys [line origin destination]}
    (json/generate-string
      (rt/request-tracker-trains url-tracker 
        {:line line 
        :origin origin
        :destination destination})))