(ns accumulate)

(defn accumulate [func collection-to-evaluate]
  (loop [working-collection collection-to-evaluate evaluated-collection []]
    (let [value (first working-collection)
          has-no-value  (nil? value)]
      (if  has-no-value
        evaluated-collection
        (recur (rest working-collection) (conj evaluated-collection (func value)))))))
