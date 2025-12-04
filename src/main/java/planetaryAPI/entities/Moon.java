package planetaryAPI.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="moons")
@NoArgsConstructor
@AllArgsConstructor
public class Moon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int moon_id;
    private String name;
    private int diameter_km;
    private int orbital_period_days;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="planet_id")
    private Planet planet;
}

