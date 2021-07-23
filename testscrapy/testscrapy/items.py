# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy

# 类名随意修改
class DoubanFileItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    film_name = scrapy.Field()
    score = scrapy.Field()
    introduction = scrapy.Field()
    pass
