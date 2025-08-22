package br.com.traive.desk_booking.domain.desk;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "desk")
@Entity(name = "Desk")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Desk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer deskNumber;
    private Boolean available;
}
