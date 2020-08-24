package demo.repository;

import demo.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

    Optional<Hotel> findById(String id);

    List<Hotel> findByPricePerNightLessThan(BigDecimal price);

    @Query(value = "{address.city:?0}")
    List<Hotel> findByCity(String city);
}
