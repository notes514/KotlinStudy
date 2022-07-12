package com.kotlin.test

/**
 *
 *
 * @author dhxstart
 * @date 2022/7/12 20:50
 */
fun num2AndNum3(num2: Int, num3: Int, operation: (Int, Int) -> Int) : Int {
    return operation(num2, num3)
}

/**
 * inline 表示声明一个内联函数
 * 作用：它可以将开发者在使用 Lambda 表达式所带来的运行时开销完全消除
 */
inline fun num3AndNum4(num3: Int, num4: Int, operation: (Int, Int) -> Int) : Int {
    return operation(num3, num4)
}

/**
 * noinline 表示取消当前修饰的函数，使之不成为一个所谓的内联函数（非内联函数）
 */
inline fun inlineTest(block1: () -> Unit, noinline block2: () -> Unit) {
    println("inlineTest")
}

inline fun printString(str: String, block: (String) -> Unit) {
    println("print String start")
    block(str)
    println("print String end")
}

/**
 * crossinline 关键字就像是一个契约，它能够保证内联函数的 lambda 表达式或匿名内部类中一定不会使用 return 关键字
 */
inline fun runRunnable(crossinline block: () -> Unit) {
    val runnable = Runnable {
        // 高阶函数中的 lambda 表达式和匿名内部类不允许使用 return 关键字
        block()
    }
    runnable.run()
}

fun main() {
    val num2 = 100
    val num3 = 80
    val result = num2AndNum3(num2, num3) { n2, n3 ->
        n2 + n3
    }
    println("result：${result}")
    // 内联函数（inline 修饰）的使用
    println("main start")
    val str = ""
    printString(str) { s ->
        println("lambda start")
        // return@printString 表示局部返回，而 return 表示返回外层的调用函数（具体可以参考内联函数代码替换过程）
        if (s.isEmpty()) return@printString
        println(s)
        println("lambda end")
    }
    println("main end")
}