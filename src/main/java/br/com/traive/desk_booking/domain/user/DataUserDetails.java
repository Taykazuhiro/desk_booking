package br.com.traive.desk_booking.domain.user;

public record DataUserDetails(Long id, String name, String email) {
    public DataUserDetails(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
