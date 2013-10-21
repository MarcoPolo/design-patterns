(ns hw8.core
  (:import [hw8 ArithmeticComponent ArithmeticVisitor LeafNumberComponent 
            MultiplyComponent DivideComponent SubtractComponent AdditionComponent
            LispVisitor TextTreeVisitor EvaluatedVisitor InFixVisitor]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(comment 

  (def component->class 
    {:+ #(AdditionComponent.)
     :- #(SubtractComponent.)
     :* #(MultiplyComponent.)
     :div #(DivideComponent.)})


  ;; Read the head, pass it to a parser function, 
  ;; pass the rest to the parser function
  ;; Add the rest as children


  (let [[x & y] [3 4 5 6]] [x y])

  (number? 4)

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

      
      (seq? 3)

  (def d (parse-list '(:+ 4 5 (:- 4 5))))
  (.evaluate d)

  (def ttv (new TextTreeVisitor))

  (println (use-visitor d ttv))

  ((component->class :+))
  (vector? [:+ 1 2])
  (number? 4)

  (def a1 (new AdditionComponent ))
  (.addChild a1 nss)
  (.evaluate a1)
  (double 1)
  (def n1 (new LeafNumberComponent 1.0))
  (def n2 (new LeafNumberComponent 1.0))
  (doubles '(1 2 3))
  (new LeafNumberComponent (double-array [1 2 3 4]))

  )
