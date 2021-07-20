import requests
from bs4 import BeautifulSoup
from lxml import etree

import random
import time
import re

import os
import csv

# 模拟多个user-agent
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

# 随机获取 user-agent实现反反爬
request_headers = {
    'User-Agent': random.choice(user_agents)
}


def get_per_page_20_books_url(page_url):
    web_data = requests.get(page_url, headers=request_headers)
    status_code = web_data.status_code
    if status_code == 200:
        html_text = web_data.text
        soup_doc = BeautifulSoup(html_text, 'html.parser')
        book_review_homepages = soup_doc.select('div.main-bd > h2 > a')  # \31 3688389 > div > h2 > a
        # 遍历获取每一本图书的URL
        for book_review_homepage in book_review_homepages:
            # 获取href属性==图书主页
            book_review_homepage_href = book_review_homepage.get('href').strip()
            # 获取每本图书的所需信息
            print(book_review_homepage_href)
            get_book_review_info(book_review_homepage_href)
            # print(book_review_homepage_href)


def get_book_review_info(book_review_info_url):
    web_data = requests.get(book_review_info_url, headers=request_headers)
    status_code = web_data.status_code
    if status_code == 200:
        html_text = web_data.text

        # 使用lxml解析 text
        selector = etree.HTML(html_text)
        #// *[ @ id = "13688722"] / div / h2 / a
        # movie_title=selector.xpath('//*[@id="content"]/div/div[2]/div[3]/div[2]/a/text()')[0].strip()# //*[@id="13679856"]/header/a[2]
        comment_title = selector.xpath('//*[@id="content"]/div/div[1]/h1/span/text()')
        # author=selector.xpath('//header/a/span/text()')[0]  #//*[@id="13679856"]/header/a[1]/span
        content = selector.xpath('//div[@id="link-report"]//p/text()')
        print(comment_title, content)


if __name__ == "__main__":
    #
    urls = ['https://movie.douban.com/review/best/?start={}'.format(str(no)) for no in range(0, 2000, 20)]
    #
    for url in urls:
        # print(url)

       get_per_page_20_books_url(url)
       # get_book_review_info(url)