package shop.mtcoding.bank.domain.account;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.handler.ex.CustomApiException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "account_tb")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 4) // 수정 함
    private Long number; // 계좌 번호

    @Column(nullable = false, length = 4)
    private Long password; // 계좌 비번

    @Column(nullable = false)
    private Long balance; // 잔액 (기본값 1000원)

    // 항상 ORM에서 fk의 주인은 Many Entity 쪽이다.
    @ManyToOne(fetch = LAZY)
    private User user;

    @CreatedDate //Insert
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @LastModifiedDate //Insert, update
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public Account(Long id, Long number, Long password, Long balance, User user,
                   LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.id = id;
        this.number = number;
        this.password = password;
        this.balance = balance;
        this.user = user;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public void checkOwner(Long userId) {
        if(userId != user.getId()) { // Lazy 로딩이어도 id를 조회할 때는 select 쿼리가 날라가지 않는다.
            throw new CustomApiException("계좌 소유자가 아닙니다.");
        }
    }
}
