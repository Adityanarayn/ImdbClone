package moviesApp2.MoviesApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Cast")
    private String cast;

    @Column(name = "Director")
    private String director;

    @Column(name = "Budget")
    private Long budget;

//    public void setId(0) {
//        this.id = 0L;
//    }
}
