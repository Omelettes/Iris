# coding:utf-8

from urllib import request
from bs4 import BeautifulSoup

url = "http://www.jianshu.com"
headers = {
'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.22 Safari/537.36 SE 2.X MetaSr 1.0'}
page = request.Request(url, headers=headers)
page_info = request.urlopen(page).read().decode('utf-8')

soup = BeautifulSoup(page_info, 'html.parser')

print(soup.prettify())

titles = soup.find_all('a', 'title')

with open(r"D:\work\workspace\resource\text\articles.txt", "w",encoding="utf-8") as file:

    for title in titles:
        file.write(title.string + '\n')
        file.write("http://www.jianshu.com" + title.get('href') + '\n\n')
