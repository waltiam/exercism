(ns all-your-base)

(defn- resolve-digit [value base] (list (quot value base) (rem value base)))

;; (defn- prn [x])

;; will explode if n < 0
(defn- expt [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

;; reduce the pattern to a base ten value
(defn- reduce-pattern [pattern input-base]
  (loop [in (next (reverse pattern)) accumulator (last pattern) index 1]
    (if (nil?  in)  accumulator
        (recur (next in) (+ accumulator (* (first in) (expt input-base index))) (inc index)))))

(defn convert [input-base pattern output-base]
  ;; yuck guard statements
  (if (or (neg? input-base)
          (zero? input-base)
          (= 1 input-base)
          (neg? output-base)
          (zero? output-base)
          (= 1 output-base)
          (some #(>= % input-base) pattern)
          (some neg? pattern)) nil
      (if (empty? pattern) ()
 ;; a recursive call to do remainder math
          (loop [in (reduce-pattern pattern input-base) out []]
            (let [result (resolve-digit in output-base)
                  answer (cons (last result) out)]
              (if (= 0 (first result))
                answer
                (recur (first result) answer)))))))