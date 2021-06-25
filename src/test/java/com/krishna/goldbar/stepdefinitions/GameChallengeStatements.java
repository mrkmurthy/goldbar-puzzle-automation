package com.krishna.goldbar.stepdefinitions;

import com.krishna.goldbar.game.GameSteps;
import com.krishna.goldbar.utilities.ReportSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameChallengeStatements {
    String fakeBar;
    @Steps
    GameSteps gameSteps;

    @Steps
    ReportSteps reportSteps;

    @Given("user plays the fake gold bar game")
    public void i_am_on_the_game_page() {
        gameSteps.openTheGamePage();
    }

    @When("he solves the game puzzle")
    public void find_the_fake_bar_in_the_game() throws InterruptedException {
        gameSteps.putFirstThreeBarsOnLeftScale();
        gameSteps.putNextThreeBarsOnRightScale();
        gameSteps.clickWeighButton();
        String[] fakeBarsGroup = gameSteps.findFakeBarGroup();
        reportSteps.report("The bars weighed as shown in screenshot");
        gameSteps.clickResetButton();
        gameSteps.putTwoBarsFromFakeBarGroupIntoScale(fakeBarsGroup[0], fakeBarsGroup[1]);
        gameSteps.clickWeighButton();
        gameSteps.waitForSecondWeighingResult();
        fakeBar = gameSteps.findFakeBar(fakeBarsGroup);
    }

    @Then("he should get message that fake bar successfully found")
    public void verify_fake_bar_successfully_found_message() {
        List<String> listOfWeightings = gameSteps.getListOfWeighings();
        gameSteps.clickCoinButton(fakeBar);
        String alertMessage = gameSteps.getFakeBarAlertMessage();
        if (alertMessage.equals("Yay! You find it!")) {
            reportSteps.report("Test passed. The fake bar is: " + fakeBar);
        } else {
            reportSteps.report_failure("Test failed. Unable to find the fake bar in the puzzle");
        }
        reportSteps.report("Alert message on clicking fake bar number: " + alertMessage);
        reportSteps.report("Number of weighings made: " + listOfWeightings.size());
        reportSteps.report("List of weighings made: " + listOfWeightings.toString());
    }
}