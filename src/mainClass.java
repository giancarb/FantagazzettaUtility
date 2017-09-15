
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;

public class mainClass {
    public static void main(String[] args) throws InterruptedException {

        //Create prefs map to store all preferences
        Map<String, Object> prefs = new HashMap<String, Object>();

        //Put this into prefs map to switch off browser notification
        prefs.put("profile.default_content_setting_values.notifications", 2);

        //Create chrome options to set this prefs
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        Map<String, Integer> teamMap =
                new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
        teamMap.put("STRAKOSHA", 0);
        teamMap.put("PERIN", 1);
        teamMap.put("GOMIS", 2);
        teamMap.put("DE VRIJ", 3);
        teamMap.put("MIRANDA", 4);
        teamMap.put("BENATIA", 5);
        teamMap.put("N'KOULOU", 6);
        teamMap.put("LICHTSTEINER", 7);
        teamMap.put("SKRINIAR", 8);
        teamMap.put("BRUNO GASPAR", 9);
        teamMap.put("DE SILVESTRI", 10);
        teamMap.put("SUSO", 11);
        teamMap.put("ZIELINSKI", 12);
        teamMap.put("CANDREVA", 13);
        teamMap.put("PEROTTI", 14);
        teamMap.put("CUADRADO", 15);
        teamMap.put("KESSIE", 16);
        teamMap.put("BADELJ", 17);
        teamMap.put("LUIS ALBERTO", 18);
        teamMap.put("DYBALA", 19);
        teamMap.put("QUAGLIARELLA", 20);
        teamMap.put("MANDZUKIC", 21);
        teamMap.put("INGLESE", 22);
        teamMap.put("SAU", 23);
        teamMap.put("BABACAR", 24);


        Map<String, Integer> teamMapFanta =
                new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
        teamMapFanta.put("STRAKOSHA", 0);
        teamMapFanta.put("PERIN", 1);
        teamMapFanta.put("GOMIS A", 2);
        teamMapFanta.put("DE VRIJ", 3);
        teamMapFanta.put("MIRANDA", 4);
        teamMapFanta.put("BENATIA", 5);
        teamMapFanta.put("N'KOULOU", 6);
        teamMapFanta.put("LICHTSTEINER", 7);
        teamMapFanta.put("SKRINIAR", 8);
        teamMapFanta.put("GASPAR", 9);
        teamMapFanta.put("DE SILVESTRI", 10);
        teamMapFanta.put("SUSO", 11);
        teamMapFanta.put("ZIELINSKI", 12);
        teamMapFanta.put("CANDREVA", 13);
        teamMapFanta.put("PEROTTI", 14);
        teamMapFanta.put("CUADRADO", 15);
        teamMapFanta.put("KESSIE'", 16);
        teamMapFanta.put("BADELJ", 17);
        teamMapFanta.put("LUIS ALBERTO", 18);
        teamMapFanta.put("DYBALA", 19);
        teamMapFanta.put("QUAGLIARELLA", 20);
        teamMapFanta.put("MANDZUKIC", 21);
        teamMapFanta.put("INGLESE", 22);
        teamMapFanta.put("SAU", 23);
        teamMapFanta.put("BABACAR", 24);


        Map<String, Integer> teamMapLower = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
        teamMapLower.put("Strakosha", 0);
        teamMapLower.put("Perin", 1);
        teamMapLower.put("Gomis A", 2);
        teamMapLower.put("De Vrij", 3);
        teamMapLower.put("Miranda", 4);
        teamMapLower.put("Benatia", 5);
        teamMapLower.put("Nkoulou", 6);
        teamMapLower.put("Lichtsteiner", 7);
        teamMapLower.put("Skriniar", 8);
        teamMapLower.put("Gaspar", 9);
        teamMapLower.put("De Silvestri", 10);
        teamMapLower.put("Suso", 11);
        teamMapLower.put("Zielinski", 12);
        teamMapLower.put("Candreva", 13);
        teamMapLower.put("Perotti", 14);
        teamMapLower.put("Cuadrado", 15);
        teamMapLower.put("Kessie", 16);
        teamMapLower.put("Badelj", 17);
        teamMapLower.put("Luis Alberto", 18);
        teamMapLower.put("Dybala", 19);
        teamMapLower.put("Quagliarella", 20);
        teamMapLower.put("Mandzukic", 21);
        teamMapLower.put("Inglese", 22);
        teamMapLower.put("Sau", 23);
        teamMapLower.put("Babacar", 24);




        System.setProperty("webdriver.chrome.driver", "/Users/gianlucacarbone/IdeaProjects/Fantagazzetta/chromedriver");
        WebDriver driver = new ChromeDriver(options);

        //Go to Gazzetta Probabili Formazioni
        driver.get("http://www.gazzetta.it/Calcio/prob_form/");

        String[] matches= driver.findElement(By.xpath("//div[@class='matchesSwitch']")).getText().split("\n");

        for (int i = 0; i < matches.length; i+=2){

            System.out.println (matches[i]+ "-" +matches[i+1]);

        }

        Map<String, Object> titolari= getTitolariGazzetta(driver, teamMap);
        System.out.println("Titolari Gazzetta: "+ titolari.toString());

        //p[4] : indisponibili, p[3] : squalificati, p[2] : Ballottaggio,  p[1] :Panchina
        List<WebElement> allDetailsAway = driver.findElements(By.className("awayDetails"));

        Map<String, Object> panchinaAway = getMoreDetails(driver,teamMap,allDetailsAway,1);
        Map<String, Object> ballottaggioAway = getMoreDetails(driver,teamMap,allDetailsAway,2);
        Map<String, Object> squalificatiAway= getMoreDetails(driver,teamMap,allDetailsAway,3);
        Map<String, Object> indisponibiliAway= getMoreDetails(driver,teamMap,allDetailsAway,4);

        System.out.println("PanchinaAway: "+ panchinaAway.toString());
        System.out.println("BallottaggioAway: "+ ballottaggioAway.toString());
        System.out.println("SqualificatiAway: "+ squalificatiAway.toString());
        System.out.println("IndisponibiliAway: "+ indisponibiliAway.toString());

        List<WebElement> allDetailsHome = driver.findElements(By.className("homeDetails"));

        Map<String, Object> panchinaHome = getMoreDetails(driver,teamMap,allDetailsHome,1);
        Map<String, Object> ballottaggioHome = getMoreDetails(driver,teamMap,allDetailsHome,2);
        Map<String, Object> squalificatiHome= getMoreDetails(driver,teamMap,allDetailsHome,3);
        Map<String, Object> indisponibiliHome= getMoreDetails(driver,teamMap,allDetailsHome,4);

        System.out.println("PanchinaHome: "+ panchinaHome.toString());
        System.out.println("BallottaggioHome: "+ ballottaggioHome.toString());
        System.out.println("SqualificatiHome: "+ squalificatiHome.toString());
        System.out.println("IndisponibiliHome: "+ indisponibiliHome.toString());


        //Go to FantaGazzetta Probabili Formazioni
        driver.get("https://www.fantagazzetta.com/probabili-formazioni-serie-a");
        Thread.sleep(3000);
        if (driver.findElements(By.id("close-button-expanded")).size()> 0){

            driver.findElement(By.id("close-button-expanded")).click();
        };


        driver.findElement(By.xpath("/*//*[@id=\"mnavtabs2\"]/li[11]")).click();
        Thread.sleep(2000);
        Map<String, Object> titolariFanta = getTitolariFantaGazzetta(driver, teamMapFanta);
        System.out.println("Titolari Fantagazzetta: " + titolariFanta.toString());
        Map<String, Object> panchinaFanta = getPanchinaFantaGazzetta(driver, teamMapFanta);
        System.out.println("Panchina Fantagazzetta: " + panchinaFanta.toString());


        // Go to Fantagazzetta statistics
        driver.get("https://www.fantagazzetta.com/statistiche-serie-a/2017-18/italia/medie");

        Thread.sleep(3000);
        if (driver.findElements(By.id("close-button-expanded")).size()> 0){

            driver.findElement(By.id("close-button-expanded")).click();
        };


        getStatistics(driver,"P", "tbportieri" ,teamMapLower);

        // Click on D -> Difensori
        driver.findElement(By.xpath("//*[@id='sttabs']/li[2]")).click();



        Thread.sleep(2000);
        getStatistics(driver,"D", "tbdifensori" ,teamMapLower);

        // Click on C -> Centrocampisti
        driver.findElement(By.xpath("//*[@id='sttabs']/li[3]")).click();
        Thread.sleep(2000);
        getStatistics(driver,"C", "tbcentrocampisti" ,teamMapLower);

        // Click on A -> Attaccanti
        driver.findElement(By.xpath("//*[@id='sttabs']/li[4]")).click();
        Thread.sleep(2000);
        getStatistics(driver,"A", "tbattaccanti",teamMapLower );


        driver.quit();


    }


