package service;

import model.Hotel;
import model.Room;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class BookingService {

    Map<Integer, Map<LocalDate, LocalDate>> allReservations = new HashMap<>();

    public boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
        Map<LocalDate, LocalDate> reservations = allReservations.get(room.id());
        if (reservations == null) {
            return true;
        }
        for (Map.Entry<LocalDate, LocalDate> entry : reservations.entrySet()) {
            boolean datesAfterReservation = entry.getKey().isAfter(checkIn) && entry.getValue().isAfter(checkOut);
            boolean datesBeforeReservation = entry.getKey().isBefore(checkIn) && entry.getValue().isBefore(checkOut);
            if (!(datesAfterReservation || datesBeforeReservation)) {
                return false;
            }
        }
        return true;
    }

    public boolean bookRoom(Hotel hotel, Room room, LocalDate checkIn, LocalDate checkOut) {
        if (!isRoomAvailable(room, checkIn, checkOut)) {
            return false;
        }
        Map<LocalDate, LocalDate> reservations = allReservations.computeIfAbsent(room.id(), k -> new HashMap<>());
        reservations.put(checkIn, checkOut);
        return true;
    }

    public double calculatePrice(Room room, LocalDate checkIn, LocalDate checkOut) {
        return ChronoUnit.DAYS.between(checkIn, checkOut) * room.pricePerNight();
    }
}
