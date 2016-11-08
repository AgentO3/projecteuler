(ns projecteuler.problem4)

;; Test if number is a palindrome.
(defn palindrome? [n]
  ;; Convert number to string and test it against the same string but reversed.
  (= (str n) (apply str (reverse (str n)))))

(defn solution
  "Find the largest palindrome made from the product of two 3-digit numbers. https://projecteuler.net/problem=4"
  []
  ;; Generate a sequence of numbers from 100 to 999.
  ;; Convert sequence to args and pass to max.
  (let [digits (reverse (range 100 1000))]
    (apply max
           ;; Filter out all non-palindrome digits.
           (filter palindrome?
                   ;; Generate a list of products based on two 3 digit numbers.
                   (for [x digits y digits]
                     (* x y))))))
