(ns ask.test.routes
  (:use midje.sweet)
  (:require [ask.routes :refer :all]
            [ask.app :as app]
            [ring.mock.request :as mock]))

(facts "routes"
  (fact "it shows the home page"
        (-> (mock/request :get "/")
            app
            :status) => 200)
        (-> (mock/request :get "/")
            app
            :body) => (contains "Start Your Live Feedback Session")

  (fact "it shows not found when the page does not exist"
        (-> (mock/request :get "/invalid")
            app
            :status) => 404)

  (fact "it redirects to a newly created session when user clicks start session"
        (-> (mock/request :post "/")
            app
            :headers
            (get "Location")) => "/notrandom"
        (provided
             (app/create-session) => "notrandom")))