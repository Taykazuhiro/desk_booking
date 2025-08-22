package br.com.traive.desk_booking.domain.user;


import br.com.traive.desk_booking.domain.booking.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean active;

    @OneToMany(mappedBy = "usuario")
    private List<Booking> booking;

    public User(DataUserRegister data){
        this.active=true;
        this.name= data.name();
        this.email= data.email();
        this.password = data.password();
    }
}
