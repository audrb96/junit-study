# Junit Bank App

### Jpa LocalDateTime 자동으로 생성하는 법
- @EnableJpaAuditing
- @EntityListeners(AuditingEntityListener.class) (Entity 클래스)
```java
    @CreatedDate //Insert
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @LastModifiedDate //Insert, update
    @Column(nullable = false)
    private LocalDateTime createdAt;
```