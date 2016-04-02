(ns thrown-test.core-test
  (:require [clojure.test :refer :all]
            [thrown-test.core :refer :all]))

(defn throw-not-caught
  []
  (map
   (fn [x]
     (when (= x 50)
       (throw "AAAAAH! 50!")))
   (range 100)))

(defn throw-caught
  []
  (doall
   (map
    (fn [x]
      (when (= x 50)
        (throw "AAAAAH! 50!")))
    (range 100))))

(deftest a-test
  (testing "Is the exception caught"
    (is
     (thrown?
      Exception
      (throw-not-caught)))

    (is
     (thrown?
      Exception
      (throw-caught)))))
