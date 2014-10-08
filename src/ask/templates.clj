(ns ask.templates
  (:require [clostache.parser :as clostache]
            [clojure.java.io :as io]))

(defn- read-template-file [template-name]
  (slurp (io/resource
           (str "templates/" template-name ".tash.html"))))

(defn- read-partial-templates [templates]
  (reduce (fn [read-templates current-template]
            (assoc read-templates current-template
                                  (read-template-file (name current-template))))
          {}
          templates))

(defn render-template
  ([template-name]
   (render-template template-name {} {}))
  ([template-name parameters]
   (render-template template-name parameters {}))
  ([template-name parameters partials]
   (clostache/render (read-template-file template-name)
                     parameters
                     (read-partial-templates partials))))

(defn render-with-header-and-footer
  ([template-name] (render-with-header-and-footer template-name {}))
  ([template-name parameters] (render-template template-name
                                               parameters
                                               [:header :footer])))