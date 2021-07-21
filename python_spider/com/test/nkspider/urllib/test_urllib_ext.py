## 导入包
import urllib.request

# 知识指定浏览器的程序里面设置 user-agant ，request header 请求头中
request_headers = {
    'User-Agent':
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36',
    'Referer': 'https://douban.com',  # 表示从哪个网站来的
    'Connection': 'keep-alive'
}

# 指定url
url = "http://baidu.com"

# 封装请求对象，设置请求参数
request = urllib.request.Request(url=url, headers=request_headers)

# 发送请求，获得响应
response = urllib.request.urlopen(request)

# 获取并且解析处理响应的相关信息
# 获取响应的状态码
status_code = response.getcode()
# 获取请求地址
request_address = response.geturl()
# 获取响应信息，本质上就是响应头
request_info = response.info()

# 获取html源代码
html_text = response.read().decode('utf-8')

## 打印
print(status_code)
print(request_address)
print(request_info)
print(html_text)
