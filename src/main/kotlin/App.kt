package com

class App {
    fun run() {
        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val command = readln()

            if (command == "종료") {
                break
            }
        }
    }
}