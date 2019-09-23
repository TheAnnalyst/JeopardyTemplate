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

    var roundsPlayed = 0 // A counter for rounds played
    val totalRounds = board.questions.size / 2 // We'll play as many round as we have questions for.

    while (roundsPlayed < totalRounds){ // Loop until we run out of questions
        var qValue = 100 * (roundsPlayed + 1) // Points for the question
        for (player in players){ // Iterate over the players.
            player.takeTurn(board, qValue) // Take the turn
            showScores(players) // Show the scores
        }
        roundsPlayed++ // Increment the rounds played.
    }
    // Determine the winner.
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
    // Show the scores of all the players.
    var str = ""
    for (player in players){
        str += "${player.name}: ${player.score} "
    }
    println(str)
}


