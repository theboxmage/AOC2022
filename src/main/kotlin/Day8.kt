class Day8 : Day {
    private val input =
        FileUtils.readFileAsLines("day8.txt").map { it.split("").map { i -> i.toIntOrNull() }.filterNotNull() }
    private val p = (input.size - 1) * 4

    override fun part1() {
        var count = p
        for(i in 1 until input.size-1) {
            for(j in 1 until input[0].size-1) {
                count += countVisibleFromExterior(j, i)
            }
        }
        println("Part 1: $count")
    }

    override fun part2() {
        var max = -1
        for(y in 0 until input.size) {
            for(x in 0 until input[y].size) {
                val curr = countVisibleFromNode(y, x)
                if(max < curr) {
                    max = curr
                }
            }
        }
        println("Part 2: $max")
    }

    private fun countVisibleFromExterior(x: Int, y: Int): Int {
        var count = 0
        if ((0 until x).all { input[y][x] > input[y][it] }) count = 1
        else if ((x+1 until input.size).all { input[y][x] > input[y][it] }) count = 1
        else if ((0 until y).all { input[y][x] > input[it][x] }) count = 1
        else if ((y+1 until input.size).all { input[y][x] > input[it][x] }) count = 1
        return count
    }

    private fun countVisibleFromNode(x: Int, y: Int): Int {
        val count = arrayOf(0, 0, 0, 0)
        for(i in x-1 downTo  0) {
            count[0]++
            if(input[y][x] <= input[y][i]) {
                break
            }
        }
        for(i in x+1 until  input.size) {
            count[1]++
            if(input[y][x] <= input[y][i]) {
                break
            }
        }
        for(i in y-1 downTo  0) {
            count[2]++
            if(input[y][x] <= input[i][x]) {
                break
            }
        }
        for(i in y+1 until  input[x].size) {
            count[3]++
            if(input[y][x] <= input[i][x]) {
                break
            }
        }
        val value = count[0]*count[1]*count[2]*count[3]
        return value
    }
}

