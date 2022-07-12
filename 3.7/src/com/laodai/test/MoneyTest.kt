package com.laodai.test

/**
 *
 *
 * @author dhxstart
 * @date 2022/6/15 23:27
 */
object MoneyTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val money1 = Money(5)
        val money2 = Money(10)
        val money3 = money1 + money2
        val money4 = money3 + 20
        println("value3：" + money3.value)
        println("value4：" + money4.value)
    }
}