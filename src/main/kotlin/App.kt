package com

class App {
    private var lastId = 0;

    fun run() {
        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val command = readln().trim()

            when (command) {
                "종료" -> {
                    break
                }
                "등록" -> {
                    print("명언 : ")
                    val content = readln().trim()
                    print("작가 : ")
                    val author = readln().trim()

                    lastId++
                    println("${lastId}번 명언이 등록되었습니다.")
                }
            }
        }
    }
}