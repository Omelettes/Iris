# coding: utf-8

import numpy as np
from PIL import Image

if __name__ == '__main__':
    image_file = 'D:/work/workspace/resource/img/QQ图片20171013053025.jpg'
    height = 100
    img = Image.open(image_file)
    img_width, img_height = img.size
    width =  2 * height * img_width // img_height
    img = img.resize((width, height), Image.ANTIALIAS)
    pixels = np.array(img.convert('L'))

    print(pixels.shape)
    print(pixels)
    chars = 'MNHQ$oc?7>!:-.'
    N = len(chars)
    step = 256 // N
    print(N)
    result = ''
    for i in range(height):
        for j in range(width):
            result += chars[pixels[i][j] // step]
        result += '\n'
    with open('D:/work/workspace/resource/img/QQ图片20171013053025.txt', mode='w') as f:
        f.write(result)
