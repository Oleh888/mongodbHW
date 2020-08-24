package demo.controller;

import demo.model.Hotel;
import demo.repository.HotelRepository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @PostMapping("/add")
    public Hotel create(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @GetMapping("/all")
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @PutMapping
    public Hotel insert(@RequestBody Hotel hotel) {
        return hotelRepository.insert(hotel);
    }

    @PostMapping
    public Hotel update(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        hotelRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id) {
        return hotelRepository.findById(id).get();
    }

    @GetMapping("/price/{price}")
    public List<Hotel> getByPriceLessThan(@PathVariable("price") Double maxPrice) {
        return hotelRepository.findByPricePerNightLessThan(new BigDecimal(maxPrice));
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city) {
        return hotelRepository.findByCity(city);
    }
}
