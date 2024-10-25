package uz.pdp.appcardprocessing.dto.mapper;

import org.mapstruct.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import uz.pdp.appcardprocessing.dto.request.CardRequestDTO;
import uz.pdp.appcardprocessing.entity.Card;
import uz.pdp.appcardprocessing.entity.User;
import uz.pdp.appcardprocessing.repo.UserRepository;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = UserMapper.class)
public interface CardMapper {

    @Mapping(target = "user", source = "userId")
    Card toEntity(CardRequestDTO cardRequestDTO, @Context UserRepository userRepository);

    CardRequestDTO toDto(Card card);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Card partialUpdate(CardRequestDTO cardRequestDTO, @MappingTarget Card card);

    default User mapUser(Long userId, @Context UserRepository userRepository) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + userId));
    }

}