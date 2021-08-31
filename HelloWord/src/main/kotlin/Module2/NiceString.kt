package Module2

fun String.isNice():Boolean{
    val noBadSubstring = setOf("ba","be","bu").none(){this.contains(it)}
    //val noBadSubstring = setOf("ba","be","bu").all(){!this.contains(it)}

    val hasThreeVolwels = count{it in "aeiou"}>=3
    //val hasThreeVolwels = count{it in setOf('a','e','i','o','u')}>=3

    val hasDoubleEqualLetter = zipWithNext().any(){it.first == it.second}
    //val hasDoubleEqualLetter = (0 until lastIndex).any(){this[it] == this[it+1]}
    //val hasDoubleEqualLetter = windowed(2).any(){it[0] == it[1]}

    return listOf(noBadSubstring,hasThreeVolwels,hasDoubleEqualLetter).count{it}>=2
    //return listOf(noBadSubstring,hasThreeVolwels,hasDoubleEqualLetter).filter{ it }.size>=2
}
fun main() {
    "bac".isNice() eq false
    "aza".isNice() eq false
    "abaca".isNice() eq false
    "baaa".isNice() eq true
    "aaab".isNice() eq true
}