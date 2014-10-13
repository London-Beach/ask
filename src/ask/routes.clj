(ns ask.routes
  (:require [ask.handler :refer :all]
            [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ask.api :as api]))

(defroutes app-routes
           (GET "/" [request] (home-handler request))
           (POST "/" [request] (create-handler request))
           (GET "/api/audience" [:as request] (audience-handler request))
           (GET "/api/presenter" [:as request] (presenter-handler request))
           (GET "/feedback-board" [request] (feedback-board-handler request))
           (route/resources "/")
           (route/not-found "Not Found"))

(def app
  (handler/site app-routes))