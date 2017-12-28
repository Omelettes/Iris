# coding:utf-8

import requests
import os
import time


def getManyPages(keyword, pages):
    params = []
    for i in range(30, 30 * pages + 30, 30):
        params.append({
            'tn': 'resultjson_com',
            'ipn': 'rj',
            'ct': 201326592,
            'is': '',
            'fp': 'result',
            'queryWord': keyword,
            'cl': 2,
            'lm': -1,
            'ie': 'utf-8',
            'oe': 'utf-8',
            'adpicid': '',
            'st': -1,
            'z': '',
            'ic': 0,
            'word': keyword,
            's': '',
            'se': '',
            'tab': '',
            'width': '',
            'height': '',
            'face': 0,
            'istype': 2,
            'qc': '',
            'nc': 1,
            'fr': '',
            'pn': i,
            'rn': 30,
            'gsm': '1e',
            '1514334367281': ''
        })
    url = 'https://image.baidu.com/search/acjson'
    urls = []
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.22 Safari/537.36 SE 2.X MetaSr 1.0'}

    for i in params:
        urls.append(requests.get(url, params=i,headers=headers).json().get('data'))

    return urls


def getImg(dataList, localPath):
    if not os.path.exists(localPath):  # 新建文件夹
        os.makedirs(localPath)

    x = 0
    for list in dataList:
        for i in list:
            if i.get('thumbURL') != None:
                print('正在下载：%s' % i.get('thumbURL'))
                ir = requests.get(i.get('thumbURL'))
                open(localPath + '%d.jpg' % x, 'wb').write(ir.content)
                x += 1
            else:
                print('图片链接不存在')


if __name__ == '__main__':
    keyword = '美女头像'
    dataList = getManyPages(keyword, 10)  # 参数1:关键字，参数2:要下载的页数
    #print(dataList)
    timeStr=time.strftime("%Y%m%d%H%M%S",time.localtime())
    savePath="D:/work/workspace/resource/img/%s/%s/" % (keyword,timeStr )
    getImg(dataList, savePath)  # 参数2:指定保存的路径
