package wsb.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wsb.mvc.models.Painting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("postgres")
public interface PaintingRepository extends JpaRepository<Painting, Long> {

    List<Painting> findByNameContainsIgnoreCase(String name);

}
