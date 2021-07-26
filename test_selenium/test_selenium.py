# 导入包
from selenium import webdriver

brower = webdriver.Chrome()
url_str = "https://www.baidu.com"
brower.get(url=url_str)
# brower.refresh()
input_text=brower.find_element_by_id("kw")
input_text.send_keys("南开")

search_btn=brower.find_element_by_id("su")
search_btn.click()


