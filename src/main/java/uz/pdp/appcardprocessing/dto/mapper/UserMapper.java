package uz.pdp.appcardprocessing.dto.mapper;

import org.mapstruct.*;
import uz.pdp.appcardprocessing.entity.LoginDTO;
import uz.pdp.appcardprocessing.entity.User;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(LoginDTO loginDto);

    LoginDTO toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(LoginDTO loginDto, @MappingTarget User user);
}