package objects;

import kotlin.random.Random

public class Player(argName: String?){
    var name :String? = ""
    var score = 0
    var qsAnswered = 0
    // Put your code for the Player() object here
    // This could be stuff like collected points or answered questions
    init {
        name = argName
    }
    fun takeTurn(board: GameBoard, qValue: Int) {
        // Takes a turn
        val questionNumber = Random.nextInt(0,board.questions.size) // pick a random question
        println("${name}'s turn!")
        println("This question is worth ${qValue} points.")
        println("The question is: ${board.questions[questionNumber]}")
        print("Answer here: ") // Use print() to keep it all on one line
        val answer = readLine()
        if (answer == board.answers[questionNumber]){
            // The answer is correct!
            board.questions.removeAt(questionNumber) // Remove the question so it isn't asked again
            board.answers.removeAt(questionNumber)
            score += qValue
            println("That's right!")
        } else {
            // The answer was wrong >:(
            println("Sorry, ${answer} is incorrect.")
        }
    }
}