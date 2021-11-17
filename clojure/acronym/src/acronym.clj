(ns acronym
  (:require [clojure.string :as str]))

(defn acronym [s]
  (->>
   (loop [last-char \space this-char (first s) remaining s acronym []]
     (if (nil? this-char)
       acronym
       (recur this-char (first remaining) (next remaining)
              (cond
                (= last-char \space) (conj acronym this-char)
                (= last-char \-) (conj acronym this-char)
                (Character/isUpperCase last-char)  acronym
                (Character/isUpperCase this-char) (conj acronym this-char)
                :else acronym))))
   (apply str)
   str/upper-case))


