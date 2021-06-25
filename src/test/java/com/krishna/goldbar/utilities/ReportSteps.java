package com.krishna.goldbar.utilities;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.steps.StepEventBus;

public class ReportSteps extends ScenarioSteps {

    @Step("{0}")
    public void report(String thisWillAppearOnReport) {
        StepEventBus.getEventBus().takeScreenshot();
    }

    @Step("Failure: {0}")
    public void report_failure(String reason) {
        StepEventBus.getEventBus().takeScreenshot();
        AssertionError assertionError = new AssertionError(reason);
        StepEventBus.getEventBus().testFailed(assertionError);
        throw assertionError;
    }
}
