package br.com.traive.desk_booking.domain.user;

public record ActiveUserList(Long id, String name, String email) {
    public ActiveUserList(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}
