package br.com.traive.desk_booking.domain.booking;


import br.com.traive.desk_booking.domain.desk.Desk;
import br.com.traive.desk_booking.domain.user.User;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Table(name = "booking")
@Entity(name = "Booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private BookingType bookingType;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "desk_id")
    private Desk desk;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
