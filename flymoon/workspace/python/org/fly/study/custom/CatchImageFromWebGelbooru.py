# coding:utf-8

import base64
from pyDes import *
import requests
import os
import time
from bs4 import BeautifulSoup
import re


def getManyPages(keyword, size):
    requestUrls = []
    sizecount = 42
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.22 Safari/537.36 SE 2.X MetaSr 1.0'}

    restr = "[a-zA-z]+://simg3.gelbooru.com//images[^\s]*"
    imageCompile = re.compile(restr)
    for i in range(0, sizecount + (size - 1) * sizecount, sizecount):
        requestUrls.append(
            'https://gelbooru.com/index.php?page=post&s=list&tags=%s&pid=%d' % (keyword, sizecount))

    imageIds = []
    imageUrls = []
    for url in requestUrls:
        page_info = requests.get(url, headers=headers).text
        soup = BeautifulSoup(page_info, 'html.parser')
        # print(soup.prettify())
        for item in soup.find_all("span", "thumb"):
            imageIds.append(item.get("id").strip('s').strip())

    print("找到" + str(len(imageIds)) + "个图片")
    for imageId in imageIds:
        urlImage = "https://gelbooru.com/index.php?page=post&s=view&id=%s" % imageId
        page_info = requests.get(urlImage, headers=headers).text
        imageUrls.append(imageCompile.search(page_info).group().strip('"'))

    return imageUrls


def getImg(urls, localPath):
    if not os.path.exists(localPath):  # 新建文件夹
        os.makedirs(localPath)

    x = 0
    for url in urls:
        if (url != None):
            print('正在下载：%s' % url)
            extstr = url[url.rfind('.'):]
            if (extstr == None or len(extstr.strip()) < 2):
                extstr = '.jpg'

            ir = requests.get(url)
            open(localPath + '%d%s' % (x, extstr), 'wb').write(ir.content)
            x += 1
            print('已下载：%d' % x)
        else:
            print('图片链接不存在')


if __name__ == '__main__':
    keyword = 'tentacle'
    size=30

    imageUrls = getManyPages(keyword,size)
    # print(urls)
    timeStr = time.strftime("%Y%m%d%H%M%S", time.localtime())
    savePath = "D:/work/workspace/resource/img/%s/%s/" % (keyword, timeStr)
    getImg(imageUrls, savePath)  # 参数2:指定保存的路径
