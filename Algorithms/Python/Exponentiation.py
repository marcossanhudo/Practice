import sys

def Exponentiation(base, exponent):
	base = float(base)
	exponent = float(exponent)
	result = 1

	intExponent = int(exponent - (exponent % 1))	

	if exponent > 0:
		for iteration in range(0, intExponent):
			result *= base
	elif exponent < 0:
		for iteration in range(0, intExponent):
			result /= base

	print(result)

Exponentiation(sys.argv[1], sys.argv[2])