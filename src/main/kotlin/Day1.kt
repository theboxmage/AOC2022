class Day1: Day {
    private var foodList = arrayListOf<ArrayList<Int>>()
    val input = FileUtils.readFileAsLines("day1.txt")

    init {
        foodList.add(arrayListOf())

        for(i in input) {
            if(i.trim() == "") {
                foodList.add(arrayListOf())
            } else {
                foodList.last().add(i.toInt())
            }
        }
    }

    override fun part1() {
        println("Part 1: ${foodList.map{it.sum()}.max()}")
    }

    override fun part2() {
        println("Part 2: ${foodList.map{it.sum()}.sortedDescending().take(3).sum()}")
    }
}

