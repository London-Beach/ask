(ns ask.test.templates
  (:use midje.sweet)
  (:require [ask.templates :refer :all]))

(facts "templates"
  (fact "it renders the template name given"
        (render-template "template") => "Hello!"
        (provided
          (slurp anything) => "Hello!"))

  (fact "it inserts variables as needed"
        (render-template "template"
                         {:name "Rob"}) => "Rob!"
        (provided
          (slurp anything) => "{{name}}!"))

  (fact "it handles duplicates well"
        (render-template "template"
                         {:name "Rob"}) => "RobRob!"
        (provided
          (slurp anything) => "{{name}}{{name}}!")))