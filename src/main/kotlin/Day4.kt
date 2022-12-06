class Day4 : Day {
    private val inputList = FileUtils.readFileAsLines("day4.txt")
        .map { Regex("\\d+").findAll(it).toList().map { i -> i.groupValues[0].toInt() } }
        .map { Pair(it[0]..it[1], it[2]..it[3]) }

    override fun part1() {
        println("Part 1: ${inputList
            .sumOf{if(checkRanges(it.first, it.second) == 2 || checkRanges(it.second, it.first) == 2) 1L else 0}}")
    }

    override fun part2() {
        println("Part 2: ${inputList
            .sumOf{if(checkRanges(it.first, it.second) > 0 || checkRanges(it.second, it.first) > 0) 1L else  0}}")
    }

    private fun checkRanges(r1: IntRange, r2: IntRange): Int {
        return r1.contains(r2.first).toInt() + r1.contains(r2.last).toInt()
    }

    fun Boolean.toInt() = if (this) 1 else 0
}