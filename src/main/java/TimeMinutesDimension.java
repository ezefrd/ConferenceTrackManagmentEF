import java.time.LocalTime;
import java.util.Objects;

public class TimeMinutesDimension implements TimeDimension{
    private Integer minutes;

    public TimeMinutesDimension(String timeCode){
        this.minutes = Integer.parseInt(timeCode.replace("min", ""));
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TimeMinutesDimension that = (TimeMinutesDimension) o;
        return Objects.equals(minutes, that.minutes);
    }

    @Override public int hashCode() {
        return Objects.hash(minutes);
    }

    @Override public LocalTime addToTime(TimeReference time) {
        return time.getTimeReference().plusMinutes(this.minutes);
    }
}
