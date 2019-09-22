package objects;

public class Player(argName: String?){
    var name :String? = ""
    var score = 0
    var qsAnswered = 0
    // Put your code for the Player() object here
    // This could be stuff like collected points or answered questions
    init {
        name = argName
    }
}