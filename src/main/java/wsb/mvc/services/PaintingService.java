package wsb.mvc.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import wsb.mvc.models.Painting;
import wsb.mvc.repositories.PaintingRepository;

import java.util.List;

@Service
public class PaintingService {

    final PaintingRepository paintingRepository;

    public PaintingService(@Qualifier("fake") PaintingRepository paintingRepository) {
        this.paintingRepository = paintingRepository;
    }

    public List<Painting> findAllByName(String paintingName) {
        return paintingRepository.findByNameContains(paintingName);
    }


}
