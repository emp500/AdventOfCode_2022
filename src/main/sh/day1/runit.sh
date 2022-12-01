#!/bin/bash
echo "Biggest amount of calories: "
cat input.txt | paste -sd+ | sed "s/++/\n/g" | bc | sort -n | tail -n 1
echo "Top three calories summed up: "
cat input.txt | paste -sd+ | sed "s/++/\n/g" | bc | sort -n | tail -n 3 | paste -sd+ | bc
