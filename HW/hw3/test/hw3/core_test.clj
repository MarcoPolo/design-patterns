(ns hw3.core-test
  (:use clojure.test
        hw3.core)
  (:import [hw3 Currency CartPoint]))

(defn run-comparisons [x y m1 m2]
  (testing "Equal To"
    (is (=
          (= x y)
          (.equalTo m1 m2))))
  (testing "less Than"
    (is (=
          (< x y)
          (.lessThan m1 m2))))
  (testing "greater Than"
    (is (=
          (> x y)
          (.greaterThan m1 m2))))
  (testing "not equal"
    (is (=
          (not= x y)
          (.notEqual m1 m2))))
  (testing "less than or equal"
    (is (=
          (<= x y)
          (.lessThanEqualTo m1 m2))))
  (testing "greater than or equal"
    (is (=
          (>= x y)
          (.greaterThanEqualTo m1 m2)))))

(defn point->magnitude [[x y]]
  (Math/sqrt (+ (Math/pow x 2) (Math/pow y 2))))

(def test-range (range 10))

(deftest money-test
  (doseq [x test-range y test-range :let [m1 (Currency. x) m2 (Currency. y)]]
    (run-comparisons x y m1 m2)))

(deftest point-test
  (doseq [x1 test-range y1 test-range  
          x2 test-range y2 test-range 
          :let [m1 (CartPoint. x1 y1) m2 (CartPoint. x2 y2)
                x (point->magnitude [x1 y1]) y (point->magnitude [x2 y2]) ]]
    (run-comparisons x y m1 m2)))

