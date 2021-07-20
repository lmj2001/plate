## 导入包 ，给程序添加requests支持
import requests

## 设置请求头，给出user-agent
request_headers = {
    'User-Agent':
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36',
    'Referer': 'https://douban.com',  # 表示从哪个网站来的
    'Connection': 'keep-alive'
}

## 给出url资源字符串，给出uri资源描述
url_str = "https://baidu.com"

## 借助requests发送请求，获得响应
resp = requests.get(url=url_str, headers=request_headers)

# 处理响应
status_code = resp.status_code

if (status_code == 200):
    print('success.......')
    try:
        html_text = resp.text  # 获取页面的源代码
        print(html_text)
    except ConnectionError:
        print("Connect error")
else:
    print("error......")
