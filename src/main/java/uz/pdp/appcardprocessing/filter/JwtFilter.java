package uz.pdp.appcardprocessing.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.pdp.appcardprocessing.service.JWTService;

@Component
@RequiredArgsConstructor
@Slf4j
public abstract class JwtFilter extends OncePerRequestFilter {


    private final JWTService jwtService;




}
