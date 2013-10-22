(ns hw7.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(import '[hw6 Component Leaf ArrayComposite ArrayIterator])

(def l1 (Leaf. "A"))
(def a1 (new ArrayComposite (into-array Component [(Leaf. "A") (Leaf. "B")] )))
(def a1 (into-array Component [(Leaf. "A") (Leaf. "B")]))

(second (.leaves a1))
(.add a1 (Leaf. "A"))
(.toString a1)
(.leaves a1)
(def i1 (.CreateIterator a1))
(.currentItem i1)
(.hasNext i1)
(.array i1)

(def i1 (ArrayIterator. a1))
(.hasNext i1)
