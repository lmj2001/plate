# https://search.jd.com/Search?keyword=%E8%8B%B9%E6%9E%9C%E6%89%8B%E6%9C%BA&qrst=1&wq=%E8%8B%B9%E6%9E%9C%E6%89%8B%E6%9C%BA&ev=exbrand_Apple%5E&pvid=e9a959c7178441e895e6a740701ae615&page=1&s=1&click=0

# 导包
import requests

import random
import time
import re

import os
import csv

## 模拟多个user-agent
from bs4 import BeautifulSoup

user_agents = [
    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; AcooBrowser; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.0.04506)",
    "Mozilla/4.0 (compatible; MSIE 7.0; AOL 9.5; AOLBuild 4337.35; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
    "Mozilla/5.0 (Windows; U; MSIE 9.0; Windows NT 9.0; en-US)",
    "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)",
    "Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 1.0.3705; .NET CLR 1.1.4322)",
    "Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 5.2; .NET CLR 1.1.4322; .NET CLR 2.0.50727; InfoPath.2; .NET CLR 3.0.04506.30)",
    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN) AppleWebKit/523.15 (KHTML, like Gecko, Safari/419.3) Arora/0.3 (Change: 287 c9dfb30)",
    "Mozilla/5.0 (X11; U; Linux; en-US) AppleWebKit/527+ (KHTML, like Gecko, Safari/419.3) Arora/0.6",
    "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.2pre) Gecko/20070215 K-Ninja/2.1.1",
    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9) Gecko/20080705 Firefox/3.0 Kapiko/3.0",
    "Mozilla/5.0 (X11; Linux i686; U;) Gecko/20070322 Kazehakase/0.4.5",
    "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.8) Gecko Fedora/1.9.0.8-1.fc10 Kazehakase/0.5.6",
    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.20 (KHTML, like Gecko) Chrome/19.0.1036.7 Safari/535.20",
    "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52",
]

# 随机获取user-agent来实现反爬操作
request_headers = {
    'User-Agent': random.choice(user_agents)
}

# 指定csv文件的保存位置

file_name = os.getcwd() + os.sep + 'apple.csv'
print(file_name)
# 获取文件指针,指明字符集，保证支持中文
fp = open(file_name, 'wt', newline='', encoding='utf-8-sig')  # 多字节utf编码
# 获取csv指针
csv_writer = csv.writer(fp)


# 在图书主页（详情页）中完成基于Xpath的解析、定位和提取
def get_book_info(book_homepage_url):
    request_headers = {
        'User-Agent': random.choice(user_agents)
    }
    web_data = requests.get(url=book_homepage_url, headers=request_headers)
    status_code = web_data.status_code
    if status_code == 200:
        soup = BeautifulSoup(web_data.text, "lxml")
        prices = soup.select("div.p-price > strong > i")
        typies = soup.select("div.p-name.p-name-type-2 > a > em")
        for price, type in zip(prices, typies):
            p=price.get_text().strip()
            t=type.get_text().strip()
            csv_writer.writerow((t,p))
            print(t,p)

# 设置程序入口，声明主方法
if __name__ == '__main__':
    # 设置，写入csv文件的标题行
    csv_header = ('型号', '价格')
    csv_writer.writerow(csv_header)
    # 声明或者创建top250所有页面
    urls = [
        'https://search.jd.com/search?keyword=%E8%8B%B9%E6%9E%9C%E6%89%8B%E6%9C%BA&qrst=1&wq=%E8%8B%B9%E6%9E%9C%E6%89%8B%E6%9C%BA&ev=exbrand_Apple%5E&pvid=0905278073314a33b6bdcf742aea788e&cid3=655&cid2=653&page={}&s=56&click=0'
            .format(str(no)) for no in range(1, 50)]
    # 遍历top250的每一张页面（都包含250本书的概要信息,均包含25本每一本书的详情页的url）
    for url in urls:
        # 定义一个方法，解析定位并且提取改url（概要信息的页面）中的每一本书的url，25本图书主页的url
        get_book_info(url)
        # print(url)
    # 关闭文件指针
    fp.close()
    print("end.....")
