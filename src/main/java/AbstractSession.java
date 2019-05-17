import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class AbstractSession implements Session{
    private LocalTime openHour;
    private LocalTime endingHour;
    private Talks talks;

    public AbstractSession(LocalTime openHour, LocalTime endingHour, SchedulableTalks talks) {
        this.openHour = openHour;
        this.endingHour = endingHour;
        Long minutesForThisSession = openHour.until(endingHour, ChronoUnit.MINUTES);
        this.talks = talks.extractTalksFor(new TimeMinutesDimension(minutesForThisSession.toString()));
    }

    @Override public String render() {
        return talks.render(openHour);
    }
}
