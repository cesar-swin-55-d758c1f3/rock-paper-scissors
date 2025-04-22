(ns rock-paper-scissors.core
  (:gen-class))

(defn beats? [player1 player2]
  (cond
    (= player1 player2) :tie
    (or (and (= player1 :rock) (= player2 :scissors))
        (and (= player1 :scissors) (= player2 :paper))
        (and (= player1 :paper) (= player2 :rock))) :win
    :else :lose))

(defn get-computer-choice []
  (rand-nth [:rock :paper :scissors]))

(defn get-player-choice []
  (println "Enter your choice (rock, paper, scissors):")
  (let [input (read-line)]
    (keyword (clojure.string/lower-case input))))

(defn play-game []
  (let [player-choice (get-player-choice)
        computer-choice (get-computer-choice)]
    (println "You chose:" player-choice)
    (println "Computer chose:" computer-choice)
    (case (beats? player-choice computer-choice)
      :win (println "You win!")
      :lose (println "You lose!")
      :tie (println "It's a tie!"))))

(defn -main [& args]
  (println "Welcome to Rock Paper Scissors!")
  (loop []
    (play-game)
    (println "Play again? (y/n)")
    (if (= (read-line) "y")
      (recur)
      (println "Thanks for playing!"))))
