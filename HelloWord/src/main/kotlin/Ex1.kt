import io.ktor.util.*
import java.util.stream.Collector
import kotlin.text.toCharArray

//Solution of Teacher
fun isValidIdentifier(s: String): Boolean {
    fun isValidCharacter(ch: Char) =
        //ch == '_' || ch in '0'..'9' || ch in 'a'..'z' || ch in 'A'..'Z'
        ch == '_' || ch.isLetterOrDigit()
    //if(s.isEmpty() || s[0] in '0'..'9') return false
    if(s.isEmpty() || s[0].isDigit()) return false
    for(ch in s){
        if(!isValidCharacter(ch)) return false
    }

    return true
}

//My Solution
fun isValidIdentifierMy(s: String): Boolean {
    var aux = 0
    for (char in s)
    {
        if((char !in 'a'..'z' && char !in 'A'..'Z' && char != '_') && aux == 0)
            return false
        if((char !in 'a'..'z' && char !in 'A'..'Z' && char != '_' && char !in '0'..'9') && aux == 1)
            return false
        aux = 1
    }
    return s!=""
}

data class Person(var name: String, var age:Int)

fun main() {
    var  person = Person("Alice",27)
    person.age = 30
    println(person)
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}