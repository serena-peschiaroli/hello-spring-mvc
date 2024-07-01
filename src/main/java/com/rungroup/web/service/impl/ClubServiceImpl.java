package com.rungroup.web.service.impl;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;
import com.rungroup.web.repository.ClubRepository;
import com.rungroup.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClub() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    @Override
    public ClubDto saveClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        Club savedClub = clubRepository.save(club);
        return mapToClubDto(savedClub);
    }

/*
*  This method is typically used when you receive a DTO from the client (e.g., via a web form)
* and need to convert it to an entity to persist it in the database.*/
    private Club mapToClub(ClubDto clubDto) {
        return Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
    }

    /*
    * This method is typically used when you need to send data to the client
    *  (e.g., in a web response) and want to convert the entity to a DTO for presentation.*/
    private ClubDto mapToClubDto(Club club) {
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
    }

    //retrieve club by id
    @Override
    public Optional<ClubDto> getClubById(Long id) {
        Optional<Club> club = clubRepository.findById(id);
        return club.map(this::mapToClubDto);
    }
}
