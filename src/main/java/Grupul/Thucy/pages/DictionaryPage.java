package Grupul.Thucy.pages;

import static ch.lambdaj.Lambda.convert;

import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ch.lambdaj.function.convert.Converter;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
public class DictionaryPage extends PageObject {

    @FindBy(name = "search")
    private WebElementFacade searchTerms;

    @FindBy(name = "go")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {

            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }

    public void explicitWait() {

        int timer = 0;
        // wait for 30 seconds max
        while (timer < 30) {
            try {
                WebElementFacade webElem = find(By.id("aidi"));
                if (webElem.isCurrentlyVisible()) {
                    // bla bla
                    webElem.click();
                } else {
                    waitABit(1000);
                    timer++;
                }
            }
            catch (ElementNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
