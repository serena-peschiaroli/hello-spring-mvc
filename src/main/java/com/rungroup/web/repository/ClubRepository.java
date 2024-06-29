/* repositories are a key part that allows performing CRUD on the database.
* The JPA interface provided by spring data JPA is a tool to interact with the database.
* */

package com.rungroup.web.repository;

import com.rungroup.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/*JPA is an extension of Repository and provides JPA-Related methods such as flishing the persistence
* context and deleting records in a batch.*/
public interface ClubRepository extends JpaRepository<Club, Long> {
    /*this method is derived from the JPARepository and allows retrieving the entity by ID
     (or other fields if specified
     Optional helps in handling the case where the entity mmimght not be found*/

    Optional<Club> findById(Long id);
}
