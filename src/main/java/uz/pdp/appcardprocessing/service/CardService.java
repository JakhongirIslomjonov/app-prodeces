package uz.pdp.appcardprocessing.service;

import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import uz.pdp.appcardprocessing.dto.request.CardRequestDTO;

import java.util.UUID;

@Service
public interface CardService {

     HttpEntity<?> createNewCard(UUID idempotencyKey, @Valid CardRequestDTO cardRequestDTO) ;
}
