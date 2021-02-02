package wsb.mvc.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import wsb.mvc.models.Painting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("fake")
public class FakePaintingRepository implements PaintingRepository {

    private static final List<Painting> paintings = new LinkedList<>(Arrays.asList(
            new Painting("Papież Leon X", "Fernando Botero", 1964, "https://bestofbharat.com/wp-content/uploads/2019/10/Pope-leo-x-after-raphael-199.png"),
            new Painting("Ogród rozkoszy ziemskich", "Hieronim Bosch", 1500, "https://upload.wikimedia.org/wikipedia/commons/a/ae/El_jard%C3%ADn_de_las_Delicias%2C_de_El_Bosco.jpg"),
            new Painting("Pocałunek", "Gustav Klimt", 1908, "https://upload.wikimedia.org/wikipedia/commons/4/40/The_Kiss_-_Gustav_Klimt_-_Google_Cultural_Institute.jpg"),
            new Painting("Czarny kwadrat na białym tle", "Kazimierz Malewicz", 1915, "https://upload.wikimedia.org/wikipedia/commons/5/57/Malevich.black-square.jpg"),
            new Painting("Krzyk", "Edvard Munch", 1893, "https://upload.wikimedia.org/wikipedia/commons/f/f4/The_Scream.jpg"),
            new Painting("Szał uniesień", "Władysław Podkowiński", 1894, "https://upload.wikimedia.org/wikipedia/commons/7/72/Podkowi%C5%84ski-Sza%C5%82_uniesie%C5%84-MNK.jpg"),
            new Painting("No. 5", "Jackson Pollock", 1948, "https://nosowka.files.wordpress.com/2015/09/number-5a.jpg"),
            new Painting("Trwałość pamięci", "Salvador Dali", 1931, "data:image/jpeg;base64,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")
    ));


    @Override
    public List<Painting> findAll() {
        return paintings;
    }

    @Override
    public long count() {
        return paintings.stream().count();
    }

    @Override
    public List<Painting> findByNameContainsIgnoreCase(String name) {
        return paintings.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public <S extends Painting> S save(S s) {
        paintings.add(s);
        return s;
    }


    // niezaimplementowane

    @Override
    public List<Painting> findAll(Sort sort) {
        throw new NotImplementedException();
    }

    @Override
    public Page<Painting> findAll(Pageable pageable) {
        throw new NotImplementedException();
    }

    @Override
    public List<Painting> findAllById(Iterable<Long> iterable) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Painting painting) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteAll(Iterable<? extends Painting> iterable) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteAll() {
        throw new NotImplementedException();
    }

    @Override
    public <S extends Painting> List<S> saveAll(Iterable<S> iterable) {
        throw new NotImplementedException();
    }

    @Override
    public Optional<Painting> findById(Long aLong) {
        throw new NotImplementedException();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new NotImplementedException();
    }

    @Override
    public void flush() {
        throw new NotImplementedException();
    }

    @Override
    public <S extends Painting> S saveAndFlush(S s) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteInBatch(Iterable<Painting> iterable) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteAllInBatch() {
        throw new NotImplementedException();
    }

    @Override
    public Painting getOne(Long aLong) {
        throw new NotImplementedException();
    }

    @Override
    public <S extends Painting> Optional<S> findOne(Example<S> example) {
        throw new NotImplementedException();
    }

    @Override
    public <S extends Painting> List<S> findAll(Example<S> example) {
        throw new NotImplementedException();
    }

    @Override
    public <S extends Painting> List<S> findAll(Example<S> example, Sort sort) {
        throw new NotImplementedException();
    }

    @Override
    public <S extends Painting> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new NotImplementedException();
    }

    @Override
    public <S extends Painting> long count(Example<S> example) {
        throw new NotImplementedException();
    }

    @Override
    public <S extends Painting> boolean exists(Example<S> example) {
        throw new NotImplementedException();
    }
}
