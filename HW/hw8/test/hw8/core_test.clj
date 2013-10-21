(ns hw8.core-test
  (:require [clojure.test :refer :all]
            [midje.sweet :refer :all]
            [hw8.core :refer :all])
  (:import [hw8 ArithmeticComponent ArithmeticVisitor LeafNumberComponent 
            MultiplyComponent DivideComponent SubtractComponent AdditionComponent
            LispVisitor TextTreeVisitor EvaluatedVisitor InFixVisitor]))

(def component->class 
  {:+ #(AdditionComponent.)
   :- #(SubtractComponent.)
   :* #(MultiplyComponent.)
   :div #(DivideComponent.)})


(defn parse-list [l]
  (if (number? l)
    (LeafNumberComponent. l)
    (let [component ((component->class (first l)))
          children (into-array ArithmeticComponent (map parse-list (rest l)))]
      (.addChild component children)
      component)))


(defn use-visitor [component visitor]
  (.acceptVisitor component visitor)
  (.toString visitor))



(facts "about `split`"
       true => true)
   
