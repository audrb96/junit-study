package shop.mtcoding.bank.temp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

//java.util.regex.Pattern
public class RegexTest {

    @Test
    @DisplayName("한글만된다")
    void 한글만된다_test() {
        // given
        String value = "한글";

        // when
        boolean result = Pattern.matches("^[가-힣]+$", value);

        // then
        System.out.println("테스트 : " + result);
    }
    @Test
    @DisplayName("한글은안된다")
    void 한글은안된다_test() {
        // given
        String value = "";

        // when
        boolean result = Pattern.matches("^[^ㄱ-ㅎ가-힣]*$", value);

        // then
        System.out.println("테스트 : " + result);
    }
    @Test
    @DisplayName("영어만된다")
    void 영어만된다_test() {
        // given
        String value = "dddddd2";

        // when
        boolean result = Pattern.matches("^[a-zA-Z]+$", value);

        // then
        System.out.println("테스트 : " + result);
    }

    @Test
    @DisplayName("영어는안된다")
    void 영어는안된다_test() {
        // given
        String value = "dddddd2";

        // when
        boolean result = Pattern.matches("^[^a-zA-Z]*$", value);

        // then
        System.out.println("테스트 : " + result);
    }

    @Test
    @DisplayName("영어와숫자만된다")
    void 영어와숫자만된다_test() {
        // given
        String value = "dddddd2";

        // when
        boolean result = Pattern.matches("^[a-zA-Z0-9]+$", value);

        // then
        System.out.println("테스트 : " + result);
    }

    @Test
    @DisplayName("영어만되고_길이는최소2최대4이다")
    void 영어만되고_길이는최소2최대4이다_test() {
        // given
        String value = "ssar";

        // when
        boolean result = Pattern.matches("^[a-zA-Z]{2,4}$", value);

        // then
        System.out.println("테스트 : " + result);
    }

    //username, email, fullname
    @Test
    @DisplayName("user_username")
    void user_username_test() {
        // given
        String username = "ssa가";

        // when
        boolean result = Pattern.matches("^[a-zA-Z0-9]{2,20}$", username);

        // then
        System.out.println("테스트 : " + result);
    }

    @Test
    @DisplayName("user_fullname")
    void user_fullname_test() {
        // given
        String username = "ssa가";

        // when
        boolean result = Pattern.matches("^[a-zA-Z가-힣]{1,20}$", username);

        // then
        System.out.println("테스트 : " + result);
    }

    @Test
    @DisplayName("user_email")
    void user_email_test() {
        // given
        String username = "ssaraa@nate.com";

        // when
        boolean result = Pattern.matches("^[a-zA-Z0-9]{2,6}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}$", username);

        // then
        System.out.println("테스트 : " + result);
    }
}
