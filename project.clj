(defproject railtime-http "0.1.0-SNAPSHOT"
            :description "Railtime HTTP - Sane & RESTy"
            :url "http://steeleforge.com/railtime"
            :license {:name "Eclipse Public License"
              :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.4.0"]
                           [noir "1.2.1"]
                           [clj-http "0.4.3"]
                           [cheshire "4.0.0"]
                           [org.clojure/tools.cli "0.2.1"]
                           [clj-time "0.4.3"]]
            :main railtime-http.server)

