package safron_github;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@Owner("allure8")
public class TestForGithub {

    private final String url = "https://github.com";

    @Test
    @AllureId("10559")
    @DisplayName("Авторизация без логина и пароля.")
    public void signWithoutEmail() {
        step("Открыть страницу "+ url);
        open(url);
        step("Нажать на кнопку SignIn");
        $(byText("Sign in")).click();
        step("В форме авторизации нажать на кнопку Sign in");
        $(By.name("commit")).click();
        step("Проверить наличие записи о некорректном логине или пароле.");
        $("#js-flash-container").shouldHave(text("Incorrect username or password."));
    }

    @Test
    @AllureId("10560")
    @DisplayName("Авторизация с логином и без пароля.")
    public void signWithEmail() {
        step("Открыть страницу "+ url);
        open(url);
        step("Нажать на кнопку SignIn");
        $(byText("Sign in")).click();
        step("В поле Username or email внести зарегистрированный email.");
        $(By.name("login")).setValue("blabla@mail.ru");
        step("В форме авторизации нажать на кнопку Sign in");
        $(By.name("commit")).click();
        step("Проверить наличие записи о некорректном логине или пароле.");
        $("#js-flash-container").shouldHave(text("Incorrect username or password."));
    }

}
