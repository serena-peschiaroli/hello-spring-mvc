package com.rungroup.web.service.impl;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;
import com.rungroup.web.repository.ClubRepository;
import com.rungroup.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/* the service Implementation: ClubServiceImpl implements the ClubService interface.
* It uses the repository to interact with the database and includes a method
* to convert Club entities to ClubDto*/

public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClub() {
        List<Club> clubs = clubRepository.findAll();
        //this line uses java stram to convert the list of club entities into a club dto objects
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    /* this method takes a club objects as a parameter and returnus a clubdto obkect*/
    private ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDto;
    }
}
