package app.cancel;

import app.AppException;

public class CancelRoomForm {
	private CancelRoomControl cancelRoomControl = new CancelRoomControl();

    private String reservationNumber;

    private CancelRoomControl getCancelRoomControl() {
        return cancelRoomControl;
    }

    public void cancelReservation() throws AppException {
        CancelRoomControl cancelRoomControl = getCancelRoomControl();
        try {
            cancelRoomControl.cancelReservation(reservationNumber);
            System.out.println("Reservation cancellation has been completed.");
        } catch (AppException e) {
            System.err.println("Error during reservation cancellation: " + e.getMessage());
            throw e;
        }
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
}
