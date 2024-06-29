package com.rungroup.web.dto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/*DTO (Data Transfer Object) are used to transfer data between the server and client,
* especially in context of REST APIs.
* They can help controlling what data is exposed to the client,
* reducing the amount of data sent over the network and decoupling
* the internal representation of the data from its presentation*/

@Data
@Builder

public class ClubDto {

    private Long id;
    private String title;
    private String photoUrl;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}


/*Respository layers intercat with the database while DTOs are used
* tioo trabnsfer data between different layers of the app and the client*/