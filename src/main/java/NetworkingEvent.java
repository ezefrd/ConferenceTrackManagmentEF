import java.time.format.DateTimeFormatter;

public class NetworkingEvent implements ExtraSessionEvent {
    @Override public String render(TimeReference startTime) {
        String networkingEvent = startTime
                .getTimeReference()
                .format(DateTimeFormatter.ofPattern("h:mm a"))
                + " Networking Event";
        startTime.setTimeReference(startTime.getTimeReference().plusMinutes(60));
        return networkingEvent;
    }
}
