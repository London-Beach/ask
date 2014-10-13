(ns ask.handler
  (:use [ring.util.response :only [redirect]])
  (:require [ask.app :refer :all]
            [ask.api :as api]
            [ask.templates :as templates]
            [org.httpkit.server :as ws]))

(defn home-handler [request]
  (templates/render-with-header-and-footer "home"))

(defn create-handler [request]
  (redirect (str "/" (create-session))))

(defn feedback-board-handler [request]
  (templates/render-with-header-and-footer "feedback-board"))

(defn audience-handler [request]
  (ws/with-channel request
                   channel
                   (ws/on-receive channel api/notify-all-channels)))

(defn presenter-handler [request]
  (ws/with-channel request
                   channel
                   (api/add-new-channel channel)))