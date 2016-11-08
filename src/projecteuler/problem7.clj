(ns projecteuler.problem7)

;; Test if number is prime.
(defn prime? [n]
  ;; Fast path for 3
  (if (= n 3)
    true
    ;; Generate a range of 2 to the number we are testing.
    ;; Mod will return 0 if the number in the range is not a factor of n.
    ;; If the resulting sequence is empty then the number is not prime.
    (empty? (filter #(= 0 (mod n %)) (range 2 n)))))

(defn solution
  "What is the 10,001st prime number? - https://projecteuler.net/problem=7"
  ;; Gives us a sequence of 10,001 prime numbers numbers minus 1.
  ;; We subtract 1 from the prime-pos to compinsate for the number 2 not being included
  ;; in the odd sequence. We only evaulate odd numbers because all prime numbers are odd.
  ;; The last one in that sequence will be the one in the 10,001st position.
  []
  ;; The position of the prime number we are looking for.
  (let [prime-pos 10001]
    (last (take (- prime-pos 1)
                 ;; Filter out all non-prime numbers.
                (filter prime?
                    ;; Generate a sequence of odd numbers starting at 3.
                        (iterate #(+ % 2) 3))))))