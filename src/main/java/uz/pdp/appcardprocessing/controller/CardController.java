package uz.pdp.appcardprocessing.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appcardprocessing.dto.request.CardRequestDTO;
import uz.pdp.appcardprocessing.dto.response.CardResponseDTO;
import uz.pdp.appcardprocessing.exceptions.ExceptionResponse;
import uz.pdp.appcardprocessing.service.CardService;

import java.util.UUID;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
@Tag(name = "Cards API", description = "(CRUD operations and search mechanism)")
public class CardController {


    private final CardService cardService;

    @Operation(description = "Creates new card with given characteristics")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Card created successfully.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardResponseDTO.class))),
            @ApiResponse(
                    responseCode = "200",
                    description = "Card with this Idempotency-Key has already been created before. API returns current card data.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Missing field, invalid data or card limit is exceeded",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "401", description = "Request sent without authorization/token",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "403", description = "User doesn't have privilege to access this resource",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "User cannot be found by provided ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @PostMapping
    public HttpEntity<?> creatCard(
            @RequestHeader("Idempotency-Key") UUID idempotencyKey,
            @RequestBody @Valid CardRequestDTO cardRequestDTO) {
        return cardService.createNewCard(idempotencyKey,cardRequestDTO);
    }


}
