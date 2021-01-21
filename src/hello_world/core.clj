(ns hello-world.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [clojure.pprint :as pp]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (let [addr (:remote-addr request)]
           (pp/pprint request)
           addr)
   #_(str "Hello World <p> hmm </p>")})

(def server (run-jetty handler {:port 3001 :join? false}))
;(.stop server)
