package com.rungroup.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
//lombok annotation
@Data //Generates getters, setters, 'toString' etc
@NoArgsConstructor//generates a no argument constructr
@AllArgsConstructor //generate a constructor with one parameter for each fields
@Builder // implements the builder pattern for the class
//JPA annotations
@Entity //soecifies that the class is an entity and is mapped to a database
@Table(name= "club") //specifies the name of the database table

public class Club {
    //field annotations
    @Id //specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*PK generation strategy.
    Identity = the db will generate a unique value*/
    private Long id;
    private String title;
    private String photoUrl;
    private String content;
    //automatically sets the timestamp when the entity is created or updated
    @CreationTimestamp
    private LocalDateTime createdOn;
    @CreationTimestamp
    private LocalDateTime updatedOn;


}
