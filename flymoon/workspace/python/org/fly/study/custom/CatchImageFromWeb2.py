# coding:utf-8

from urllib import request
from bs4 import BeautifulSoup
import re
import time

url="https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1514334232158_R&pv=&ic=0&nc=1&z=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&ctd=1514334232159%5E00_469X569&word=%E7%BE%8E%E5%A5%B3"
html=request.urlopen(url).read().decode("utf-8")
soup=BeautifulSoup(html,'html.parser')

print(soup.prettify())

links=soup.find_all('img',"origin_image zh-lightbox-thumb",src=re.compile(r'.jpg$'))
print(links)

path=r'D:\work\workspace\resource\img'

for link in links:
    print(link.attrs['src'])
    request.urlretrieve(link.attrs['src'],path+'\%s.jpg' % time.time())