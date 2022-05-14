(ns bob
  (:require [clojure.string :as str]))

(defn- has-no-meaning? [sentence] (nil? (re-find #"[a-zA-Z]+" sentence)))
(defn- nothing? [sentence] (= 0 (count sentence)))
(defn- yelling? [sentence] (and (= (str/upper-case sentence) sentence) (not (has-no-meaning? sentence))))
(defn- question? [sentence] (= (last sentence) \?))
(defn- yelling-question? [sentence] (and (yelling? sentence) (question? sentence) (not (has-no-meaning? sentence))))

(defn response-for [s] ;; <- arglist goes here
  (let [sentence (str/trim s)]
    (cond
      (nothing? sentence) "Fine. Be that way!"
      (yelling-question? sentence) "Calm down, I know what I'm doing!"
      (question? sentence) "Sure."
      (yelling? sentence) "Whoa, chill out!"
      (has-no-meaning? sentence) "Whatever."
      :else "Whatever.")))
