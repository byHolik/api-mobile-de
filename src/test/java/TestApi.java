import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class TestApi {

    @Test
    @DisplayName("Task 1")
    public void testTask1() {
        String URL = "https://www.mobile.de/";

        RestAssured
                .given()
                .header("User-Agent", "PostmanRuntime/7.33.0")
                .header("Content-Type", "text/html")
                .when()
                .get(URL)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("Task 2")
    public void testTask2() {
        int carID = 340018013;
        String URL = "https://suchen.mobile.de/fahrzeuge/svc/my/parkings/" + carID;
        String body = "{" +
                "\"adId\":\"" + carID + "\"," +
                "\"ref\":null," +
                "\"refId\":null" +
                "}";

        RestAssured
                .given()
                .body(body)
                .header("User-Agent", "PostmanRuntime/7.33.0")
                .headers("content-type", "application/json; charset=utf-8")
                .header("x-mobile-vi", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJmZDM5MWZjMS00YmI3LTRkZjQtYTUxMS04YWIxNTJkOTRiZDIiLCJpYXQiOjE2Nzg4OTg3OTh9.4i0QiqIXw9FZOhuJQNs38I2pUL99pQgmEaOjwkCO4NY")
                .when()
                .post(URL)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .assertThat()
                .body("adId", equalTo(carID));
    }


    @Test
    @DisplayName("Task 3")
    public void testTask3() {
        String URL = "https://www.mobile.de/api/my/account";
        String body = "{" +
                "\"email\":\"test@gmail.com\"," +
                "\"password\":\"1q@W3e4r\"," +
                "\"privacy\":true," +
                "\"generalTermsApproved\":true," +
                "\"privacySettings\":[]," +
                "\"optIns\":[\"SOFT_OPTIN_AUTO\"]" +
                "}";

        RestAssured
                .given()
                .body(body)
                .header("User-Agent", "PostmanRuntime/7.33.0")
                .headers("content-type", "application/json; charset=utf-8")
                .header("x-mobile-client", "de.mobile.cis")
                .when()
                .post(URL)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body("[0].field", equalTo("email"))
                .body("[0].code", equalTo("account-exists"))
                .body("[0].message", equalTo("Diese E-Mail-Adresse ist bereits registriert."));
    }

    @Test
    @DisplayName("Task 4")
    public void testTask4() {
        String URL = "https://www.mobile.de/api/my/account";
        String body = "{" +
                "\"email\":\"\"," +
                "\"password\":\"1q@W3e4r\"," +
                "\"privacy\":true," +
                "\"generalTermsApproved\":true," +
                "\"privacySettings\":[]," +
                "\"optIns\":[\"SOFT_OPTIN_AUTO\"]" +
                "}";

        RestAssured
                .given()
                .body(body)
                .header("User-Agent", "PostmanRuntime/7.33.0")
                .headers("content-type", "application/json; charset=utf-8")
                .header("x-mobile-client", "de.mobile.cis")
                .when()
                .post(URL)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body("[0].field", equalTo("email"))
                .body("[0].code", equalTo("email-empty"))
                .body("[0].message", equalTo("Bitte geben Sie eine E-Mail-Adresse ein."))
                .body("[1].field", equalTo("email"))
                .body("[1].code", equalTo("email-invalid"))
                .body("[1].message", equalTo("Die eingegebene E-Mail-Adresse ist ungültig."));
    }

    @Test
    @DisplayName("Task 5")
    public void testTask5() {
        String URL = "https://www.mobile.de/api/my/account";
        String body = "{" +
                "\"email\":\"test1234523434@gmail.com\"," +
                "\"password\":\"\"," +
                "\"privacy\":true," +
                "\"generalTermsApproved\":true," +
                "\"privacySettings\":[]," +
                "\"optIns\":[\"SOFT_OPTIN_AUTO\"]" +
                "}";

        RestAssured
                .given()
                .body(body)
                .header("User-Agent", "PostmanRuntime/7.33.0")
                .headers("content-type", "application/json; charset=utf-8")
                .header("x-mobile-client", "de.mobile.cis")
                .when()
                .post(URL)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body("[0].field", equalTo("password"))
                .body("[0].code", equalTo("password-empty"))
                .body("[0].message", equalTo("Bitte gib ein Passtwort ein."));
    }
}
