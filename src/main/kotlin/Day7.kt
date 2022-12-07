class Day7 : Day {
    private var map: MutableMap<String, Int> = mutableMapOf("/" to 0)
    private var currentDirectory: MutableList<String> = mutableListOf()
    private var item = FileUtils.readFileAsLines("day7.txt").map{it.split(" ")}

    override fun part1() {
        item.forEach{parse(it)}
        println("Part 1: ${map.filter { it.value <= 100000 }.toList().sumOf { it.second }}")
    }

    override fun part2() {
        println("Part 2: ${map.filter{it.value > 30000000-(70000000-map["/"]!!)}.toList().sortedBy { it.second }[0].second}")
    }

    private fun parse(input: List<String>) {
        if(input[0] == "$" && input[1] == "cd" ) {
            if(input[2] == "/" ) {
                currentDirectory = mutableListOf("/")
            } else if( input[2] == "..") {
                currentDirectory.removeLast()
            } else {
                currentDirectory.add(currentDirectory.last()+ "/" + input[2])
            }
        } else {
            if(input[0] == "dir") {
                    map[currentDirectory.last() + "/" + input[1]] = 0
            } else if(input[0].toIntOrNull() != null) {
                currentDirectory.forEach{ map[it] = map[it]!! + input[0].toInt() }
            }
        }
    }
}