data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count {  it.first == it.second }

    val commonLetters = "ABCDEF".sumOf { ch ->

        Math.min(secret.count { it == ch }, guess.count { it == ch })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}

fun evaluateGuessMy(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count {  pair -> pair.equals() }

    val commonLetters = "ABCDEF".sumOf { ch ->

        Math.min(secret.count { c -> c == ch }, guess.count { c -> c == ch })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}

private fun <A, B> Pair<A, B>.equals(): Boolean {
    return this.first == this.second
}

fun main(args: Array<String>) {
    val result = Evaluation(rightPosition = 1, wrongPosition = 1)
    evaluateGuess("BCDF", "ACEB") eq result
    evaluateGuess("AAAF", "ABCA") eq result
    evaluateGuess("ABCA", "AAAF") eq result

}
infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}