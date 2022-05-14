(ns anagram
  (:require [clojure.string :as str]))

(defn- lower [word] (str/lower-case word))
(defn- lower-sort [word] (sort (lower word)))

(defn- anagram? [this-word some-other-word]
  (and
   (not= (lower this-word) (lower some-other-word));;
   (= (lower-sort this-word) (lower-sort some-other-word))))

(defn anagrams-for [word prospect-list]  ;;
  (filter #(anagram? word %) prospect-list))