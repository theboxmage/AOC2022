class Day6 : Day {
    private var item = FileUtils.readFileAsLines("day6.txt")[0]

    override fun part1() {
        println("Part 1: ${findDistinctIndex(4)}")
    }

    override fun part2() {
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

