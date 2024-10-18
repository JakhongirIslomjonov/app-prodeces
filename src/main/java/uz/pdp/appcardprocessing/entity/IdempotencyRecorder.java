package uz.pdp.appcardprocessing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class IdempotencyRecorder {

    @Id
    private UUID idempotencyKey;
    private UUID cardId;
    private UUID transactionId;





}