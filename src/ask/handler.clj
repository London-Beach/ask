(ns ask.handler
  (:use [ring.util.response :only [redirect]])
  (:require [ask.templates :as templates]))

(defn home-handler [request]
  (templates/render-template "home"))

(defn create-handler [request]
  (println "Creating session...")
  (redirect "/"))