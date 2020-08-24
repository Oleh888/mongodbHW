package demo;

import demo.model.Address;
import demo.model.Hotel;
import demo.model.Review;
import demo.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class Initializer implements CommandLineRunner {
    private final HotelRepository hotelRepository;

    public Initializer(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel ukraine = new Hotel("Ukraine", new BigDecimal(600), new Address("Kiev", "Ukraine"), Arrays.asList(
                new Review("Anton", 5, false),
                new Review("Oleh", 10, true)
        ));

        Hotel diamond = new Hotel(
                "Diamond",
                new BigDecimal(1000),
                new Address("Kiev", "Ukraine"),
                Arrays.asList(
                        new Review("Anton", 10, true),
                        new Review("Oleh", 10, true)
                )
        );

        Hotel lux = new Hotel(
                "Poland",
                new BigDecimal(1500),
                new Address("Warsaw", "Poland"),
                Arrays.asList(
                        new Review("Denis", 8, true),
                        new Review("Oleh", 10, true)
                )
        );

        hotelRepository.deleteAll();
        hotelRepository.saveAll(Arrays.asList(ukraine, lux, diamond));
    }
}
