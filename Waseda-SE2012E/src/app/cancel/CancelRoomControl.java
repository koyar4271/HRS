package app.cancel;

import java.util.Date;

import app.AppException;
import app.ManagerFactory;
import domain.reservation.ReservationException;
import domain.reservation.ReservationManager;
import domain.room.RoomException;
import domain.room.RoomManager;

public class CancelRoomControl {
	public void cancelReservation(String reservationNumber) throws AppException {
        try {
            // Retrieve the reservation date
            ReservationManager reservationManager = getReservationManager();
            Date stayingDate = reservationManager.cancelReservation(reservationNumber);

            // Update the number of available rooms
            RoomManager roomManager = getRoomManager();
            int availableQtyOfChange = 1; // Increment the available quantity by 1
            roomManager.updateRoomAvailableQty(stayingDate, availableQtyOfChange);
        } catch (ReservationException e) {
            AppException exception = new AppException("Failed to cancel reservation", e);
            exception.getDetailMessages().add(e.getMessage());
            exception.getDetailMessages().addAll(e.getDetailMessages());
            throw exception;
        } catch (RoomException e) {
            AppException exception = new AppException("Failed to cancel reservation", e);
            exception.getDetailMessages().add(e.getMessage());
            exception.getDetailMessages().addAll(e.getDetailMessages());
            throw exception;
        }
    }

    private RoomManager getRoomManager() {
        return ManagerFactory.getInstance().getRoomManager();
    }

    private ReservationManager getReservationManager() {
        return ManagerFactory.getInstance().getReservationManager();
    }

}
