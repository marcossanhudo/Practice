import sys

def Factorial(getFactorialOf):
	result = 1
	for multiplier in range(1, getFactorialOf + 1):
		result *= multiplier
	print(result)

Factorial(int(sys.argv[1]))