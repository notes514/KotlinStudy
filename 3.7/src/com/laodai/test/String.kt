package com.laodai.test

// Kotlin编程中在String实现拓展函数
fun String.lettersCount() : Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}