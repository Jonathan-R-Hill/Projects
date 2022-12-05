'''
You are given a dictionary that contains names and numbers of people.
You need to create a DataFrame from the dictionary and add an 
index to it, which should be the name values.
Then take a name from user input and output the row 
in the DataFrame, which corresponds to that row.
'''

import pandas as pd

data = {
   'name': ['James', 'Billy', 'Bob', 'Amy', 'Tom'],
   'number': ['1234', '5678', '2222', '1111', '0909']
}

df = pd.DataFrame(data, index= data["name"])
Name = input()

print(df.loc[Name])