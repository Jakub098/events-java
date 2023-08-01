package com.github.jakub098.ticketapp.service.impl;

import com.github.jakub098.ticketapp.model.PlaceAddress;
import com.github.jakub098.ticketapp.model.dto.PlaceAddressDto;
import com.github.jakub098.ticketapp.repository.PlaceAddressRepository;
import com.github.jakub098.ticketapp.service.PlaceAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceAddressImpl implements PlaceAddressService {

    @Autowired
    private PlaceAddressRepository placeAddressRepository;

    @Override
    public List<PlaceAddress> list() {
        return placeAddressRepository.findAll();
    }

    @Override
    public PlaceAddress getById(Integer placeAddressId) {
        return placeAddressRepository.getPlaceAddress(placeAddressId);
    }

    @Override
    public void createPlaceAddress(PlaceAddressDto placeAddress) {
        placeAddressRepository.addPlaceAddress(placeAddress);
    }

    @Override
    public void updatePlaceAddress(PlaceAddress placeAddress) {
        placeAddressRepository.updatePlaceAddress(placeAddress);
    }

    @Override
    public void deletePlaceAddress(Integer placeAddressId) {
        placeAddressRepository.deletePlaceAddress(placeAddressId);
    }


}
