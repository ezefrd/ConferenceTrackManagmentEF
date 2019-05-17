import java.time.LocalTime;

public class AfternoonSession extends AbstractSession {

    public AfternoonSession(LocalTime openHour, LocalTime endingHour, SchedulableTalks talks) {
        super(openHour,endingHour,talks);
    }

    public AfternoonSession(SchedulableTalks talks) {
        super(LocalTime.of(13,0), LocalTime.of(17,0),talks);
    }

}
