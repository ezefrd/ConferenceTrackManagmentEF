import java.time.LocalTime;
import java.util.Objects;

public class TimeLightning implements TimeDimension{
    private Integer minutes;

    public TimeLightning(String timeCode){
        this.minutes = 5;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TimeLightning that = (TimeLightning) o;
        return Objects.equals(minutes, that.minutes);
    }

    @Override public int hashCode() {
        return Objects.hash(minutes);
    }

    @Override public LocalTime addToTime(TimeReference time) {
        return time.getTimeReference().plusMinutes(this.minutes);
    }
}
