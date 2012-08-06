(ns railtime-http.server
  (:require [noir.server :as server]))

(server/load-views-ns 'railtime-http.views)

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'railtime-http})))

;; curl -H "Content-Type: application/json" "http://localhost:8080/UP-N"