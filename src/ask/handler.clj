(ns ask.handler
  (:require [ask.templates :as templates]))

(defn home-handler [request]
  (templates/render-template "home"))

