package day1

import java.nio.file.Files
import java.nio.file.Path

fun main() {
    println("Advent of Code 2022 - Day 1")

    // read input data from file line by line
    val path = Path.of("src\\main\\kotlin\\day1\\input.txt")
    val lines = Files.readAllLines(path)

    // use map to separate elves into unique entities
    val mapOfElves = HashMap<Int, Int>()

    // unique id
    var elfCount = 0

    // change id on empty lines; calculate sum of calories for each elf
    for (line in lines) {
        if (line.isEmpty()) {
            elfCount++
        }
        else {
            if (mapOfElves.containsKey(elfCount)) {
                val previousValue = mapOfElves.getValue(elfCount)
                mapOfElves.put(elfCount, previousValue + Integer.parseInt(line));
            }
            else {
                mapOfElves.put(elfCount, Integer.parseInt(line));
            }
        }
    }

    // values of map in asc order
    val sortedCalories = mapOfElves.values.sorted()
    println("The most calories: " + sortedCalories.last())

    // grab top three elves
    var sum = 0
    for (i in 1..3) {
        var n = sortedCalories[sortedCalories.size - i];
        sum += n;
    }

    println("Sum of top three calories: $sum");
}