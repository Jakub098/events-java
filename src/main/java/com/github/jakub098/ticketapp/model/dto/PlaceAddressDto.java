package com.github.jakub098.ticketapp.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceAddressDto {
    private String street;
    private Integer number;
    private String postalCode;
    private String city;
}
