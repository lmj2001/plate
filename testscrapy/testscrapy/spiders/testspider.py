import scrapy


class testspider(scrapy.Spider):
    # 项目名称
    name = "testspider"
    request_headers = {
        'user-agent':
            'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36'
    }
    # 待爬取的url list
    start_urls = ["https://movie.douban.com/top250"]

    # 需要在代码中封装请求头参数，需要重写请求发送的方法，实现请求的发送
    def start_requests(self):
        for url in self.start_urls:
            yield scrapy.Request(url=url, callback=self.parse, headers=self.request_headers)

    # 必须重写的方法，定位和提取
    def parse(self, response):
        # 对response 进行提取和定位
        # cssselector = response.css
        # cssselector()
        for item in response.css('div.item'):
            yield {
                "file_name": item.css("div.info > div.hd > a > span.title::text").extract_first(),
                "score": item.css(" div.info > div.bd > div > span.rating_num::text").extract(),
                "introduction": item.css("div.info div.bd p.quote span.inq::text").extract()
            }
        next_url = response.css('div.paginator span.next a::attr(href)').extract()
        if next_url:
            next_url = "https://movie.douban.com/top250" + next_url[0]
            print(next_url)
            yield scrapy.Request(next_url, headers=self.request_headers)
