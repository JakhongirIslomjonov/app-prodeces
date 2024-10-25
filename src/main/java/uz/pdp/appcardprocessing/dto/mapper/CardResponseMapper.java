package uz.pdp.appcardprocessing.dto.mapper;

import org.mapstruct.*;
import uz.pdp.appcardprocessing.dto.CardResponseDTO;
import uz.pdp.appcardprocessing.entity.Card;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardResponseMapper {
    @Mapping(source = "inital_amount", target = "balance")
    @Mapping(source = "userUser_id", target = "user.id")
    Card toEntity(CardResponseDTO cardResponseDTO);

    @InheritInverseConfiguration(name = "toEntity")
    CardResponseDTO toDto(Card card);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Card partialUpdate(CardResponseDTO cardResponseDTO, @MappingTarget Card card);
}