package service;

import model.Guest;
import model.Hotel;
import model.Room;

import java.time.LocalDate;

public class BookingService {

    public boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
        // TODO: Реализовать проверку доступности номера
        return false;
    }

    public boolean bookRoom(Hotel hotel, Room room, Guest guest, LocalDate checkIn, LocalDate checkOut) {
        // TODO: Реализовать логику бронирования номера
        return false;
    }

    public double calculatePrice(Room room, LocalDate checkIn, LocalDate checkOut) {
        // TODO: Реализовать расчет стоимости
        return 0.0;
    }
}
