
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


        teamMap.put("BUFFON", 0);
        teamMap.put("SZCZESNY", 1);
        teamMap.put("PINSOGLIO", 2);
        teamMap.put("GOSENS", 3);
        teamMap.put("MIRANDA", 4);
        teamMap.put("BASTA", 5);
        teamMap.put("PEZZELLA", 6);
        teamMap.put("TOLOI", 7);
        teamMap.put("ASTORI", 8);
        teamMap.put("RADU", 9);
        teamMap.put("WIDMER", 10);
        teamMap.put("JANKTO", 11);
        teamMap.put("PJANIC", 12);
        teamMap.put("ILICIC", 13);
        teamMap.put("FLORENZI", 14);
        teamMap.put("KHEDIRA", 15);
        teamMap.put("BARELLA", 16);
        teamMap.put("CASTRO", 17);
        teamMap.put("D. COSTA", 18);
        teamMap.put("GOMEZ", 19);
        teamMap.put("SCHICK", 20);
        teamMap.put("THEREAU", 21);
        teamMap.put("CAPRARI", 22);
        teamMap.put("PALACIO", 23);
        teamMap.put("KOWNACKI", 24);


        Map<String, Integer> teamMapFanta =
                new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);


        teamMapFanta.put("BUFFON", 0);
        teamMapFanta.put("SZCZESNY", 1);
        teamMapFanta.put("PINSOGLIO", 2);
        teamMapFanta.put("GOSENS", 3);
        teamMapFanta.put("MIRANDA", 4);
        teamMapFanta.put("BASTA", 5);
        teamMapFanta.put("PEZZELLA GER", 6);
        teamMapFanta.put("TOLOI", 7);
        teamMapFanta.put("ASTORI", 8);
        teamMapFanta.put("RADU", 9);
        teamMapFanta.put("WIDMER", 10);
        teamMapFanta.put("JANKTO", 11);
        teamMapFanta.put("PJANIC", 12);
        teamMapFanta.put("ILICIC", 13);
        teamMapFanta.put("FLORENZI", 14);
        teamMapFanta.put("KHEDIRA", 15);
        teamMapFanta.put("BARELLA", 16);
        teamMapFanta.put("CASTRO", 17);
        teamMapFanta.put("DOUGLAS COSTA", 18);
        teamMapFanta.put("GOMEZ A", 19);
        teamMapFanta.put("SCHICK", 20);
        teamMapFanta.put("THEREAU", 21);
        teamMapFanta.put("CAPRARI", 22);
        teamMapFanta.put("PALACIO", 23);
        teamMapFanta.put("KOWNACKI", 24);


        Map<String, Integer> teamMapLower = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);


        teamMapLower.put("Buffon", 0);
        teamMapLower.put("Szczesny", 1);
        teamMapLower.put("Pinsoglio", 2);
        teamMapLower.put("Gosens", 3);
        teamMapLower.put("Miranda", 4);
        teamMapLower.put("Basta", 5);
        teamMapLower.put("Pezzella Ger", 6);
        teamMapLower.put("Toloi", 7);
        teamMapLower.put("Astori", 8);
        teamMapLower.put("Radu", 9);
        teamMapLower.put("Widmer", 10);
        teamMapLower.put("Jankto", 11);
        teamMapLower.put("Pjanic", 12);
        teamMapLower.put("Ilicic", 13);
        teamMapLower.put("FLorenzi", 14);
        teamMapLower.put("Khedira", 15);
        teamMapLower.put("Barella", 16);
        teamMapLower.put("Castro", 17);
        teamMapLower.put("Douglas Costa", 18);
        teamMapLower.put("Gomez A", 19);
        teamMapLower.put("Schick", 20);
        teamMapLower.put("Thereau", 21);
        teamMapLower.put("Caprari", 22);
        teamMapLower.put("Palacio", 23);
        teamMapLower.put("Kownacki", 24);



        System.setProperty("webdriver.chrome.driver", "/Users/gianlucacarbone/IdeaProjects/FantagazzettaUtility/chromedriver");
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

        Map<String, Object> panchinaAway = getMoreDetails(teamMap,allDetailsAway,1);
        Map<String, Object> ballottaggioAway = getMoreDetails(teamMap,allDetailsAway,2);
        Map<String, Object> squalificatiAway= getMoreDetails(teamMap,allDetailsAway,3);
        Map<String, Object> indisponibiliAway= getMoreDetails(teamMap,allDetailsAway,4);

        System.out.println("PanchinaAway: "+ panchinaAway.toString());
        System.out.println("BallottaggioAway: "+ ballottaggioAway.toString());
        System.out.println("SqualificatiAway: "+ squalificatiAway.toString());
        System.out.println("IndisponibiliAway: "+ indisponibiliAway.toString());

        List<WebElement> allDetailsHome = driver.findElements(By.className("homeDetails"));

        Map<String, Object> panchinaHome = getMoreDetails(teamMap,allDetailsHome,1);
        Map<String, Object> ballottaggioHome = getMoreDetails(teamMap,allDetailsHome,2);
        Map<String, Object> squalificatiHome= getMoreDetails(teamMap,allDetailsHome,3);
        Map<String, Object> indisponibiliHome= getMoreDetails(teamMap,allDetailsHome,4);

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


    public static Map<String, Object> getMoreDetails(Map<String, Integer> teamMap, List<WebElement> allDetailsAway, int type) {

        Map<String, Object> detail = new HashMap<>();

        for (int i = 0; i < allDetailsAway.size(); i++) {

            String player = allDetailsAway.get(i).findElement(By.xpath("p[" + type + "]")).getText();

            for (Map.Entry<String, Integer> entry : teamMap.entrySet()) {
                String lower= entry.getKey().substring(1,entry.getKey().length()).toLowerCase();
                String lowerConcat= entry.getKey().substring(0,1).concat(lower);

                if (player.contains(entry.getKey()) || player.contains(lowerConcat)){

                    detail.put(entry.getKey(), entry.getValue());
                }

            }
        }

        return detail;

    }


}