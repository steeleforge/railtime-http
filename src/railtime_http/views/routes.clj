(ns railtime-http.views.routes
  (use noir.core)
  (:require [noir.response :as response]
            [railtime-http.api :as rt]
            [cheshire.core :as json]))
        
(defpage [:get "/railtime"] []
    (json/generate-string 
      (rt/request-lines-stations rt/url-domain)))
  
(defpage [:get "/railtime/:line"] {:keys [line]}
    (json/generate-string 
      ((keyword (.toUpperCase line)) (rt/request-lines-stations rt/url-domain))))

  
(defpage [:get "/railtime/:line/:origin/:destination"] 
  {:keys [line origin destination]}
    (json/generate-string
      (into [] 
        (filter map? (map rt/sanitize-train 
          (vals (rt/request-tracker-trains rt/url-tracker 
            {:line line 
            :origin origin
            :destination destination})))))))