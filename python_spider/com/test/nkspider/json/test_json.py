# 导入内置的json包
import json
import requests

# 1 直接赋值，获取json string
json_str = '{"name": "zhangsan", ' \
           '"age": 20, ' \
           '"like": ["sing", "dance", "swim"],  ' \
           '"scores": {"chinese": 80, "math": 60, "english": 99} }'
print("JSON Str :{0}".format(json_str))

# 调用json.loads执行反序列化
json_str_data = json.loads(json_str)
print("JSON Data(var) : %s" % json_str_data)

# 获取json string 中数据的value值
print(json_str_data["name"], json_str_data["like"][2], json_str_data["scores"]["chinese"])

# 遍历 json_str_data
for key, value in json_str_data.items():
    print("Key :", key, "==> value:" , value)
    if type(value) == list:
        print("\t All ", key, "is ", end=":")
        for item in value:
            print(item, end=",")
        print()
    if type(value) == dict:
        print("\t All ", key, "is :")
        for k in value.keys():
            print("\t\t%s : %d" % (k, value[k]))

# 设置请求头参数
request_headers = {
    'User-Agent':
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36'
}

# 发送请求，获取响应
url = 'https://club.jd.com/comment/productPageComments.action?productId=100023014936&score=0&sortType=5&page=0&pageSize=10'
resp = requests.get(url=url, headers=request_headers)
if resp.status_code != 200:
    print("fail....")
    pass

# 获取响应内容，解码为中文编码
resp_json_str = resp.content.decode('gb18030')

# 反序列化
resp_json_data = json.loads(resp_json_str)

# 获取json data 中的数据value值
sku_id = resp_json_data["productCommentSummary"]["skuId"]
print(sku_id)
comments = resp_json_data["comments"]
for comment in comments:
    content = comment["content"]
    print(content)

# 遍历 resp_json_data
for key, value in resp_json_data.items():
    print("key: ", key, " ==> value: ", value)
    if type(value) == list:
        print("\tAll ", key, " is ", end=": ")
        for item in value:
            print(item, end=", ")
        print()
    if type(value) == dict:
        print("\tAll ", key, " is: ")
        for k in value.keys():
            print("\t\t{0} : {1}" .format(k, value[k]))

# 2-0. 声明变量
name = "hanmeimei"
age = 22
like = ("reading", "somking", "sleeping")
chinee_score = 10
math_score = 20
english_score = 30
scores = {"chinese": chinee_score, "math": math_score, "english": english_score}
student = {"name": name, "age": age, "like": like, "scores": scores}
# 2-1. 序列化为 string
student_json_str = json.dumps(student)
print(student_json_str)

# 2-2. 序列化为 file
with open('student.json', 'wt') as fp:
    json.dump(student, fp)

with open('student.json', 'rt') as fp:
    student_var = json.load(fp)
student_var["name"] = "lilei"
print(student_var)




