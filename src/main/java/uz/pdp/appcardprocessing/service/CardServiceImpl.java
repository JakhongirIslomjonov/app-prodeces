package uz.pdp.appcardprocessing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.appcardprocessing.dto.mapper.CardMapper;
import uz.pdp.appcardprocessing.dto.mapper.CardResponseMapper;
import uz.pdp.appcardprocessing.dto.request.CardRequestDTO;
import uz.pdp.appcardprocessing.entity.Card;
import uz.pdp.appcardprocessing.entity.IdempotencyRecorder;
import uz.pdp.appcardprocessing.exceptions.BadRequestException;
import uz.pdp.appcardprocessing.exceptions.NotFoundException;
import uz.pdp.appcardprocessing.repo.CardRepository;
import uz.pdp.appcardprocessing.repo.IdempotencyRecorderRepository;
import uz.pdp.appcardprocessing.repo.UserRepository;
import uz.pdp.appcardprocessing.util.CardUtil;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final IdempotencyRecorderRepository idempotencyRecorderRepository;
    private final CardUtil cardUtil;
    private final CardResponseMapper cardResponseMapper;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private final CardMapper cardMapper;


    @Override
    public HttpEntity<?> createNewCard(UUID idempotencyKey, CardRequestDTO cardRequestDTO) {
        Optional<IdempotencyRecorder> idempotencyRecorderOptional = idempotencyRecorderRepository.findById(idempotencyKey);
        if (idempotencyRecorderOptional.isPresent()) {
            Card card = cardUtil.checkCardExistence(idempotencyRecorderOptional.get().getCardId());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(cardResponseMapper.toDto(card));
        }
        if (cardRepository.findActiveCardsByUserId(cardRequestDTO.userId()) == 3) {
            throw new BadRequestException("Card limit is exceeded above 3");
        }
        if (userRepository.findById(cardRequestDTO.userId()).isEmpty()) {
            throw new NotFoundException("User with provided id is not found");
        }

        Card card = cardRepository.save(cardMapper.toEntity(cardRequestDTO, userRepository));
        idempotencyRecorderRepository.save(new IdempotencyRecorder(idempotencyKey, card.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(cardResponseMapper.toDto(card));

    }
}
