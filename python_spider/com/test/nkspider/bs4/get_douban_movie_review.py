## 导入包
import requests
from bs4 import BeautifulSoup
import xml

## 设置请求头，给出user-agent
request_headers = {
    'User-Agent':
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36',
    'Referer': 'https://douban.com',  # 表示从哪个网站来的
    'Connection': 'keep-alive'
}

# 1.指定url
url_str = "https://movie.douban.com/review/best/"

# 发送请求获得响应
resp = requests.get(url=url_str, headers=request_headers)

# 获取源代码
status_code = resp.status_code
if status_code == 200:
    html_text = resp.text

# 解析html的源代码，放入bs4的对象中（生成、获取一个soup文档）
# soup=BeautifulSoup(html_text,"html.parser") # 使用内置的解析器解析生成soup
soup = BeautifulSoup(html_text, "lxml")  # 使用lxml解析生成soup

# 定位,借助选择器
# 根据标签名和属性名定位
# author_name_element = soup.find(name='a', href ='"https://www.douban.com/people/184234641/')
# author_name_element = soup.find(name='a', class_='name')
# author_info_element = soup.find(name='header', class_='main-hd')

# 利用css选择器
# author_info_element=soup.select("header.main-hd")

# 所有作者信息
author_info_elements = soup.select('a.name')

# 所有电影的信息
movie_info_elements = soup.select('a.subject-img')

# 提取作者的名字、作者的主页、电影图片的地址、电影名称
# 遍历 -python
for author_info_element in author_info_elements:
    # 提取标签元素的文本，提取标签属性的值
    author_name = author_info_element.get_text().strip()  # 截断前后的空格
    # 提取属性的值
    author_homepage = author_info_element.get("href")
    print(author_name, author_homepage)

# 遍历一次性提取：作者名字、作者主页、电影名字、电影主页、电影封面图片的源文件
for author_info_element, movie_info_element in  zip (author_info_elements, movie_info_elements):
    # 定位电影图片标签元素
    movie_info_img_element = movie_info_element.find(name='img')
    # 依次提取
    author_name = author_info_element.get_text().strip()  # 截断前后的空格
    author_homepage = author_info_element.get("href")
    movie_name = movie_info_img_element.get("title")
    movie_homepage = movie_info_element.get("href")
    movie_cover_img = movie_info_img_element.get("src")
    # 生成一个字典对象，整体放入提取的信息
    movie_review_info = {
        'author_name': author_name,
        'author_homepage': author_homepage,
        'movie_name': movie_name,
        'movie_homepage': movie_homepage,
        'movie_cover_img': movie_cover_img
    }
    print(movie_review_info)
