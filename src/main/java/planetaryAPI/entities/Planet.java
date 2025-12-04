package planetaryAPI.entities;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name="planets")
@NoArgsConstructor
@AllArgsConstructor
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planet_id;
    private String name;
    private String type;
    private int radius_km;
    private int mass_kg;
    private int orbital_period_days;
}

