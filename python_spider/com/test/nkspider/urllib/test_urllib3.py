# urllib3是外部模块，需要安装，pip install urllib3
# 给当前程序添加urllib3的能力
import urllib3

# 获取url
url_str = "https://baidu.com/index.html"

# 做浏览器准备,设置user-agant
request_headers = {
    'User-Agent':
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36'
}

# 设置连接的超时时间，借助连接管理器池，创建http的连接，并设置连接的超时时间（没有必要）
http = urllib3.PoolManager(timeout=urllib3.Timeout(connect=1.0, read=5.0))
# http = urllib3.PoolManager(timeout=5)


# 发送消息
resp = http.request(method='GET', url=url_str, headers=request_headers)

# 获得响应和处理响应
status_code = resp.status
resp_headers = resp.headers
html_text = resp.data.decode('utf-8')

print(status_code)
print(resp_headers)
