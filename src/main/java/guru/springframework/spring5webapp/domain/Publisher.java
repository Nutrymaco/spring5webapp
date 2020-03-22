package guru.springframework.spring5webapp.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private Long id;

    private String name, addressLine, city;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books;

    public Publisher() { books = new HashSet<>(); }

    public Publisher(String name, String addressLine, String city) {
        this(name, addressLine, city, new HashSet<>());
    }

    public Publisher(String name, String addressLine, String city, Set<Book> books) {
        this.name = name;
        this.addressLine = addressLine;
        this.city = city;
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return getId().equals(publisher.getId()) &&
                Objects.equals(getName(), publisher.getName()) &&
                Objects.equals(getAddressLine(), publisher.getAddressLine()) &&
                Objects.equals(getCity(), publisher.getCity()) &&
                Objects.equals(getBooks(), publisher.getBooks());
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
