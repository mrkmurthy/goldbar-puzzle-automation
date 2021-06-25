package com.krishna.goldbar.game;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://ec2-54-208-152-154.compute-1.amazonaws.com/")
public class GamePage extends PageObject {
    static By LEFT_0_TEXT_FIELD = By.id("left_0");
    static By LEFT_1_TEXT_FIELD = By.id("left_1");
    static By LEFT_2_TEXT_FIELD = By.id("left_2");
    static By RIGHT_0_TEXT_FIELD = By.id("right_0");
    static By RIGHT_1_TEXT_FIELD = By.id("right_1");
    static By RIGHT_2_TEXT_FIELD = By.id("right_2");
    static By RESET_BUTTON = By.xpath("//button[text() = 'Reset']");
    static By WEIGH_BUTTON = By.id("weigh");
    static By WEIGHING_TEXT = By.xpath("//div[@class='game-info']//li");
    static String coinID = "coin_replaceString";
    static By SECOND_WEIGHING_TEXT = By.xpath("//div[@class='game-info']//li[2]");

    public static By coinButton(String stringToReplace) {
        return By.id(coinID.replace("replaceString", stringToReplace));
    }
}