(ns ask.handler
  (:use [ring.util.response :only [redirect]]
        [ask.app :only [create-session]])
  (:require [ask.templates :as templates]))

(defn home-handler [request]
  (templates/render-with-header-and-footer "home"))

(defn create-handler [request]
  (redirect (str "/" (create-session))))

(defn feedback-board-handler [request]
      (templates/render-with-header-and-footer "feedback-board"))
