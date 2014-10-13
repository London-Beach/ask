(ns ask.api
  (:require [org.httpkit.server :as ws]))

(def channels (ref []))

(defn- send-message [channel message]
  (ws/send! channel message))

(defn add-new-channel [channel]
  (dosync
    (alter channels conj channel)))

(defn notify-all-channels [message]
  (doseq [channel @channels] (send-message channel message)))
