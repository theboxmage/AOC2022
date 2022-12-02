class Day2(private val file: String) {
    private val inputList: List<String> = FileUtils.readFileAsLines(this.file).map{"${it[0]+23} ${it[2]}"}
    private val letterScore = mapOf('X' to 1, 'Y' to 2, 'Z' to 3)
    private val winMap = mapOf('X' to Pair('Y', 'Z'), 'Y' to Pair('Z', 'X'), 'Z' to Pair('X', 'Y'))
    private val resultScore = mapOf('X' to 0, 'Y' to 3, 'Z' to 6)
    fun part1() {
        println("Part 1: ${inputList.sumOf{runGame(it[0], it[2])}}")
    }

    fun part2() {
        println("Part 2: ${inputList.sumOf{runGamePart2(it[0], it[2])}}")
    }

    private fun runGame(opponent: Char, player: Char): Int {
        return (if(opponent == player) {
            3
        } else if (winMap[opponent]!!.first == player) {
            6
        } else {
            0
        }) + letterScore[player]!!
    }

    private fun runGamePart2(opponent: Char, player: Char): Int {
        return (if(player == 'Y') {
            letterScore[opponent]!!
        } else if(player == 'X') {
            letterScore[winMap[opponent]!!.second]!!
        } else {
            letterScore[winMap[opponent]!!.first]!!
        }) + resultScore[player]!!
    }
}