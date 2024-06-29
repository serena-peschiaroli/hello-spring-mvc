package com.rungroup.web.service;

import com.rungroup.web.dto.ClubDto;

import java.util.List;

/*
* The service layer in Spring MVC app serves as a layer of abstraction between
* the controller and the repository
* It contains business logic and methods specific to the app operations*/

//the clubService interface defines the method that the service will implement.
public interface ClubService {
    List<ClubDto> findAllClub();

}
