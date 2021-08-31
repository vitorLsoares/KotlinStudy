package Module2

fun main() {
//    val list : List<Int> = listOf(0,1,2,3,4,4,5,6)
//
//    println(list.all{ int -> int == 0})
//    val isEven = { i: Int -> i % 2 == 0 }
//
//    println(isEven)

    val string = "aaba"

    println(string.contains("""(ba|bu|be)"""))

    //val regex = """(ba|bu|be)""".toRegex()
    //val regex = """(.)\1""".toRegex(setOf(RegexOption.IGNORE_CASE))
    val regex = """(.*[aeiouy]){3,}""".toRegex(setOf(RegexOption.IGNORE_CASE))

    println(regex.containsMatchIn("andbaRRe"))

}