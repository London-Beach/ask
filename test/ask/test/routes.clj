(ns ask.test.routes
  (:require [clojure.test :refer :all]
            [ask.routes :refer :all]
            [ring.mock.request :as mock]
            [ask.templates :as templates]))

(defn- string-contains? [haystack needle]
  (not (= (.indexOf haystack needle) -1)))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (string-contains? (:body response) "Start Your Live Feedback Session") true))))

  (testing "create route"
    (let [response (app (mock/request :post "/"))]
      (is (= (:status response) 302))
      (is (= (get (:headers response) "Location") "/"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
