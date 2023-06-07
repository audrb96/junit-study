package shop.mtcoding.bank.config.jwt;

/*
   SECRET 노출되면 안된다.
   리플래시 토큰 (X)
 */
public interface JwtVO {
    public static final String SECRET = "BRIGHT_STAR"; //HS256 (대칭키)
    public static final int EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7; //일주일
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";

}
