vac_nums = [0,0,0,0,0,
            1,1,1,1,1,1,1,1,
            2,2,2,2,
            3,3,3
            ]

mean = sum(vac_nums) / len(vac_nums)

vac_Variance = [(num - mean)**2 for num in vac_nums]
mean_Variance = sum(vac_Variance) / len(vac_Variance)

print(mean_Variance)