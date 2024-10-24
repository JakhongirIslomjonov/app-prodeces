package uz.pdp.appcardprocessing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.appcardprocessing.entity.enums.Currency;
import uz.pdp.appcardprocessing.entity.enums.TransactionPurpose;
import uz.pdp.appcardprocessing.entity.enums.TransactionType;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;


    @NotNull(message = "External id cannot be null !")
    private String externalId;

    @JoinColumn(name = "card_id")
    @ManyToOne
    private Card card;


    @NotNull(message = " Balance should be provided ")
    private Long afterBalance;

    @Positive(message = "Transaction cannot be negative or zero!")
    private Long amount;

    @NotNull(message = " Currency cannot be null ! ")
    @Enumerated(EnumType.STRING)
    private Currency currency;


    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionPurpose transactionPurpose;

    private Long exchangeRate;
}