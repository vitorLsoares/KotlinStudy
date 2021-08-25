package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition =  0
    var wrongPosition =  4
    var aux = 0
    val auxChar : MutableList<Char> = mutableListOf<Char>()

    for(i in secret.indices){
        if(secret[i] == guess[i]) {
            rightPosition += 1
            wrongPosition -= 1
            if(secret.count{c -> c==guess[i]} < guess.count{c -> c==guess[i]}){
                aux+= 1
                auxChar.add(guess[i])
            }
        }
        else{
            if(!secret.contains(guess[i])){
                wrongPosition -= 1
                continue
            }
            auxChar.add(guess[i])
        }
    }

    if(aux > 0){
        val auxChar1 = auxChar.distinct().toList()
        for(ch in auxChar1)
        {
            val int = guess.count{ c -> c==ch}
            if(wrongPosition != 0 && int>1)
                wrongPosition -= int - aux
            else if(int==1)
                wrongPosition += 1
        }
    }
    else if(aux == 0 && auxChar.size > 1){
        wrongPosition = 0
        val auxChar1 = auxChar.distinct().toList()
        for(ch in auxChar1)
        {
            wrongPosition += when{
                secret.count{c -> c==ch} < guess.count{c -> c==ch} -> secret.count{ c -> c==ch}
                else -> guess.count{ c -> c==ch}
            }
        }
    }

    return Evaluation(rightPosition,wrongPosition)
}
