'''
You continue working with the COVID dataset for California.
Now, add the weekday names for each row as a new column, named 'weekday'.
Then, output the last 7 days data of the dataset.
Do not set any index on the DataFrame.
'''

import pandas as pd
import datetime as dt
df = pd.read_csv("/usercode/files/ca-covid.csv")

df.drop('state', axis=1, inplace=True)
df['date'] = pd.to_datetime(df['date'], format="%d.%m.%y")

df['weekday'] = (df['date']).dt.strftime("%A")

print(df.tail(7))