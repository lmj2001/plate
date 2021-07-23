import scrapy

from getdoubanfile.items import FilmItem


class Film250Spider(scrapy.Spider):
    name = 'film250'
    allowed_domains = ['www.douban.com']
    start_urls = ['https://movie.douban.com/top250?start={}&filter='.format(str(i)) for i in range(0, 250, 25)]

    def parse(self, response):
        film_itme = FilmItem()
        # cssselector = response.css
        # cssselector()
        for item in response.css('div.item'):
            film_name = item.css("div.info > div.hd > a > span.title::text").extract_first(),
            score = item.css(" div.info > div.bd > div > span.rating_num::text").extract(),
            introduction = item.css("div.info div.bd p.quote span.inq::text").extract(),
            film_itme['film_name'] = film_name
            film_itme['score'] = score
            film_itme['introduction'] = introduction
            yield film_itme
    pass
