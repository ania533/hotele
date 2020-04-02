package akademia.repositories;

import akademia.model.dao.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {


    List<Hotel>  findByCountry(String country);

    List<Hotel> findByCountryAndRate(String country, String rate);
}

