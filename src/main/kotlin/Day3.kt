class Day3(private val file: String) {
    private val inputList: List<String> = FileUtils.readFileAsLines(this.file)

    fun part1() {
        var count = 0
        inputList.map { Pair(it.substring(0, it.length / 2), it.substring(it.length / 2)) }.forEach {
            val firstCharMap: MutableMap<Char, Int> = mutableMapOf()
            val secondCharMap: MutableMap<Char, Int> = mutableMapOf()
            for (i in 0 until it.first.length) {
                firstCharMap[it.first[i]] = convertToScore(it.first[i])
                secondCharMap[it.second[i]] = convertToScore(it.second[i])
            }
            firstCharMap.filter { secondCharMap.containsKey(it.key) }.forEach {
                count += it.value
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
