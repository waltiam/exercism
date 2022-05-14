(ns collatz-conjecture)

(defn- func [num]
  (if (even? num) (/ num 2) (+ (* 3 num) 1)))

(defn collatz [num] ;; <- arglist goes here
  (if (< num 1) (throw (new Exception "Ka-Boom"))

      (loop [step  0 value num]

        (if (= 1 value) step
            (recur (+ 1 step) (func value))))))