(ns ask.handler
  (:use [ring.util.response :only [redirect]]
        [ask.app :only [create-session]])
  (:require [ask.templates :as templates]))

(defn home-handler [request]
  (templates/render-template "home"))

(defn create-handler [request]
  (redirect (str "/" (create-session))))