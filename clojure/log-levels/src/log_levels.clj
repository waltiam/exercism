(ns log-levels
  (:require [clojure.string :as str]))

(defn- log-splitter [log]
  (->>
   (re-find #"^\[(.*)\]\s*:\s*(.*)\s*" log)
   (drop 1)))

(def split-logs (memoize log-splitter))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (->
   (split-logs s)
   last
   ;; unfortunately the regex in clojure does not seem to be able to grab the `\n`
   str/trim))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (->>
   (split-logs s)
   first
   str/lower-case))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  ;; using 'memoization' to avoid re parsing the same log,
  (format "%s (%s)" (message s) (log-level s)))
