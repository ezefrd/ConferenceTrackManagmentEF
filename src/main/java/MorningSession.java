import java.time.LocalTime;

public class MorningSession extends AbstractSession{

    public MorningSession(LocalTime openHour, LocalTime endingHour, SchedulableTalks talks) {
        super(openHour,endingHour,talks);
    }

    public MorningSession(SchedulableTalks talks) {
        super(LocalTime.of(9,0), LocalTime.of(12,0),talks);
    }

}
