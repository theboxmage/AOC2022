class Day4(private val file: String) {
    private val inputList = FileUtils.readFileAsLines(this.file)
        .map { Regex("\\d+").findAll(it).toList().map { i -> i.groupValues[0].toInt() } }
        .map { Pair(it[0]..it[1], it[2]..it[3]) }

    fun part1() {
        var count = 0
        for (i in inputList) {
            if (i.first.contains(i.second.first) && i.first.contains(i.second.last)) {
                count += 1
            } else if (i.second.contains(i.first.first) && i.second.contains(i.first.last)) {
                count += 1
            }
        }
        println("Part 1: $count")
    }

    fun part2() {
        var count = 0
        for (i in inputList) {
            if (i.first.contains(i.second.first) || i.first.contains(i.second.last)) {
                count += 1
            } else if (i.second.contains(i.first.first) || i.second.contains(i.first.last)) {
                count += 1
            }
        }
        println("Part 2: $count")
    }
}
