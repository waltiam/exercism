(ns bird-watcher)

(def last-week
  [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (->>
   (today birds)
   inc
   (conj (pop birds))))

(defn day-without-birds? [birds]
  ;; yuck - this feels bad - sort oflike JS !!
  ;; unfortunately `any?` as a keyword was used in the core library for something completely different
  (not (not-any? zero? birds)))
  ;; the advantage of the `not-any?` is (and this bears validation), `every?` is greedy whereas `not-any?` should execute lazy.
  ;; (not (every? pos? birds)))


(defn n-days-count [birds n]
  (reduce + (take n birds)))
  ;; (apply + (take n birds)))

(defn busy-days [birds]
  (->>
   birds
   (filter #(>= % 5))
   count))

(defn odd-week? [birds]

  (=
   [1 0 1 0 1 0 1]
   birds))
  ;; (->>
  ;;  [1 0 1 0 1 0 1]
  ;;  (map #(= %1 %2) birds)
  ;;  (filter #(eval %))
  ;;  count
  ;;  (= 7)))
