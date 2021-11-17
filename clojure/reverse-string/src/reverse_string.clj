(ns reverse-string)

(defn reverse-string
  ;; [s] (apply str (reverse s)))
  ;; an unstated requirement is to do this without `reverse`
  [s] (apply str (into () s)))
