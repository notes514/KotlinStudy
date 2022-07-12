package com.laodai.test

/**
 * Money实体
 *
 * @author dhxstart
 * @date 2022/6/15 23:24
 */
class Money(val value: Int) {

    operator fun plus(money: Money) : Money {
        val sum = value + money.value
        return Money(sum)
    }

    // 说明：Kotlin支持多重重载
    operator fun plus(money: Int) : Money {
        val sum = value + money
        return Money(sum)
    }
}