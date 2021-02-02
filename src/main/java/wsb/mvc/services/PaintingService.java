package wsb.mvc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import wsb.mvc.models.Painting;
import wsb.mvc.repositories.PaintingRepository;

import java.util.List;

@Service
public class PaintingService {

    private final Logger log = LoggerFactory.getLogger(PaintingService.class);

    // wersja z "udawaną" bazą danych
    private final String dataSource = "fake";

    // wersja z prawdziwą bazą danych - należy stworzyć bazę danych w postgresie
    // i uzupełnić dane dostępu w application.properties
    // private final String dataSource = "postgres";

    final PaintingRepository paintingRepository;

    public PaintingService(@Qualifier(dataSource) PaintingRepository paintingRepository) {
        this.paintingRepository = paintingRepository;
    }

    public List<Painting> findAllByName(String paintingName) {
        return paintingRepository.findByNameContainsIgnoreCase(paintingName);
    }


    public void save(Painting painting) {
        log.info("Próbujemy zapisać obraz...");

        log.info("Wykonujemy skomplikowane operacje biznesowe - np. wysyłamy powiadomienia mejlowe o dodanym obrazie...");

        log.info("Tu się dzieje cała logika biznesowa!");

        paintingRepository.save(painting);

        log.info("Zapisaliśmy obraz!");
    }
}
