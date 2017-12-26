package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy {
    //    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        /*try {
            Document doc = Jsoup.connect(URL_FORMAT).userAgent("Mozilla/5.0 (jsoup)").referrer(URL_FORMAT).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }*/

        List<Vacancy> vacancyList = new ArrayList<>();
        int pageNum = 0;
        while (true) {
            try {
                Document doc = getDocument(searchString, pageNum);
                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() == 0) break;

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.select("a[data-qa=\"vacancy-serp__vacancy-title\"]").text());

                    vacancy.setCity(element.select("span[data-qa=\"vacancy-serp__vacancy-address\"]").text());

                    vacancy.setCompanyName(element.select("a[data-qa=\"vacancy-serp__vacancy-employer\"]").text());

                    vacancy.setSiteName(URL_FORMAT);

                    vacancy.setUrl(element.select("a[data-qa=\"vacancy-serp__vacancy-title\"]").attr("href"));

                    String salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                    if (salary != null) vacancy.setSalary(salary);
                    else vacancy.setSalary("");

                    vacancyList.add(vacancy);
                }
            } catch (IOException e) {
                System.out.println("Connection lose" + e.getStackTrace());
                break;
            }
            pageNum++;
        }
        return vacancyList;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String URL = String.format(URL_FORMAT, searchString, page);

        Document doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (jsoup)").referrer(URL).get();

        return doc;
    }
}
