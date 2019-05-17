import java.util.ArrayList;
import java.util.Objects;

public abstract class AbstractTalks implements SchedulableTalks{
    protected ArrayList<Talk> talks;

    public AbstractTalks(){
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
        AbstractTalks talks1 = (Talks) o;
        return Objects.equals(talks, talks1.talks);
    }

    @Override public int hashCode() {
        return Objects.hash(talks);
    }
}
