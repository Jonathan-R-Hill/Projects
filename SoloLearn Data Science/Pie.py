import pandas as pd
from matplotlib import *
import matplotlib.pyplot as plt

data = {
    'sport': ["Soccer", "Tennis", "Soccer", "Hockey"],
    'players': [5, 4, 8, 20]
}
df = pd.DataFrame(data)
pie = df.groupby('sport')['players'].sum().plot(kind="pie")

pie.plot()
plt.show()