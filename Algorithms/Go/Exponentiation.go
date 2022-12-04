package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	base, _ := strconv.ParseFloat(os.Args[1], 0)
	exponent, _ := strconv.ParseFloat(os.Args[2], 0)
	var result float64 = 1

	var iteration float64 = 0
	if exponent > 0 {
		for ; iteration < exponent; iteration++ {
			result *= base
		}
	} else if exponent < 0 {
		for ; iteration > exponent; iteration-- {
			result /= base
		}
	}

	fmt.Println(result)
}