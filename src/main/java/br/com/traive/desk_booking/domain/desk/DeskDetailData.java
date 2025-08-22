package br.com.traive.desk_booking.domain.desk;

public record DeskDetailData(Long id, Integer deskNumber, Boolean available) {
    public DeskDetailData(Desk desk){
        this(desk.getId(), desk.getDeskNumber(),desk.getAvailable());
    }
}
