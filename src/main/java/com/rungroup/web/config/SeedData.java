package com.rungroup.web.config;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;
import com.rungroup.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    //injects clubService to perform CRUD
    @Autowired
    private ClubService clubService;

    //retrieve all existing clubs records from the database
    @Override
    public void run(String... args) throws Exception {
        List<ClubDto> clubs = clubService.findAllClub();

        if (clubs.isEmpty()) {
            ClubDto club1 = ClubDto.builder()
                    .title("Club 1")
                    .photoUrl("https://media.gettyimages.com/id/1281782358/it/foto/jumping.jpg?s=2048x2048&w=gi&k=20&c=4RWOD08oG3Vi7jTxrgRqtTrz37rfU7o0ip1WVf_QmrQ=")
                    .content("This is the first club")
                    .build();

            ClubDto club2 = ClubDto.builder()
                    .title("Club 2")
                    .photoUrl("https://media.gettyimages.com/id/1215226262/it/foto/sleeping-cat.jpg?s=2048x2048&w=gi&k=20&c=hrjgyJZ5Z2TrL-ofWrtB-B2lnAiOmih6SM3ibqnOowE=")
                    .content("This is the second club")
                    .build();

            clubService.saveClub(club1);
            clubService.saveClub(club2);
        }

    }
}
