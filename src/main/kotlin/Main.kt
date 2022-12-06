fun main(args: Array<String>) {
    val days: Array<Day> = arrayOf(Day1(), Day2(), Day3(), Day4(), Day5(), Day6())

    if(args.isEmpty()){
        for (i in days.indices) {
            println("Day ${i + 1}")
            days[i].part1()
            days[i].part2()
            println()
        }
    } else if (args[0].toIntOrNull() != null && (days.indices).contains(args[0].toInt())) {
        val day = args[0].toInt()
        println("Day $day")
        days[day].part1()
        days[day].part2()
    } else {
        println("Day ${days.size}")
        days.last().part1()
        days.last().part2()
    }
}