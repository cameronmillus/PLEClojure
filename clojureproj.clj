(ns clojure-program310.core
  (:gen-class))

(defn init-row-major [x] ; function for traversing the matrix via rows
  (let [rows (count x)
        cols (count (first x))]
    (dotimes [i rows]
      (dotimes [j cols]
        (aset x i j (double (+ i (* j rows)))))))) ; initialize matrix with values 0 through max

(defn init-column-major [x] ; function for traversing via columns
  (let [rows (count x)
        cols (count (first x))]
    (dotimes [j cols]
      (dotimes [i rows]
        (aset x i j (double (+ j (* i cols)))))))) ; initialize matrix with values 0 through max

(defn -main [& args]
  (if (= (count args) 3)
    (let [min (Integer/parseInt (nth args 0))
          max (Integer/parseInt (nth args 1))
          step-size (Integer/parseInt (nth args 2))]
      (doseq [i (range min (inc max) step-size)]
        (let [matrix (make-array Double/TYPE i i)]
          (let [start-t (System/currentTimeMillis)
                _ (init-row-major matrix)
                end-t (System/currentTimeMillis)
                start-t1 (System/currentTimeMillis)
                _ (init-column-major matrix)
                end-t1 (System/currentTimeMillis)]
            (let [elapsed-t (/ (- end-t start-t) 1000.0)
                  elapsed-t1 (/ (- end-t1 start-t1) 1000.0)]
              (println (format "m (#rows and cols): %d, elapsed time (row major): %.3f seconds, elapsed time (column major): %.3f seconds" i elapsed-t elapsed-t1)))))))
    (println "The incorrect number of command line arguments were entered. Try this in command line:")
    (println "java FileName <min> <max> <step_size>")))
