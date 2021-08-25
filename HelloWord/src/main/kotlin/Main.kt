fun main() {
    val list = listOf("a","b","c")
    val map = mapOf(1 to "one",
                    2 to "two",
                    3 to "three")
    for ((key,value) in map) {
        println("$key = $value")
    }

    //for(i in 1..9){
    //for(i in 1 until 9){
    for(i in 9 downTo 1 step 2){
        println(i)
    }

    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in setOf("Java", "Scala"))


}