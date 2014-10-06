(ns ask.routes
  (:use [ask.handler :only [home-handler create-handler]])
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
           (GET "/" [request] (home-handler request))
           (POST "/" [request] (create-handler request))
           (route/resources "/")
           (route/not-found "Not Found"))

(def app
  (handler/site app-routes))