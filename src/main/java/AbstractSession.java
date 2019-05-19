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

    /**
     *
     * Afternoon session should override this and manage in other way the extraEvent initial hour.
     * @param extraSessionEvents
     * @return
     */
    @Override public String render(ExtraSessionEvent... extraSessionEvents) {
        StringBuilder sessionRender = new StringBuilder();
        sessionRender.append(this.render());
        TimeReference startingTime = new TimeReference(endingHour);
        for(ExtraSessionEvent extraSessionEvent : extraSessionEvents){
            sessionRender.append(extraSessionEvent.render(startingTime));
            sessionRender.append("\n");
        }

        return sessionRender.toString();
    }

}
