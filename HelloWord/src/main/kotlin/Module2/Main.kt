package Module2

fun main() {
    val s: String?
    s = null
    val length = s?.length
    println(length)

    val a: Int? = null
    val b: Int? = 1
    val c: Int = 2

    val s1 = (a ?: 0) + c
    val s2 = (b ?: 0) + c
    println("$s1$s2")


    // Caso
    val x: Int? = 1
    val y: Int = 2
    val sum = x ?: 0 + y
    println(sum)

    println(s as? Int)
    println(s as Int?)

}

