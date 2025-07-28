package com.foliaco.user_service.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        String id,

        @NotBlank(message = "Firstname cannot be blanck") String firstname,

        @NotBlank(message = "Lastname cannot be null") String lastname,

        @Email(message = "Email should be valid")
        @NotBlank(message = "Email cannot be blank") String email,

        @NotBlank(message = "Phone number cannot be blank") String phoneNumber,

        @NotBlank(message = "Password cannot be blank") String password,

        @NotNull(message = "Address cannot be null") AddressRequest address) {

}
