package com.foliaco.user_service.user.mapper;

import com.foliaco.user_service.user.dto.request.AddressRequest;
import com.foliaco.user_service.user.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toAddress(AddressRequest request) {
        return Address.builder()
                .city(request.city())
                .country(request.country())
                .state(request.state())
                .zipCode(request.zipCode())
                .build();
    }

}
