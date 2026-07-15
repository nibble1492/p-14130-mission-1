package com

class App {
    private var lastId = 0
    private val wiseSayings = mutableListOf<WiseSaying>()
    fun run() {
        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val command = readln().trim()
            val cmdBits = command.split("?", limit = 2)
            val actionName = cmdBits[0]

            when (actionName) {
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
                "삭제" -> {
                    val id = parseId(cmdBits) ?: continue
                    val found = wiseSayings.find { it.id == id }
                    if(found != null) {
                        wiseSayings.remove(found)
                        println("${id}번 명언이 삭제되었습니다.")
                    }
                    else {
                        println("${id}번 명언은 존재하지 않습니다.")
                    }
                }
                "수정" -> {
                    val id = parseId(cmdBits) ?: continue
                    val found = wiseSayings.find {it.id == id}

                    if(found != null) {
                        val index = wiseSayings.indexOf(found)

                        println("명언(기존) : ${found.content}")
                        print("명언 : ")
                        val newContent = readln().trim()
                        println("작가(기존) : ${found.author}")
                        print("작가 : ")
                        val newAuthor = readln().trim()

                        val updated = found.copy(content = newContent, author = newAuthor)

                        wiseSayings[index] = updated
                    }
                    else {
                        println("${id}번 명언은 존재하지 않습니다.")
                    }
                }
            }
        }
    }

    private fun parseId(cmdBits: List<String>): Int? {
        if(cmdBits.size < 2) {
            println("올바른 id를 입력해주세요.")
            return null
        }

        val queryBit = cmdBits[1].split("=", limit = 2)
        val id = if (queryBit[0] == "id" && queryBit.size > 1) {
            queryBit[1].toIntOrNull()
        } else {
            null
        }

        if (id == null) {
            println("올바른 id를 입력해주세요. (예: 삭제?id=1)")
        }

        return id
    }
}