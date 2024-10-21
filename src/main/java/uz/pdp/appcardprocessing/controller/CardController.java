package uz.pdp.appcardprocessing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appcardprocessing.entity.enums.MessageKey;
import uz.pdp.appcardprocessing.service.MessageService;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private static MessageService messageService;

    @GetMapping()
    public String getGreeting(
            @RequestHeader(value = "X-Mobile-Lang", defaultValue = "ru")
            String language
    ) {

        Locale locale = Locale.forLanguageTag(language);


        return MessageService.getMessage(MessageKey.OPERATION_PROHIBITED);
    }


}