    public static void getStatistics(WebDriver driver, String type, String tableRole, Map teamMapLower) {

        WebElement table = driver.findElement(By.xpath("//*[@id='" + tableRole + "']"));

        List<WebElement> allRows = table.findElements(By.tagName("tr"));

        //td[1] = Name + Team, td[2] = Partite giocate, td[3] = MediaVoto  , td[4] = FantaMedia

        for (int i = 2; i < allRows.size(); i++) {

            String player = allRows.get(i).findElement(By.xpath("td[1]")).getText();
            player = player.substring(0, player.length() - 5);


            if (teamMapLower.containsKey(player.trim())) {
                String nameAndTeam = allRows.get(i).findElement(By.xpath("td[1]")).getText();
                String pg = allRows.get(i).findElement(By.xpath("td[2]")).getText();
                String mv = allRows.get(i).findElement(By.xpath("td[3]")).getText();
                String fm = allRows.get(i).findElement(By.xpath("td[4]")).getText();

                System.out.println(type + ": " + nameAndTeam + " pg: " + pg + " mv: " + mv + " fm: " + fm);
            }
        }


    }

    public static Map<String, Object> getTitolariGazzetta(WebDriver driver, Map<String, Integer> teamMap) {

        // From 9
        List<WebElement> allTeams = driver.findElements(By.tagName("ul"));

        Map<String, Object> titolari = new HashMap<>();

        for (int i = 9; i < allTeams.size(); i++) {

            String team = allTeams.get(i).getText();

            String[] arrayTeam = team.split("\n");

            for (int j = 0; j < arrayTeam.length; j++) {

                if (teamMap.containsKey(arrayTeam[j].trim())) {

                    titolari.put(arrayTeam[j].trim(), teamMap.get(arrayTeam[j].trim()));

                }
            }

        }

        return titolari;

    }


