(ns Data.Int._foreign
  (:refer-clojure :exclude [quot rem]))

(defn fromNumberImpl [just]
  (fn [nothing]
    (fn [n]
      (try
        (if (= n (int n))
          (just n)
          nothing)
        (catch Exception _
          nothing)))))

(defn toNumber [x]
  x)

(defn fromStringAsImpl [just]
  (fn [nothing]
    (fn [^long radix]
      (fn [^String s]
        (try
          (just (Integer/parseInt s radix))
          (catch NumberFormatException _
            nothing))))))

(defn toStringAs [^long radix]
  (fn [^long i]
    (Integer/toString i radix)))

(defn quot [^long x]
  (fn [^long y]
    (clojure.core/quot x y)))

(defn rem [^long x]
  (fn [^long y]
    (clojure.core/rem x y)))

(defn pow [^long x]
  (fn [^long y]
    (int (Math/pow x y))))
