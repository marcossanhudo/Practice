package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	getFactorialOf, conversionError := strconv.Atoi(os.Args[1])
	if conversionError != nil {
		fmt.Println(conversionError)
		os.Exit(2)
	}

	var result int = 1

	for multiplier := 1; multiplier <= getFactorialOf; multiplier++ {
		result *= multiplier
	}

	fmt.Println(result)
}