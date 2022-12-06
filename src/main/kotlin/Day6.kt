class Day6(file: String) {
    private var item = FileUtils.readFileAsLines(file)[0]

    fun part1() {
        println("Part 1: ${findDistinctIndex(4)}")
    }

    fun part2() {
        println("Part 2: ${findDistinctIndex(14)}")
    }

    private fun findDistinctIndex(size: Int): Int {
        for(i in 0 until item.length-size) {
            if(item.substring(i, i+size).toSet().count() == size) {
                return i+size
            }
        }
        return -1
    }
}

