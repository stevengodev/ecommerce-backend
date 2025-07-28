package com.foliaco.user_service.user.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(

    @NotBlank(message = "Street cannot be blank")
    String street,

    @NotBlank(message = "City cannot be blank")
    String city,

    @NotBlank(message = "State cannot be blank")
    String state,

    @NotBlank(message = "ZipCode cannot be blank")
    String zipCode,

    @NotBlank(message = "Country cannot be blank")
    String country

) {

}
