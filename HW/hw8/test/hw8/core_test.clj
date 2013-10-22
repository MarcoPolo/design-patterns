(ns hw8.core-test
  (:require [clojure.test :refer :all]
            [midje.sweet :refer :all]
            [hw8.core :refer :all])
  (:import [hw8 ArithmeticComponent ArithmeticVisitor LeafNumberComponent 
            MultiplyComponent DivideComponent SubtractComponent AdditionComponent
            LispVisitor TextTreeVisitor EvaluatedVisitor InFixVisitor]))

(def component->class 
  {`+ #(AdditionComponent.)
   `- #(SubtractComponent.)
   `* #(MultiplyComponent.)
   `/ #(DivideComponent.)})

(defn parse-list [l]
  (if (number? l)
    (LeafNumberComponent. l)
    (let [component ((component->class (first l)))
          children (into-array ArithmeticComponent (map parse-list (rest l)))]
      (.addChild component children)
      component)))

(defn use-visitor [visitor component]
  (.acceptVisitor component visitor)
  (.toString visitor))

(def s-exp-visitor (LispVisitor.))
(def infix-visitor (InFixVisitor.))
(def eval-visitor  (EvaluatedVisitor.))
(def text-tree-visitor (TextTreeVisitor.))

(parse-list `(+ 1 2 3))


;; Begin tests!


(facts "about Lisp expression"
  (use-visitor eval-visitor (parse-list `(+ 1 2 3 4)))   => "10.0"
  (use-visitor s-exp-visitor (parse-list `(+ 1 2 3 4)))  => "(+ 1.0 2.0 3.0 4.0)"
  (use-visitor s-exp-visitor (parse-list `(+ 1 2 (+ 3 4)))) => "(+ 1.0 2.0 (+ 3.0 4.0))"
  (use-visitor s-exp-visitor (parse-list `(+ 1 2 (+ 3 4 [/ 8 2] [- 3 2])))) 
       => "(+ 1.0 2.0 (+ 3.0 4.0 (/ 8.0 2.0) (- 3.0 2.0)))")

(facts "about Text Trees"
  (use-visitor text-tree-visitor (parse-list `(+ 11 (* (/ 1 2) (- (+ 3 -5) -45)) -23)))
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
")



(facts "about Eval Visitor"
  (let [eval-visitor (partial use-visitor eval-visitor)]
    (eval-visitor (parse-list `(+ 11 (* (/ 1 2) (- (+ 3 -5) -45)) -23))) => "9.5"
    (eval-visitor (parse-list `(+ 5 (- 4 2 (- (+ 3 -5) -45)) -23))) => (str (double (+ 5 (- 4 2 (- (+ 3 -5) -45)) -23)))
    ;; Might as well test a bunch of stuff!
    (doseq [x (range 5 10) y (range 2 10) z (range 1 5)
            :let [test-list `(+ ~x  ~y (- ~x (- ~z (* ~y ~x))) (/ ~z 2)) ]]
        (Double. (eval-visitor (parse-list test-list))) => (double (eval test-list)))))

(facts "about Infix Visitor"
  (use-visitor infix-visitor (parse-list `(+ 2 (* 4 5)))) => "(2.0 + (4.0 * 5.0))"
  (use-visitor infix-visitor (parse-list `(- 2 (* (/ 4 5) (+ 7 8))))) => "(2.0 - ((4.0 / 5.0) * (7.0 + 8.0)))"
  (use-visitor infix-visitor (parse-list `(/ 1 (/ 5 (+ 7 8))))) => "(1.0 / (5.0 / (7.0 + 8.0)))"
       )


   
