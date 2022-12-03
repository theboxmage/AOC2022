class Day3(private val file: String) {
    private val inputList: List<String> = FileUtils.readFileAsLines(this.file)

    fun part1() {
        var count = 0
        inputList.map { Pair(it.substring(0, it.length / 2), it.substring(it.length / 2)) }.forEach {
            it.first.split("").intersect((it.second.split("").toSet())).filter{it != ""}.forEach {
                count += convertToScore(it[0])
            }
        }
        println("Part 1: $count")
    }

    fun part2() {
        var count = 0
        for (i in inputList.indices step 3) {
            val temp = inputList[i].split("").intersect(inputList[i+1].split("").toSet()).intersect(inputList[i+2].split("").toSet()).filter{it != ""}
            temp.forEach { count += convertToScore(it[0]) }
        }
        println("Part 2: $count")
    }

    fun convertToScore(it: Char): Int {
        return if (it > 'Z') {
            it.code - 96
        } else {
            it.code - 38
        }
    }
}
