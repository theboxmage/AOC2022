import java.io.File

class Day1(var file: String) {
    private var foodList = arrayListOf<ArrayList<Int>>()

    init {
        val input = FileUtils.readFileAsLines(this.file);
        var count = 0
        foodList.add(arrayListOf())

        for(i in input) {
            if(i.trim() == "") {
                count++
                foodList.add(arrayListOf())
            } else {
                foodList.last().add(i.toInt())
            }
        }
    }

    fun part1() {
        println("Part 1: ${foodList.map{it.sum()}.max()}")
    }

    fun part2() {
        println("Part 2: ${foodList.map{it.sum()}.sortedDescending().take(3).sum()}")
    }
}

