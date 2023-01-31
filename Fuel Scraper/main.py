from datetime import datetime
import requests_html

url = 'https://localprices.co.uk/pricelists/stockton-on-tees/fuel-prices/unleaded/No?keyword_string=&sort_by=1'
session = requests_html.HTMLSession()
now = datetime.now()
time = now.strftime("%d-%m-%Y, %H:%M")

r = session.get(url)
r.html.render(sleep=3, timeout=8)

# for item in r.html.xpath('''//*[@id="products"]/div/div/div[2]/div/div[1]/div'''):
#     print(item.text)

price = r.html.xpath('//*[@id="products"]/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div/div[1]/div[1]/h2[2]')
for item in price:
    with open("Fuel.txt", 'a') as f:
        f.write(f"{item.text} - {time}\n")
    print(item.text)
    print(time)
