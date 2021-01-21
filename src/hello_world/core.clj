(ns hello-world.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [clojure.pprint :as pp]
            [ring.middleware.json :refer [wrap-json-response
                                          wrap-json-body]]
            [ring.util.response :refer [response]]
            ))

#_(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (let [addr (:remote-addr request)]
           (pp/pprint request)
           addr)
   #_(str "Hello World <p> hmm </p>")})
(defn handler [request]
  #_(print "[" (:remote-addr request) "]: ")
  (pp/pprint (-> request :body slurp clojure.edn/read-string))
  (response (str {:foo "bar" :wow {:it [\w \o \r \k]}})))

(def server (run-jetty
             #_(wrap-json-response handler)
             handler
             {:port 3001 :join? false}))
;;(.stop server)
