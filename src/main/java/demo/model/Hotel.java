package demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Hotels")
public class Hotel {
    @Id
    private String id;
    private String name;
    @Indexed(direction = IndexDirection.DESCENDING)
    private BigDecimal pricePerNight;
    private Address address;
    private List<Review> reviews;

    public Hotel() {
        this.reviews = new ArrayList<>();
    }

    public Hotel(String name, BigDecimal pricePerNight, Address address, List<Review> reviews) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.address = address;
        this.reviews = reviews;
    }
}
