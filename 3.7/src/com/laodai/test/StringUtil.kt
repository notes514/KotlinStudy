package com.laodai.test

/**
 *
 *
 * @author dhxstart
 * @date 2022/6/15 23:15
 */
object StringUtil {

    // Java编程中最标准的实现思维
    fun lettersCount(str: String) : Int {
        var count = 0
        for (char in str) {
            if (char.isLetter()) {
                count++
            }
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val count = "ABC123xyz~@#".lettersCount()
        println("count：$count")
    }
}