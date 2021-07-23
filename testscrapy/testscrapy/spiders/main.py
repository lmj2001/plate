# 导入scrapy命令行
from scrapy import cmdline

cmd_name = "testspider -o douban.csv"
cmd_line_str = "scrapy crawl {0}".format(cmd_name)
cmdline.execute(cmd_line_str.split())