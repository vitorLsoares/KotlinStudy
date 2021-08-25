import java.util.*

fun main() {
    val string1 = "BDBC"
    val string2 = "DDFC"

    for(i in 0..10){
        if(i == 2)
        {
            println("igual a 2")
        }
        else{
            if(i==4)
            {
                println("#")
                continue
            }
            println(".")
        }

        println(i)
    }


    //println(string2.count{ch -> ch == 'd'.toUpperCase()})

//    val count = "Hello world".count{ch -> ch=='l'}
//    print(count)
}