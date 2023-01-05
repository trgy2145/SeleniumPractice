package day11_seleniumwaits_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {
    @Test
    public void test01(){
        // amazona gidin
        driver.get("https://www.amazon.com");

        // tüm cookiesleri listele
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        int cookiesNo =1;  // set index tutmaz biz verdik..

        for (Cookie eachCookie: cookiesSet
             ) {
            System.out.println(cookiesNo + "-" + eachCookie);
            cookiesNo++;
        }

        // sayfadaki cookies sayısının 5 ten büyük oldugunu test et

        Assert.assertTrue(cookiesSet.size() > 5);

        //i18n-prefs olan cookie nin değerinin USD oldugunu bul

        String expectedCookieValue = "USD";
        String actualCookieValue = "";
        for (Cookie eachCookie: cookiesSet
        ) {
           // System.out.println(eachCookie.getName());
            if(eachCookie.getName().equals("i18n-prefs")){
                actualCookieValue = eachCookie.getValue();
            }
        }
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // ismi "en sevdigim cookie" ve degeri "cikolatalı" olan bir cookie olustur sayfaya ekle

        Cookie newCookie = new Cookie("en sevdigim cookie","cikolatalı");
        driver.manage().addCookie(newCookie);
        cookiesSet = driver.manage().getCookies();
        cookiesNo =1;  // set index tutmaz biz verdik..

        for (Cookie eachCookie: cookiesSet
        ) {
            System.out.println(cookiesNo + "-" + eachCookie);
            cookiesNo++;
        }

        // eklenen cookie eklenmiş mi test et.

        expectedCookieValue = "cikolatalı";
        actualCookieValue = "";
        for (Cookie eachCookie: cookiesSet
        ) {
            // System.out.println(eachCookie.getName());
            if(eachCookie.getName().equals("en sevdigim cookie")){
                actualCookieValue = eachCookie.getValue();
            }
        }
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // ismi skin olanı sil ve silindiğini test et..
        driver.manage().deleteCookieNamed("skin");
        // sildikten sonra tekrar cookiesleri al

        cookiesSet = driver.manage().getCookies();
        int skinCookie = 0;
        for (Cookie eachCookie: cookiesSet
        ) {
           if (eachCookie.getName().equals("skin")){
               skinCookie++;
           }
        }
        Assert.assertEquals(0,skinCookie);

        // tüm cookileri sil ve silindiğini test et.

        driver.manage().deleteAllCookies();
        cookiesSet =  driver.manage().getCookies();

        Assert.assertEquals(0,cookiesSet.size());

        // sayfa yeniden yüklenince yine cookieler yüklenir.


    }
}
