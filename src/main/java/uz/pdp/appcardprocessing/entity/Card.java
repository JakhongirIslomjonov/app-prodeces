package uz.pdp.appcardprocessing.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import uz.pdp.appcardprocessing.entity.enums.CardStatus;
import uz.pdp.appcardprocessing.entity.enums.Currency;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @JsonProperty("user_id")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "status can not be  null")
    @Enumerated(EnumType.STRING)
    private CardStatus status = CardStatus.ACTIVE;

    private Long balance;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;


    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;


}