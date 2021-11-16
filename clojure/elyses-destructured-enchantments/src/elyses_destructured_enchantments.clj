(ns elyses-destructured-enchantments)

(defn- empty-if-nil [c] (if (nil? c) () c))

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[f] deck]
    f))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ f] deck]
    f))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (->>
   (let [[a b & r] deck] [b a (empty-if-nil r)])
   flatten))

(defn discard-top-card
  "Returns a vector containing the first card and
   a vector of the remaining cards in the deck."
  [deck]
  (->>
   (let [[f & r] deck] [f r])))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (->>
   (let [[f & r] deck] [(empty-if-nil f) face-cards (empty-if-nil r)])
   flatten))
