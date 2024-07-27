package africa.semicolon.com.eventBookingApp.exceptions;

public class TicketNotAvailableException extends EventBookingAppExceptions {
    public TicketNotAvailableException(String ticketIsNotAvailable) {
        super(ticketIsNotAvailable);
    }
}
