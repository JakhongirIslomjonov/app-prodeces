package uz.pdp.appcardprocessing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JWTService {

    @Value("${jwt.secretKey}")
    private String secretKey;


}
