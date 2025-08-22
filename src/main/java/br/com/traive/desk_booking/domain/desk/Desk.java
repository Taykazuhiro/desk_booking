package br.com.traive.desk_booking.domain.desk;

import br.com.traive.desk_booking.domain.booking.Booking;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "desk")
    private List<Booking> booking;

    public Desk(CreateDeskData data) {
    this.deskNumber = data.deskNumber();
    this.available = data.available();
    }

    public void deactive() {
        this.available=false;
    }

    public void updateDeskInfo(UpdateDeskData data) {
        if(this.deskNumber != data.deskNumber()){
            this.deskNumber = data.deskNumber();
        }
        if(this.available != data.available()){
            this.available = data.available();
        }
    }
}
