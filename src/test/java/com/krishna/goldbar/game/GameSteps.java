package com.krishna.goldbar.game;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class GameSteps extends UIInteractionSteps {

    GamePage gamePage;

    @Step("Open the game page")
    public void openTheGamePage() {
        gamePage.open();
    }

    @Step("Put first three bars on the left scale")
    public void putFirstThreeBarsOnLeftScale() {
        $(GamePage.LEFT_0_TEXT_FIELD).sendKeys("0");
        $(GamePage.LEFT_1_TEXT_FIELD).sendKeys("1");
        $(GamePage.LEFT_2_TEXT_FIELD).sendKeys("2");
    }

    @Step("Put next three bars on the right scale")
    public void putNextThreeBarsOnRightScale() {
        $(GamePage.RIGHT_0_TEXT_FIELD).sendKeys("3");
        $(GamePage.RIGHT_1_TEXT_FIELD).sendKeys("4");
        $(GamePage.RIGHT_2_TEXT_FIELD).sendKeys("5");
    }

    @Step("Click weigh button")
    public void clickWeighButton() {
        $(GamePage.WEIGH_BUTTON).click();
    }

    @Step("Click reset button")
    public void clickResetButton() {
        $(GamePage.RESET_BUTTON).click();
    }


    @Step("Put two bars from fake bars group into left and reigh side of scale")
    public void putTwoBarsFromFakeBarGroupIntoScale(String barOnLeft, String barOnRight) {
        $(GamePage.LEFT_0_TEXT_FIELD).sendKeys(barOnLeft);
        $(GamePage.RIGHT_0_TEXT_FIELD).sendKeys(barOnRight);
    }

    @Step("Click on fake bar coin")
    public void clickCoinButton(String coinNumber) {
        $(GamePage.coinButton(coinNumber)).click();
    }

    @Step("Get latest weighing")
    public String getLatestWeighing() {
        return getDriver().findElements(GamePage.WEIGHING_TEXT).get(getDriver().findElements(GamePage.WEIGHING_TEXT).size() - 1).getText();
    }

    @Step("Get fake bar group")
    public String[] findFakeBarGroup() {
        if (getLatestWeighing().contains("<"))
            return new String[]{"0", "1", "2"};
        if (getLatestWeighing().contains(">"))
            return new String[]{"3", "4", "5"};
        else return new String[]{"6", "7", "8"};
    }

    @Step("Wait for second weighing result")
    public void waitForSecondWeighingResult() {
        $(GamePage.SECOND_WEIGHING_TEXT).waitUntilVisible();
    }

    @Step("Find fake bar")
    public String findFakeBar(String[] fakeBarsGroup) {
        if (getLatestWeighing().contains("<"))
            return fakeBarsGroup[0];
        if (getLatestWeighing().contains(">"))
            return fakeBarsGroup[1];
        else return fakeBarsGroup[2];
    }

    @Step("Get list of weighings")
    public List<String> getListOfWeighings() {
        List<WebElement> webElementList = getDriver().findElements(GamePage.WEIGHING_TEXT);
        List<String> weighingList = webElementList.stream().map(e -> e.getText()).collect(Collectors.toList());
        return weighingList;
    }

    @Step("Get success message for finding fake bar")
    public String getFakeBarAlertMessage() {
        Alert alert = getDriver().switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
    }

    @Step("Get success message for finding fake bar")
    public void acceptAlert() {
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }


}
