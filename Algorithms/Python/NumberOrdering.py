def highest(array):
	highest = array[0]
	for check in array:
		if check > highest:
			highest = check
	print(highest)
	return highest

def lowest(array):
	lowest = array[0]
	for check in array:
		if check < lowest:
			lowest = check
	print(lowest)
	return lowest

def average(array):
	output = 0
	for element in array:
		output += int(element)
	output /= len(array)

array = input()
highest(array)
lowest(array)
average(array)