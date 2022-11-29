import sys

def Fibonacci(iterationsToDo):
	previous = 0
	secondPrevious = 1

	for iteration in range(iterationsToDo):
		aux = previous
		previous += secondPrevious
		secondPrevious = aux
		print(previous, " ")

Fibonacci(int(sys.argv[1]))