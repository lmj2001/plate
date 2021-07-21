# 导包
import requests
from bs4 import BeautifulSoup
import lxml
import time

## 设置请求头，给出user-agent
request_headers = {
    'User-Agent':
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36',
    'Referer': 'https://douban.com',  # 表示从哪个网站来的
    'Connection': 'keep-alive'
}


# 实现具体某个页面的爬取
def get_info(page_url):
    # 发送请求，获取响应
    resp = requests.get(url=page_url, headers=request_headers)
    html_text = resp.text
    # 转化为bs4中的soup文档
    soup_documnet = BeautifulSoup(html_text, 'lxml')
    # 基于soup文档的定位和提取
    ranks = soup_documnet.select('span.pc_temp_num')  # 所有的序号
    titles = soup_documnet.select('div.pc_temp_songlist > ul > li > a')  # 所有的歌手和歌名
    times = soup_documnet.select(" span.pc_temp_tips_r > span")  # 所有的播放时长
    # 遍历提取
    for rank, title, time in zip(ranks, titles, times):
        if '-' in title.get_text() :
            data = {
                'rank': rank.get_text().strip(),
                'singer': title.get_text().split('-')[0].strip(),
                'song': title.get_text().split('-')[1].strip(),
                'time': time.get_text().strip()
            }
            print(data)

## 声明main 方法
if __name__ == "__main__":
    # 生成所有的urls
    urls = ["https://www.kugou.com/yy/rank/home/{}-8888.html".format(str(i)) for i in range(1, 24)]
    # 遍历每一个url，完成数据的爬取
    for url in urls:
        # 调用方法，完成某个页面url的爬取
        get_info(url)
        time.sleep(1)  # 暂停1s，可以用随机数来做，上网搜，建议使用随机数
    print("end.....")
