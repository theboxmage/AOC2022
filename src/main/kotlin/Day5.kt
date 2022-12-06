class Day5(private val file: String) {
    private val inputList = FileUtils.readFileAsLines(this.file)
    private var stage: MutableList<MutableList<String>> = mutableListOf()
    private val size: Int = (inputList[0].length + 1) / 4
    private var linebreak = -1

    private fun start() {
        stage.clear()
        linebreak = inputList.indexOf("")
        for (i in 0 until size) {
            stage.add(mutableListOf())
        }
        for (i in 0..(linebreak - 2)) {
            for (column in 0 until size) {
                if (inputList[i][column * 4 + 1] != ' ') {
                    stage[column].add(inputList[i][column * 4 + 1].toString())
                }
            }
        }
    }

    fun part1() {
        start()
        for (i in linebreak + 1 until inputList.size) {
            val line = "\\d+".toRegex().findAll(inputList[i]).map { it.groupValues[0].toInt() }.toList()
            for (index in 0 until line[0]) {
                stage[line[2] - 1].add(0, stage[line[1] - 1].removeFirst())
            }
        }
        println("Part 1: ${stage.joinToString (""){ it[0]}}")
    }

    fun part2() {
        start()
        for (i in linebreak + 1 until inputList.size) {
            val line = "\\d+".toRegex().findAll(inputList[i]).map { it.groupValues[0].toInt() }.toList()
            for (index in line[0]-1 downTo 0) {
                stage[line[2] - 1].add(0, stage[line[1] - 1].removeAt(index))
            }
        }
        println("Part 2: ${stage.joinToString (""){ it[0]}}")
    }
}
