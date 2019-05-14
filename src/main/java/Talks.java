import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Talks {

    private ArrayList<Talk> talks;

    public Talks(){
        talks = new ArrayList<Talk>();
    }

    public void add(Talk talk) {
        this.talks.add(talk);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Talks talks1 = (Talks) o;
        return Objects.equals(talks, talks1.talks);
    }

    @Override public int hashCode() {
        return Objects.hash(talks);
    }

    public String render(LocalTime startingTime) {
        TimeReference time = new TimeReference(startingTime);

        return this.talks.stream().map(track -> track.render(time)).collect(
                Collectors.joining("\n"));
    }
}
