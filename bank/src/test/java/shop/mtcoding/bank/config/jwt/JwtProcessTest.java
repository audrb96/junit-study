package shop.mtcoding.bank.config.jwt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shop.mtcoding.bank.config.auth.LoginUser;
import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.domain.user.UserEnum;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class JwtProcessTest {

    @Test
    @DisplayName("create_test")
     void create_test() {
        // given
        User user = User.builder()
                .id(1L)
                .role(UserEnum.CUSTOMER)
                .build();

        LoginUser loginUser = new LoginUser(user);
        // when
        String jwtToken = JwtProcess.create(loginUser);

        // then
        assertTrue(jwtToken.startsWith(JwtVO.TOKEN_PREFIX));
    }

    @Test
    @DisplayName("verify_test")
    void verify_test() {
        // given
        String jwtToken = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJiYW5rIiwiZXhwIjoxNjg2NjQ1MzA2LCJpZCI6MSwicm9sZSI6IkNVU1RPTUVSIn0.9v_iav_twafa3pPNNhZe3wX0e46ia6Y1JFR-5AizsQ6XqyfdCAnAcwLSmzsx87oVyucQCWwmO4wiRHWMQLUJlg";

        // when
        LoginUser loginUser = JwtProcess.verify(jwtToken);
        System.out.println("테스트 : " + loginUser.getUser().getId());
        System.out.println("테스트 : " + loginUser.getUser().getRole());

        // then
        assertThat(loginUser.getUser().getId()).isEqualTo(1L);
        assertThat(loginUser.getUser().getRole()).isEqualTo(UserEnum.CUSTOMER);
    }

}
