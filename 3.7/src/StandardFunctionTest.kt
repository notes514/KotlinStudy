/**
 *
 *
 * @author dhxstart
 * @date 2021/12/28 23:27
 */
fun main() {
    // 不使用 with()、run() 连续调用同一个对象使用多个方法时的场景
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val builder = StringBuilder()
    builder.append("Start eating fruits.\n")
    for (fruit in list) {
        builder.append(fruit).append("\n")
    }
    builder.append("Ate all fruits.")
    val result = builder.toString()
    println(result)
    println("\n\n")

    // 使用 with() 时的场景
    val resultWith = with(StringBuilder()) {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        // with函数中Lambda中最后一行代码表示返回值
        toString()
    }
    println(resultWith)
    println("\n\n")

    // 使用 run() 时的场景
    val resultRun = StringBuilder().run {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        // run函数中Lambda中最后一行代码表示返回值
        toString()
    }
    println(resultRun)
    println("\n\n")

    // 使用 apply() 时的场景，apply() 跟 run() 类似，区别就是 apply() 无法指定返回值
    val resultApply = StringBuilder().apply {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(resultApply.toString())
}