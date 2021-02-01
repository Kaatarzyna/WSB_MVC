package wsb.mvc.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import wsb.mvc.models.Painting;
import wsb.mvc.repositories.PaintingRepository;

import java.util.List;

@Service
public class PaintingService {

    // wersja z "udawaną" bazą danych
    private final String dataSource = "fake";

    // wersja z prawdziwą bazą danych - należy stworzyć bazę danych w postgresie
    // i uzupełnić dane dostępu w application.properties
    // private final String dataSource = "postgres"

    final PaintingRepository paintingRepository;

    public PaintingService(@Qualifier(dataSource) PaintingRepository paintingRepository) {
        this.paintingRepository = paintingRepository;
    }

    public List<Painting> findAllByName(String paintingName) {
        return paintingRepository.findByNameContainsIgnoreCase(paintingName);
    }


}
