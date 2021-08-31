package nicestring

fun String.isNice(): Boolean {
    val regex1 = """(ba|bu|be)""".toRegex(setOf(RegexOption.IGNORE_CASE))
    val regex2 = """(.)\1""".toRegex(setOf(RegexOption.IGNORE_CASE))
    val regex3 = """(.*[aeiou]){3,}""".toRegex(setOf(RegexOption.IGNORE_CASE))
    val listBoolean = mutableListOf<Boolean>(true,false,false)

    if (regex1.containsMatchIn(this)) listBoolean[0] = false
    if (regex2.containsMatchIn(this)) listBoolean[1] = true
    if (regex3.containsMatchIn(this)) listBoolean[2] = true

    if(listBoolean.count{ it } >= 2)
        return true
    return false
}