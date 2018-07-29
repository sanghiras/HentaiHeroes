import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DuelPage extends HentaiHeroesPage {
    public DuelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"arena\"]/div[1]/div[2]/div[3]")
    private WebElement mesPV;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[1]/div[2]")
    private WebElement pVAdversaire1;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[2]/div[2]")
    private WebElement pVAdversaire2;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[3]/div[2]")
    private WebElement pVAdversaire3;

    @FindBy(css = "#arena > div.base_block.opponents_arena > div:nth-child(2) > div.disabled_opponent > span")
    private WebElement victoire1;

    @FindBy(css = "#arena > div.base_block.opponents_arena > div:nth-child(3) > div.disabled_opponent > span")
    private WebElement victoire2;

    @FindBy(css = "#arena > div.base_block.opponents_arena > div:nth-child(4) > div.disabled_opponent > span")
    private WebElement victoire3;

    @FindBy(css = "#arena > div.base_block.opponents_arena > div.sub_block.one_opponent.disabled > div.disabled_opponent > span")
    private WebElement defaite1;

    @FindBy(css = "")
    private WebElement defaite2;

    @FindBy(css = "#arena > div.base_block.opponents_arena > div:nth-child(4) > div.disabled_opponent > span")
    private WebElement defaite3;



    public int PvHeros() {

        String plif = mesPV.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        plouf.delete(0, 3);
        String plof = plouf.toString();
        int pvHeros = Integer.parseInt(plof);
        System.out.println("PV = " + pvHeros);
        return pvHeros;
    }

    public boolean combat1Fait(WebDriver driver)
    {
        try
        {
            driver.findElement(By.cssSelector("#arena > div.base_block.opponents_arena > div:nth-child(2) > div.disabled_opponent > span"));
            if (victoire1.isDisplayed() || defaite1.isDisplayed())
            {
                return false;
            }
        }
        catch (NoSuchElementException e)
        {
            return true;
        }
        return true;
    }

    public boolean combat1PlusFaible (WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(mesPV));
        int pvHeros = PvHeros();
        String plif2 = pVAdversaire1.getText();
        String plaf2 = plif2.replaceAll("\\s", "");
        StringBuffer plouf2 = new StringBuffer(plaf2);
        plouf2.delete(0, 3);
        String plof2 = plouf2.toString();
        int pvDuMechant1 = Integer.parseInt(plof2);
        System.out.println("PV = " + pvDuMechant1);
        if (pVAdversaire1.isDisplayed()) {
            if (pvHeros >= pvDuMechant1)
            {
                return true;
            }
        }
        return false;
    }

    public CombatPage duel1(WebDriver driver)
    {
        pVAdversaire1.click();
        return new CombatPage(driver);
    }

    public boolean combat2Fait(WebDriver driver)
    {
        try
        {
            driver.findElement(By.cssSelector("#arena > div.base_block.opponents_arena > div:nth-child(3) > div.disabled_opponent > span"));
            if (victoire2.isDisplayed())
            {
                return false;
            }
        }
        catch (NoSuchElementException e)
        {
            return true;
        }
        return true;
    }

    public boolean combat2PlusFaible (WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(visibilityOf(mesPV));
        int pvHeros = PvHeros();
        String plif2 = pVAdversaire2.getText();
        String plaf2 = plif2.replaceAll("\\s", "");
        StringBuffer plouf2 = new StringBuffer(plaf2);
        plouf2.delete(0, 3);
        String plof2 = plouf2.toString();
        int pvDuMechant1 = Integer.parseInt(plof2);
        System.out.println("PV = " + pvDuMechant1);
        if (pVAdversaire2.isDisplayed()) {
            if (pvHeros >= pvDuMechant1)
            {
                return true;
            }
        }
        return false;
    }

    public CombatPage duel2(WebDriver driver)
    {
        pVAdversaire2.click();
        return new CombatPage(driver);
    }

    public boolean combat3Fait(WebDriver driver)
    {
        try
        {
            driver.findElement(By.cssSelector("#arena > div.base_block.opponents_arena > div:nth-child(4) > div.disabled_opponent > span"));
            if (victoire3.isDisplayed())
            {
                return false;
            }
        }
        catch (NoSuchElementException e)
        {
            return true;
        }
        return true;
    }

    public boolean combat3PlusFaible (WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(visibilityOf(mesPV));
        int pvHeros = PvHeros();
        String plif2 = pVAdversaire3.getText();
        String plaf2 = plif2.replaceAll("\\s", "");
        StringBuffer plouf2 = new StringBuffer(plaf2);
        plouf2.delete(0, 3);
        String plof2 = plouf2.toString();
        int pvDuMechant1 = Integer.parseInt(plof2);
        System.out.println("PV = " + pvDuMechant1);
        if (pVAdversaire3.isDisplayed()) {
            if (pvHeros >= pvDuMechant1)
            {
                return true;
            }
        }
        return false;
    }

    public CombatPage duel3(WebDriver driver) {

        pVAdversaire3.click();
        return new CombatPage(driver);
    }
}
