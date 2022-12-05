'''
You are given an array that represents house prices.
Calculate and output the percentage of houses that 
are within one standard deviation from the mean.
'''

import numpy as np

data = np.array([150000, 125000, 320000, 540000, 200000, 120000, 160000, 
230000, 280000, 290000, 300000, 500000, 420000, 100000, 150000, 280000])

stdev = np.std(data)
mean = np.mean(data)

low_mean = mean - stdev
high_mean = mean + stdev

total = 0
for num in data:
    if low_mean < num < high_mean:
        total += 1

answer = (total / len(data)) * 100
print(answer)

