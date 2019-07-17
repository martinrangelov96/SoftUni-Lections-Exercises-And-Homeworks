package org.softuni.productshop.mappings;

import org.modelmapper.ModelMapper;

public interface IHaveCustomMappings {

    void configureMappings(ModelMapper modelMapper);

    //IHaveCustomMappings for former OrderServiceModel.class example

    //    @Override
//    public void configureMappings(ModelMapper modelMapper) {
//        modelMapper.createTypeMap(Order.class, OrderServiceModel.class)
//                .addMapping(
//                        entity -> entity.getProduct().getName(),
//                        (dto, value) -> dto.setName((String) value)
//                )
//                .addMapping(
//                        entity -> entity.getProduct().getPrice(),
//                        (dto, value) -> dto.setPrice((BigDecimal) value)
//                )
//                .addMapping(
//                        entity -> entity.getProduct().getImageUrl(),
//                        (dto, value) -> dto.setImageUrl((String) value)
//                )
//                .addMapping(
//                        entity -> entity.getUser().getUsername(),
//                        (dto, value) -> dto.setCustomer((String) value)
//                );
//    }
}
