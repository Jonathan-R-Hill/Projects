"""The given code includes a list of heights for various basketball players.
You need to calculate and output how many players are in the 
range of one standard deviation from the mean.
"""


from math import sqrt
players = [180, 172, 178, 185, 190, 195, 192, 200, 210, 190]

mean = sum(players) / len(players)

# varience calc
player_varience = [(num - mean)**2 for num in players]
mean_varience = sum(player_varience) / len(player_varience)
mean_var_sq = sqrt(mean_varience)


mean_low = mean - mean_var_sq
mean_high = mean + mean_var_sq

total_in_var = 0
for num in players:
    if mean_low <= num <= mean_high:
        total_in_var += 1

print(total_in_var)