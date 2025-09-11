package br.com.traive.desk_booking.domain.booking.validation;

import br.com.traive.desk_booking.domain.booking.Booking;
import br.com.traive.desk_booking.domain.booking.BookingDetailsData;
import br.com.traive.desk_booking.domain.booking.BookingRepository;
import br.com.traive.desk_booking.domain.booking.CreateBookData;
import br.com.traive.desk_booking.domain.booking.validation.business.IBookingCancelling;
import br.com.traive.desk_booking.domain.booking.validation.business.IBookingValidation;
import br.com.traive.desk_booking.domain.desk.DeskRepository;
import br.com.traive.desk_booking.domain.user.UserRepository;
import br.com.traive.desk_booking.infra.exception.ValidationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private DeskRepository deskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private List<IBookingValidation> bookingValidationList;

    @Autowired
    private List<IBookingCancelling> cancellingValidationList;

    public BookingDetailsData book (@Valid CreateBookData data){
        var deskExist = deskRepository.getReferenceById(data.idDesk());
        if (!deskRepository.existsById(data.idDesk())){
            throw new ValidationException("Mesa informada não existe");
        }
        if (deskExist.getAvailable().equals(false)){
                throw new ValidationException("Mesa indisponível.");
        }
        bookingValidationList.forEach(v -> v.validate(data));

        var user = userRepository.getReferenceById(data.idUsuario());
        var booking = new Booking(null, data.bookingDate(),data.startTime(),data.endTime(),data.bookingType(),deskExist,user);
        bookingRepository.save(booking);
        return new BookingDetailsData(booking);

    }

//    public CancelBookingData cancel (@Valid CancelBookData data){
//        //verificar se a reserva existe
//        //verificar regras de negocio
//    }


}


