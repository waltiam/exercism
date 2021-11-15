(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (->>
   (cond
     (= speed 0) 0.0
     (<=  speed 4) 1.0
     (<=  speed 8) 0.90
     (= speed 9) 0.80
     :else 0.77)
   (* 221 speed)))


(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int
   (/ (production-rate speed) 60)))
