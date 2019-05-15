import java.time.LocalTime;

public class UnknownTimeDimension extends AbstractTimeDimension {
    public UnknownTimeDimension(){
        super(0);
    }

    @Override public boolean equals(Object obj) {
        return obj instanceof UnknownTimeDimension;
    }

    @Override public LocalTime addToTime(TimeReference time) {
        return time.getTimeReference().plusMinutes(0);
    }
}
