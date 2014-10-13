(ns ask.test.templates
  (:use midje.sweet)
  (:require [ask.templates :refer :all]))

(facts "templates"
  (fact "it renders the template name given"
        (render-template "my-template") => "Hello!"
        (provided
          (#'ask.templates/read-template-file anything) => "Hello!"))

  (fact "it inserts variables as needed"
        (render-template "my-template"
                         {:name "Rob"}) => "Rob!"
        (provided
          (#'ask.templates/read-template-file anything) => "{{name}}!"))

  (fact "it handles duplicates well"
        (render-template "my-template"
                         {:name "Rob"}) => "RobRob!"
        (provided
          (#'ask.templates/read-template-file anything) => "{{name}}{{name}}!"))

  (fact "it can handle nested templates"
        (render-template "my-template"
                         {:name "Rob"}
                         [:header]) => "<h1>Rob!</h1>"
        (provided
          (#'ask.templates/read-template-file "header") => "<h1>{{name}}!</h1>"
          (#'ask.templates/read-template-file "my-template") => "{{> header}}")))
