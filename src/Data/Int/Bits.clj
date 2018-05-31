(ns Data.Int.Bits._foreign
  (:refer-clojure :exclude [and or complement]))

(defn and [^long n1]
  (fn [^long n2]
    (bit-and n1 n2)))

(defn or [^long n1]
  (fn [^long n2]
    (bit-or n1 n2)))

(defn xor [^long n1]
  (fn [^long n2]
    (bit-xor n1 n2)))

(defn shl [^long n1]
  (fn [^long n2]
    (bit-shift-left n1 n2)))

(defn shr [^long n1]
  (fn [^long n2]
    (bit-shift-right n1 n2)))

(defn zshr [^long n1]
  (fn [^long n2]
    (unsigned-bit-shift-right n1 n2)))

(defn complement [^long n]
  (bit-not n))
