package com.rungroup.web.controller;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;
import com.rungroup.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

/*Controllers in spring MVC handle incoming http request and interact
with service layer and return responses
* They map URL endpoints to methods abd determine what HTTP method can be
  received at these endpoints*/

//define a controller that manages endpoint related to Club entity
//it uses the ClubService to get data and add it to the model
//it's used to render a view
@Controller
public class ClubController {

    private ClubService clubService;

    @Autowired

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubs = clubService.findAllClub();
        model.addAttribute("clubs", clubs);
        return "clubs-list";

    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        ClubDto clubDto = new ClubDto();
        model.addAttribute("club", clubDto);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") ClubDto clubDto) {
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{id}/edit")
    public String getClubForEdit(@PathVariable Long id, Model model) {
        Optional<ClubDto> clubDto = clubService.getClubById(id);
        if (clubDto.isPresent()) {
            model.addAttribute("club", clubDto.get());
            return "clubs-edit";
        } else {
            return "404";
        }
    }

    //update post
    //TODO: Import spring boot starter validation to have @valid annotation and validation support
    @PostMapping("/clubs/{id}")
    public String updateClub(@PathVariable Long id, @ModelAttribute("club") ClubDto clubDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "clubs-edit";
        }

        Optional<ClubDto> existingClubOpt = clubService.getClubById(id);
        if (existingClubOpt.isPresent()) {
            ClubDto existingClub = existingClubOpt.get();
            existingClub.setTitle(clubDto.getTitle());
            existingClub.setContent(clubDto.getContent());
            existingClub.setPhotoUrl(clubDto.getPhotoUrl());
            existingClub.setUpdatedOn(clubDto.getUpdatedOn());
            clubService.saveClub(existingClub);
        } else {
            return "404";
        }
        return "redirect:/clubs";
    }
}
