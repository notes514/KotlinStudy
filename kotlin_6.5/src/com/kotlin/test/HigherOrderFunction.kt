package com.kotlin.test

/**
 * Kotlin 高阶函数的使用
 *
 * @author dhxstart
 * @date 2022/7/11 21:30
 */
fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun plus(num1: Int, num2: Int) : Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int) : Int {
    return num1 - num2
}

/**
 * 说明：这里给StringBuilder类定义了一个 build 的拓展函数，这个扩展
 * 函数用来接收一个‘函数类型’参数，并且返回值也是 StringBuilder
 * StringBuilder. 语法结构，是定义高阶函数的完整语法规则
 * 表示函数类型定义在哪个类当中
 */
fun StringBuilder.build(block: StringBuilder.() -> Unit) : StringBuilder {
    block()
    return this
}


fun main() {
    val num1 = 100
    val num2 = 80
    // :: plus 是一种函数引用方式的写法，将 plus 作为参数传递给 num1AndNum2 函数
    val result1 = num1AndNum2(num1, num2, :: plus)
    val result2 = num1AndNum2(num1, num2, :: minus)
    println("result1: ${result1}")
    println("result2: ${result2}")

    // 使用 Lambda 表达式实现
    // 说明：Lambda 表达式中最后一行代码会自动作为返回值
    val result3 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 + n2
    }
    val result4 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 - n2
    }
    println("result3: ${result3}")
    println("result4: ${result4}")

    //
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().build {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(result.toString())
}