import java.time.LocalTime;

public class AfternoonSession extends AbstractSession {

    public AfternoonSession(LocalTime openHour, LocalTime endingHour, Talks talks) {
        super(openHour,endingHour,talks);
    }

    public AfternoonSession(Talks talks) {
        super(LocalTime.of(13,0), LocalTime.of(17,0),talks);
    }

}
