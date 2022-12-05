'''
Given the COVID data, find the day with maximum cases in a given month.
Take a month name as input and output the row that corresponds to the 
day with the maximum number of cases in that month.

You can filter the DataFrame for the given month first, and then select the row with the maximum cases.
Important: The output should be a DataFrame, which includes all the columns.
For example, for the month of February, the expected result would be:
'''

import pandas as pd

user_input = input()

df = pd.read_csv("/usercode/files/ca-covid.csv")

df.drop('state', axis=1, inplace=True)
df['date'] = pd.to_datetime(df['date'], format="%d.%m.%y")
df['month'] = df['date'].dt.month_name()
df.set_index('date', inplace=True)

df = df[df['month'] == user_input]

print(df[df['cases'] == df['cases'].max()])