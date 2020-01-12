(ns cljfmt-graalvm.diff
  (:require
   [clojure.string :as str]
   [clojure.java.io :as io])
  (:import [difflib DiffUtils]
           [java.io File]
           [java.util.regex Pattern]))


(defn to-absolute-path [filename]
  (.getCanonicalPath
   ^java.io.File
   (apply
    io/file
    (str/split filename (re-pattern (Pattern/quote File/separator))))))

(defn- unlines [ss]
  (str/join "\n" ss))


(defn- lines [s]
  (str/split s #"\n"))

(defn unified-diff
  ([filename original revised]
   (unified-diff filename original revised 3))
  ([filename original revised context]
   (unlines (DiffUtils/generateUnifiedDiff
             (->> filename to-absolute-path (str "a"))
             (->> filename to-absolute-path (str "b"))
             (lines original)
             (DiffUtils/diff (lines original) (lines revised))
             context))))

(def ^:private ansi-colors
  {:reset "[0m"
   :red   "[031m"
   :green "[032m"
   :cyan  "[036m"})

(defn- colorize [s color]
  (str \u001b (ansi-colors color) s \u001b (ansi-colors :reset)))

(defn colorize-diff [diff-text]
  (-> diff-text
      (str/replace #"(?m)^(@@.*@@)$"       (colorize "$1" :cyan))
      (str/replace #"(?m)^(\+(?!\+\+).*)$" (colorize "$1" :green))
      (str/replace #"(?m)^(-(?!--).*)$"    (colorize "$1" :red))))
