import java.time.format.DateTimeFormatter;

public class LunchEvent implements ExtraSessionEvent {
    @Override public String render(TimeReference startTime) {
        String lunchRender = startTime
                .getTimeReference()
                .format(DateTimeFormatter.ofPattern("h:mm a"))
                + " Lunch";
        startTime.setTimeReference(startTime.getTimeReference().plusMinutes(60));
        return lunchRender;
    }
}
