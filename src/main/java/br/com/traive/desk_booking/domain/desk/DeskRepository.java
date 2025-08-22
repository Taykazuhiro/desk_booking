package br.com.traive.desk_booking.domain.desk;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<Desk,Long> {
    Page<Desk> findAllByAvailableTrue(Pageable pageable);
}