    public static Map<String, Object> getTitolariFantaGazzetta(WebDriver driver, Map<String, Integer> teamMap) {

        List<WebElement> allTeams = driver.findElements(By.xpath(".//div[@class='col-lg-6 col-md-6 col-sm-6 col-xs-6 probbar p10']"));

        Map<String, Object> titolari = new HashMap<>();
        int y = 0;

        for (int i = 0; i < allTeams.size() - 2; i++) {

            if (y == 2) {
                i += 2;
                y = 0;
            }

            String team = allTeams.get(i).getText();

            String[] arrayTeam = team.split("\n");

            for (int j = 0; j < arrayTeam.length; j++) {

                if (teamMap.containsKey(arrayTeam[j].trim())) {

                    titolari.put(arrayTeam[j].trim(), teamMap.get(arrayTeam[j].trim()));

                }
            }

            y += 1;

        }

        return titolari;

    }


    public static Map<String, Object> getPanchinaFantaGazzetta(WebDriver driver, Map<String, Integer> teamMap) {

        List<WebElement> allTeams = driver.findElements(By.xpath(".//div[@class='col-lg-6 col-md-6 col-sm-6 col-xs-6 probbar p10']"));

        Map<String, Object> titolari = new HashMap<>();
        int y = 0;

        for (int i = 2; i < allTeams.size(); i++) {

            if (y == 2) {
                i += 2;
                y = 0;
            }

            String team = allTeams.get(i).getText();

            String[] arrayTeam = team.split("\n");

            for (int j = 0; j < arrayTeam.length; j++) {

                if (teamMap.containsKey(arrayTeam[j].trim())) {

                    titolari.put(arrayTeam[j].trim(), teamMap.get(arrayTeam[j].trim()));

                }
            }

            y += 1;

        }

        return titolari;

    }


    public static Map<String, Object> getMoreDetails(WebDriver driver, Map<String, Integer> teamMap, List<WebElement> allDetailsAway, int type) {

        Map<String, Object> detail = new HashMap<>();

        for (int i = 0; i < allDetailsAway.size(); i++) {

            String player = allDetailsAway.get(i).findElement(By.xpath("p[" + type + "]")).getText();

            for (Map.Entry<String, Integer> entry : teamMap.entrySet()) {

                if (player.contains(entry.getKey())) {

                    detail.put(entry.getKey(), entry.getValue());
                }

            }
        }

        return detail;

    }


}