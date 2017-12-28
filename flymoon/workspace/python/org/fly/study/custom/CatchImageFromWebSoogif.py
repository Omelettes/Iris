# coding:utf-8

import base64
from pyDes import *
import requests
import os
import time


def hexString2bytes(src):
    ret = []
    for i in range(len(src) / 2):
        hd = int(src[i * 2:i * 2 + 1], 16)
        ld = int(src[i * 2 + 1:i * 2 + 2], 16)
        fd = (hd * 16 + ld) & 0xff
        ret.append(fd)
    return ret


def byte2hexString(byte_arr):
    ret = ''
    for i in range(len(byte_arr)):
        hx = hex(ord(byte_arr[i]))[2:]
        if len(hx) == 1:
            hx = '0' + hx
        ret += hx.upper()
    return ret


def des_ecb_decrypt(source, key):
    source = hexString2bytes(source)
    source = [chr(x) for x in source]
    des_obj = des(key.encode('utf-8'), ECB, IV=None, pad=None, padmode=PAD_PKCS5)
    des_result = des_obj.decrypt(source)
    return des_result


def des_ecb_encode(source, key):
    des_obj = des(key.encode('utf-8'), ECB, IV=None, pad=None, padmode=PAD_PKCS5)
    source = [chr(ord(x)) for x in source]
    des_result = des_obj.encrypt(source)
    return byte2hexString(des_result)


def getManyPages(keyword, size):
    requestUrls = []
    sizecount = 22
    for i in range(sizecount, sizecount + size*sizecount, sizecount):
        requestUrls.append(
            'http://www.soogif.com/material/query/?query=' + keyword + '&sortField=timestamp_0&start=' + str(
                i - sizecount) + '&size=' + str(sizecount))
    # url = 'http://www.soogif.com/material/query/?query=' + keyword + '&sortField=timestamp_0&start=0&size=' + str(size)
    # print(url)
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.22 Safari/537.36 SE 2.X MetaSr 1.0'}
    # jsonDatas = requests.get(url, headers=headers).json().get('data')
    # print(jsonDatas)
    imageUrls = []
    print(requestUrls)
    for url in requestUrls:
        jsonDatas = requests.get(url, headers=headers).json().get('data')
        for list in jsonDatas.get('list'):
            imageUrls.append(list.get('url'))

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
    keyword = '美女'
    urls = getManyPages(keyword, 10)
    print(urls)
    timeStr = time.strftime("%Y%m%d%H%M%S", time.localtime())
    savePath = "D:/work/workspace/resource/img/%s/%s/" % (keyword, timeStr)
    getImg(urls, savePath)  # 参数2:指定保存的路径
