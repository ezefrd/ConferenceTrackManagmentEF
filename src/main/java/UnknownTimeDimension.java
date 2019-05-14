import java.time.LocalTime;

public class UnknownTimeDimension implements TimeDimension {
    public UnknownTimeDimension(){

    }

    @Override public boolean equals(Object obj) {
        return obj instanceof UnknownTimeDimension;
    }

    @Override public LocalTime addToTime(TimeReference time) {
        return time.getTimeReference().plusMinutes(0);
    }
}
