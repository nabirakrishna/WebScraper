import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


class webPage {
    Document d;
    Element row;

    void setWebPage(String a) {
        try {
            d = Jsoup.connect((a)).get();
//           System.out.println(d.outerHtml());

        } catch (Exception e) {
            System.out.println("The error is" + e);
        }
    }

    void getList() {
        for (Element row : d.select("table.chart.full-width tr")) {
            String title = row.select(".titleColumn a").text();
            String rating = row.select(".imdbRating").text();

            System.out.println(title + " -> Rating: " + rating);
        }

    }

}

public class Scraper {
    public static void main(String[] args){
        webPage tM = new webPage();
        tM.setWebPage("https://www.imdb.com/chart/top/");
        webPage tTv = new webPage();
        tTv.setWebPage("https://www.imdb.com/chart/toptv/");
        webPage pM = new webPage();
        pM.setWebPage("https://www.imdb.com/chart/moviemeter/");
        webPage pTv = new webPage();
        pTv.setWebPage("https://www.imdb.com/chart/tvmeter/");

        tM.getList();
        tTv.getList();
        pM.getList();
        pTv.getList();
  }

}
