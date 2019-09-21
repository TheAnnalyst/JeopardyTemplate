import objects.Player

fun main() {
    // Put code you want to run here
    // Then press the green arrow to the left to run it
    var players = arrayOf(objects.Player("Player 1"), objects.Player("Player 2")) // list of Players
    var board = objects.GameBoard()
    var roundsPlayed = 0
    while (roundsPlayed < 2){
        var qValue = 100
        for (player in players){
            println("${player.name}'s turn!")
            println("This question is worth ${qValue} points.")
            println("The question is: ${board.questions[0]}")
            println("Answer here: ")
            val answer = readLine()
            if (answer == board.answers[0]){
                // The answer is correct!
                board.questions.removeAt(0) // Remove the question so it isn't asked again
                board.answers.removeAt(0)
                player.score += qValue
                println("That's right!")
            } else {
                // The answer was wrong >:(
                println("Sorry, ${answer} was incorrect.")
            }
            showScores(players)
        }
        roundsPlayed++
    }
}
fun showScores(players: Array<Player>){
    var str = ""
    for (player in players){
        str += "${player.name}: ${player.score} "
    }
    print(str)
}


