import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Talk {
    private String title;
    private TimeDimension timeDimension;

    public Talk(String title, TimeDimension timeDimension) {
        this.title = title;
        this.timeDimension = timeDimension;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Talk talk = (Talk) o;
        return Objects.equals(title, talk.title) && Objects
                .equals(timeDimension, talk.timeDimension);
    }

    @Override public int hashCode() {
        return Objects.hash(title, timeDimension);
    }

    public String render(TimeReference time) {
        String talk = time.getTimeReference().format(DateTimeFormatter.ofPattern("h:mm a")) + " " + this.title + "\n";
        time.setTimeReference(timeDimension.addToTime(time));
        return talk;
    }
}
