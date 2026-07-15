package com

class App {
    private var lastId = 0;
    val wiseSayings = mutableListOf<WiseSaying>()
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

                    wiseSayings.add(WiseSaying(lastId, content, author))
                    println("${lastId}번 명언이 등록되었습니다.")
                }
                "목록" -> {
                    println("번호 / 작가 / 명언")
                    println("---------------------")
                    for (wiseSaying in wiseSayings.reversed()) {
                        println("${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.content}")
                    }
                }
            }
        }
    }
}