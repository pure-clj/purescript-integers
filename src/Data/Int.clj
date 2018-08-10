(ns Data.Int._foreign
  (:refer-clojure :exclude [quot rem]))

(defn fromNumberImpl [just]
  (fn [nothing]
    (fn [n]
        (if (and (<= n Long/MAX_VALUE)
                 (= n (double (long n))))
          (just (long n))
          nothing))))

(defn toNumber [x]
  (double x))

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
