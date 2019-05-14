import java.time.LocalTime;

public class AbstractSession implements Session{
    private LocalTime openHour;
    private LocalTime endingHour;
    private Talks talks;

    public AbstractSession(LocalTime openHour, LocalTime endingHour, Talks talks) {
        this.openHour = openHour;
        this.endingHour = endingHour;
        this.talks = talks;
    }

    @Override public String render() {
        return talks.render(openHour);
    }
}
