package com.foliaco.user_service.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

}
