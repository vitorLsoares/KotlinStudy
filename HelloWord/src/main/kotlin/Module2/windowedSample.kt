package Module2

fun main() {
    val str = "abcdefg"
    println("4: "+ str.windowed(4))
    println("3: "+ str.windowed(3))
    println("2: "+ str.windowed(2))

    println()
    println("2, step4: "+ str.windowed(2,step = 5))
    println("3, step4: "+ str.windowed(3,step = 5))

}