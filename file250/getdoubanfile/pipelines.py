# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter

import csv


class GetdoubanfilePipeline:
    def __init__(self):
        csv_fp = open('file250.csv', 'w', encoding='utf-8',newline="")
        csv_writer = csv.writer(csv_fp)
        csv_writer.writerow(('file_name', 'scroe', 'introduction'))
        self.post = csv_writer

    def process_item(self, item, spider):
        csv_write = self.post
        csv_write.writerow((item['film_name'], item['score'], item['introduction']))
        return item
