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

(def s-exp-visitor (LispVisitor.))
(def infix-visitor (InFixVisitor.))
(def eval-visitor  (EvaluatedVisitor.))
(def text-tree-visitor (TextTreeVisitor.))

(comment 

  (use-visitor (parse-list [:+ 1 2 3 4]) s-exp-visitor)
  (use-visitor (parse-list [:+ 1 2 3 4]) s-exp-visitor)
  (use-visitor (parse-list [:+ 1 2 [:+ 3 4]]) s-exp-visitor)

  (use-visitor (parse-list [:+ 1 2 [:+ 3 4 [:div 8 2] [:- 3 2]]]) s-exp-visitor)
  (use-visitor (parse-list '(:+ 11 (:* (:div 1 2) (:- (:+ 3 -5) -45)) -23)) text-tree-visitor)

  (use-visitor (parse-list '(:+ 11 (:* (:div 1 2) (:- (:+ 3 -5) -45)) -23)) eval-visitor)
  (double (+ 11 (* (/ 1 2) (- (+ 3 -5) -45)) -23))

  (use-visitor (parse-list '(:+ 2 (:* 4 5))) infix-visitor)

  )



(facts "about Lisp expression"
  (use-visitor (parse-list [:+ 1 2 3 4]) eval-visitor)   => "10.0"
  (use-visitor (parse-list [:+ 1 2 3 4]) s-exp-visitor)  => "(+ 1.0 2.0 3.0 4.0)"
  (use-visitor (parse-list [:+ 1 2 [:+ 3 4]]) s-exp-visitor) => "(+ 1.0 2.0 (+ 3.0 4.0))"
  (use-visitor (parse-list [:+ 1 2 [:+ 3 4 [:div 8 2] [:- 3 2]]]) s-exp-visitor) 
       => "(+ 1.0 2.0 (+ 3.0 4.0 (/ 8.0 2.0) (- 3.0 2.0)))"
  (use-visitor (parse-list '(:+ 11 (:* (:div 1 2) (:- (:+ 3 -5) -45)) -23)) text-tree-visitor)
       => 
"
[+]
 +---[11.0]
 +---[*]
 |    +---[/]
 |    |    +---[1.0]
 |    |    +---[2.0]
 |    +---[-]
 |         +---[+]
 |         |    +---[3.0]
 |         |    +---[-5.0]
 |         +---[-45.0]
 +---[-23.0]
"
  (use-visitor (parse-list '(:+ 11 (:* (:div 1 2) (:- (:+ 3 -5) -45)) -23)) eval-visitor) => "9.5"
  (use-visitor (parse-list '(:+ 2 (:* 4 5))) infix-visitor) => "(2.0 + (4.0 * 5.0))"

       )


   
