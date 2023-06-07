package shop.mtcoding.bank.domain.transaction;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import shop.mtcoding.bank.domain.account.Account;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "transaction_tb")
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    private Account withdrawAccount;

    @ManyToOne(fetch = LAZY)
    private Account depositAccount;

    private Long amount;

    private Long withdrawAccountBalance; // 1111 계좌 -> 1000원 -> 500원 -> 200원
    private Long depositAccountBalance;

    @Column(nullable = false)
    @Enumerated(STRING)
    private TransactionEnum gubun;

    // 계좌가 사라져도 로그는 남아야 한다.
    private String sender;
    private String receiver;
    private String tel;

    @CreatedDate //Insert
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @LastModifiedDate //Insert, update
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public Transaction(Long id, Account withdrawAccount, Account depositAccount,
                       Long amount, Long withdrawAccountBalance,
                       Long depositAccountBalance, TransactionEnum gubun,
                       String sender, String receiver, String tel,
                       LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.id = id;
        this.withdrawAccount = withdrawAccount;
        this.depositAccount = depositAccount;
        this.amount = amount;
        this.withdrawAccountBalance = withdrawAccountBalance;
        this.depositAccountBalance = depositAccountBalance;
        this.gubun = gubun;
        this.sender = sender;
        this.receiver = receiver;
        this.tel = tel;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
