(ns projecteuler.problems)

(defn Problem1
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

;; Test if number is a palindrome.
(defn palindrome? [n]
  ;; Convert number to string and test it against the same string but reversed.
  (= (str n) (apply str (reverse (str n)))))

;; Generate a sequence of numbers from 100 to 999.
(def digits (reverse (range 100 1000)))

(defn Problem4
  "Find the largest palindrome made from the product of two 3-digit numbers. https://projecteuler.net/problem=4"
  []
  ;; Convert sequence to args and pass to max.
  (apply max
         ;; Filter out all non-palindrome digits.
         (filter palindrome?
                 ;; Generate a list of products based on two 3 digit numbers.
                 (for [x digits y digits]
                   (* x y)))))

;; Test if number is prime.
(defn prime? [n]
  ;; Fast path for 2 and 3
  (if (or (= n 2) (= n 3))
    true
    ;; Generate a range of 2 to the number we are testing.
    ;; Mod will return 0 if the number in the range is not a factor of n.
    ;; If the resulting sequence is empty then the number is not prime.
    (empty? (filter #(= 0 (mod n %)) (range 2 n)))))

;; The position of the prime number we are looking for.
(def prime-pos 10001)

(defn Problem7
  "What is the 10,001st prime number? - https://projecteuler.net/problem=7"
  ;; Gives us a sequence of 10,001 prime numbers.
  ;; The last one in that sequence will be the one in the 10,001st position.
  [] (last (take prime-pos
                 ;; Filter out all non-prime numbers.
                 (filter prime?
                    ;; Generate a sequence of numbers starting at 2.
                         (iterate inc 2)))))