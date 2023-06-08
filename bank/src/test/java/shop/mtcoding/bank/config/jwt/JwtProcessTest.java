package shop.mtcoding.bank.config.jwt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shop.mtcoding.bank.config.auth.LoginUser;
import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.domain.user.UserEnum;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class JwtProcessTest {

    private String createToken() {
        // given
        User user = User.builder()
                .id(1L)
                .role(UserEnum.CUSTOMER)
                .build();

        LoginUser loginUser = new LoginUser(user);
        // when
        return JwtProcess.create(loginUser);
    }

    @Test
    @DisplayName("create_test")
     void create_test() {
        // given

        // when
        String jwtToken = createToken();

        // then
        assertTrue(jwtToken.startsWith(JwtVO.TOKEN_PREFIX));
    }

    @Test
    @DisplayName("verify_test")
    void verify_test() {
        // given
        String jwtToken = createToken().replace(JwtVO.TOKEN_PREFIX, "");
        // when
        LoginUser loginUser2 = JwtProcess.verify(jwtToken);
        System.out.println("테스트 : " + loginUser2.getUser().getId());
        System.out.println("테스트 : " + loginUser2.getUser().getRole());

        // then
        assertThat(loginUser2.getUser().getId()).isEqualTo(1L);
        assertThat(loginUser2.getUser().getRole()).isEqualTo(UserEnum.CUSTOMER);
    }

}
