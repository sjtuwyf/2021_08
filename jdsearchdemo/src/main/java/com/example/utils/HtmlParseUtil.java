package com.example.utils;

import com.example.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/28
 */
public class HtmlParseUtil {
    public static void main(String[] args) throws IOException {
        List<Content> java = new HtmlParseUtil().parseJD("毛泽东");
        for (Content content : java) {
            System.out.println(content);
        }


    }

    public List<Content> parseJD(String keywords) throws IOException {
        String url ="https://search.jd.com/Search?keyword="+keywords+"&enc=utf-8";

        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
//        System.out.println(element.html());

        ArrayList<Content> goodsList = new ArrayList<>();

        Elements elements = element.getElementsByTag("li");
        for (Element el : elements) {
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();

            Content content = new Content(title, img, price);
            goodsList.add(content);


        }
        return goodsList;
    }
}
