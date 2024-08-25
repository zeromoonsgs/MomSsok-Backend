package MomSsok.MomSsok.repository;

import MomSsok.MomSsok.domain.Place;
import MomSsok.MomSsok.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchPlaceRepository extends JpaRepository<Place, Long> {

    @Query("SELECT p FROM Place p WHERE "
            + "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND "
            + "(:description IS NULL OR LOWER(p.description) LIKE LOWER(CONCAT('%', :description, '%'))) AND "
            + "(:tag1 IS NULL OR LOWER(p.tag1) LIKE LOWER(CONCAT('%', :tag1, '%'))) AND "
            + "(:tag2 IS NULL OR LOWER(p.tag2) LIKE LOWER(CONCAT('%', :tag2, '%')))")
    List<Place> searchPlaces(String name, String description, String tag1, String tag2);

}


