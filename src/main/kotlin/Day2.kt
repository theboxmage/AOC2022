class Day2(var file: String) {
    private val inputList: List<String> = FileUtils.readFileAsLines(this.file).map{"${it[0]+23} ${it[2]}"}
    private val letterScore = mapOf('X' to 1, 'Y' to 2, 'Z' to 3)
    private val winMap = mapOf('X' to 'Y', 'Y' to 'Z', 'Z' to 'X')
    private val loseMap = mapOf('X' to 'Z', 'Y' to 'X', 'Z' to 'Y')
    private val resultScore = mapOf('X' to 0, 'Y' to 3, 'Z' to 6)
    fun part1() {
        var score = 0
        for(i in inputList) {
            val temp = runGame(i[0], i[2])
            score += temp
        }
        println("Part 1: $score")
    }

    fun part2() {
        var score = 0
        for( i in inputList) {
            score += if(i[2] == 'Y') {
                letterScore[i[0]]!!
            } else if(i[2] == 'X') {
                letterScore[loseMap[i[0]]!!]!!
            } else {
                letterScore[winMap[i[0]]!!]!!
            }
            score += resultScore[i[2]]!!
        }
        println("Part 2: $score")
    }

    private fun runGame(opponent: Char, player: Char): Int {
        var winValue = 0;
        if(opponent == player) {
            winValue = 3
        } else if (winMap[opponent] == player) {
            winValue = 6
        }
        return letterScore[player]!! + winValue
    }
}