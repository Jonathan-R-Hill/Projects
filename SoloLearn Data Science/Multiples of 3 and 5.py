'''
You are given a task to find all of the whole numbers below 100 
that are multiples of both 3 and 5.
Create an array of numbers below 100 that are multiples of both 3 and 5, 
and output it.
'''

import numpy as np

numbers = list(range(1, 101))

multiples = np.array([num for num in numbers if num % 3 == 0 and num % 5 == 0])

print(multiples)