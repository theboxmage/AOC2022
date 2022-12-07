class Day7 : Day {
    private var item = FileUtils.readFileAsLines("day7.txt").map{it.split(" ")}
    private var map: MutableMap<String, Int> = mutableMapOf("/" to 0)
    private var currentDirectory: MutableList<String> = mutableListOf()
    override fun part1() {
        for(i in item) {
            parse(i)
        }
        println("Part 1: ${map.filter{it.value <= 100000}.toList().sumOf{it.second}}")
    }

    override fun part2() {
        println("Part 2: ${map.filter{it.value > 30000000-(70000000-map["/"]!!)}.toList().sortedBy { it.second }[0].second}")
    }

    private fun parse(input: List<String>) {
        if(input[0] == "$") {
            if(input[1] == "cd" && input[2] == "/" ) {
                currentDirectory = mutableListOf("/")
            } else if(input[1] == "cd" && input[2] == "..") {
                currentDirectory.removeLast()
            } else if(input[1] == "cd") {
                currentDirectory.add(currentDirectory.last()+ "/" + input[2])
            }
        } else {
            if(input[0] == "dir") {
                if(!map.containsKey(currentDirectory.last()+ "/" + input[1])) {
                    map[currentDirectory.last() + "/" + input[1]] = 0
                }
            } else {
                currentDirectory.forEach{ map[it] = map[it]!! + input[0].toInt() }
            }
        }
    }
}

