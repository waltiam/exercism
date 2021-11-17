(ns armstrong-numbers)
;; using the math library
  ;; (require '[clojure.math.numeric-tower :as math])

;; will explode if n < 0
(defn- expt [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn- _n2v [n]
  (map #(Character/digit % 10) (str n)))

(def n2v (memoize _n2v))

(defn armstrong? [num]
  (let [v (n2v num)
        c (count v)]
    (->>
     (map #(expt % c) v)
    ;;  (map #(math/expt % c) v)
     (reduce +)
     (== num))))


