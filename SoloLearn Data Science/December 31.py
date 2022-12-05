'''
You are working with the 'ca-covid' CSV file that contains 
the COVID-19 infection data in California for the year 2020.
The file provides data on daily cases and deaths for the entire year.
Find and output the row that corresponds to December 31, 2020.
'''

import pandas as pd

df = pd.read_csv("/usercode/files/ca-covid.csv")
df.set_index('date', inplace=True)
df.drop('state', axis=1, inplace=True)

print(df.iloc[-1])