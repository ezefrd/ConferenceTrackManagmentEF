import java.time.LocalTime;

public interface TimeDimension {
    LocalTime addToTime(TimeReference time);
}
