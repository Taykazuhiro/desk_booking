package br.com.traive.desk_booking.domain.desk;

public record DeskListData(Long id, Integer deskNumber, Boolean available) {
    public DeskListData(Desk desk){
        this(desk.getId(),desk.getDeskNumber(), desk.getAvailable());
    }
}
