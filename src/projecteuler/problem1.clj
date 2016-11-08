(ns projecteuler.problem1)

(defn solution
  "Find the sum of all the multiples of 3 or 5 below 1000. https://projecteuler.net/problem=1d"
  []
  (filter
   (fn [x]
      ;; Test if x is divisable by 3 or 5
     (or
        ;; Exclude results that are not an integer
      (integer?
       (/ x 3))
      (integer?
       (/ x 5))))
    ;; Generate a sequence of numbers from 1 to 1000
   (range 1 1000)))