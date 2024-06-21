package utils;

import com.codepine.api.testrail.TestRail;

public class TestRailIntegration {
    public static void main(String[] args) {
        String testRailUrl = "https://chernata.testrail.io/index.php?/projects/overview/1";
        String userName = "2daryachernata2@gmail.com";
        String password = "8Daria_Airad8";

        TestRail myTestRail =
                TestRail.builder(testRailUrl, userName, password).applicationName("TestRailIntegration").build();

    }
}
