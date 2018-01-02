# coding:utf-8

import base64
from pyDes import *
import requests
import os
import time
from bs4 import BeautifulSoup
import re

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.22 Safari/537.36 SE 2.X MetaSr 1.0'}


def getManyPages(keyword, startsize, size, localPath):
    requestUrls = []
    sizecount = 42

    restr = "[a-zA-z]+://simg3.gelbooru.com//images[^\s]*"
    imageCompile = re.compile(restr)
    for i in range(startsize * sizecount, sizecount + (size - 1 + startsize) * sizecount, sizecount):
        requestUrls.append(
            'https://gelbooru.com/index.php?page=post&s=list&tags=%s&pid=%d' % (keyword, i))

    imageIds = []
    imageUrls = []
    for url in requestUrls:
        page_info = requests.get(url, headers=headers).text
        soup = BeautifulSoup(page_info, 'html.parser')
        # print(soup.prettify())
        for item in soup.find_all("span", "thumb"):
            imageIds.append(item.get("id").strip('s').strip())

    print("找到" + str(len(imageIds)) + "个图片")

    if not os.path.exists(localPath):  # 新建文件夹
        os.makedirs(localPath)

    index = 0
    for imageId in imageIds:
        try:
            urlImage = "https://gelbooru.com/index.php?page=post&s=view&id=%s" % imageId
            page_info = requests.get(urlImage, headers=headers).text
            imageurl = imageCompile.search(page_info).group().strip('"')
            getImg(imageurl, savePath, index)
        except Exception as e:
            print("出错:" + imageId)
            print(e)

        index += 1
        # print("已装载" + str(len(imageUrls)) + "个图片")

    return imageUrls


def getImg(url, localPath, index):
    # for url in urls:
    if (url != None):
        print('正在下载：%s' % url)
        extstr = url[url.rfind('.'):]
        if (extstr == None or len(extstr.strip()) < 2):
            extstr = '.jpg'

        ir = requests.get(url, headers=headers)
        open(localPath + '%d%s' % (index, extstr), 'wb').write(ir.content)

        print('已下载：%d' % index)
    else:
        print('图片链接不存在')


if __name__ == '__main__':
    keyword = 'tentacles'
    startsize = 0
    size = 20

    # print(urls)
    timeStr = time.strftime("%Y%m%d%H%M%S", time.localtime())
    savePath = "D:/work/workspace/resource/img/%s/%s/" % (keyword, timeStr)
    imageUrls = getManyPages(keyword, startsize, size, savePath)
    # getImg(imageUrls, savePath)  # 参数2:指定保存的路径
