import objects.Player
import kotlin.random.Random

fun main() {
    // Put code you want to run here
    // Then press the green arrow to the left to run it
    print("Player 1, enter your name: ")
    val p0name = readLine()
    print("Player 2, enter your name: ")
    val p1name = readLine()
    // Set up the players
    var players = arrayOf(objects.Player(p0name), objects.Player(p1name)) // list of Players
    var board = objects.GameBoard() // make the board
    var roundsPlayed = 0
    val totalRounds = board.questions.size / 2
    while (roundsPlayed < totalRounds){ // Loop until we run out of questions
        var qValue = 100 * (roundsPlayed + 1) // Points for the question
        for (player in players){
            val questionNumber = Random.nextInt(0,board.questions.size) // pick a random question
            println("${player.name}'s turn!")
            println("This question is worth ${qValue} points.")
            println("The question is: ${board.questions[questionNumber]}")
            print("Answer here: ") // Use print() to keep it all on one line
            val answer = readLine()
            if (answer == board.answers[questionNumber]){
                // The answer is correct!
                board.questions.removeAt(questionNumber) // Remove the question so it isn't asked again
                board.answers.removeAt(questionNumber)
                player.score += qValue
                println("That's right!")
            } else {
                // The answer was wrong >:(
                println("Sorry, ${answer} is incorrect.")
            }
            showScores(players) // Show the scores
        }
        roundsPlayed++
    }
    if (players[0].score == players[1].score) {
        // Tie
        println("It's a tie!")
    } else if (players[0].score > players[1].score) {
        // Player 0 wins!
        println("${players[0].name} wins!")
    } else {
        // Player 1 wins!
        println("${players[1].name} wins!")
    }
}
fun showScores(players: Array<Player>){
    var str = ""
    for (player in players){
        str += "${player.name}: ${player.score} "
    }
    println(str)
}


