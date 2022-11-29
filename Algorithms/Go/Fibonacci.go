package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	iterationsToDo, conversionError := strconv.Atoi(os.Args[1])
	if conversionError != nil {
		fmt.Println(conversionError)
		os.Exit(2)
	}

	var previous int = 0
	var secondPrevious int = 1

	for iteration := 0; iteration < iterationsToDo; iteration++ {
		var aux int = previous
		previous = previous + secondPrevious
		secondPrevious = aux
		fmt.Print(previous, " ")
	}
}