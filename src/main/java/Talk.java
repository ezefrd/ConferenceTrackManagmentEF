import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Talk {
    private String title;
    private AbstractTimeDimension timeDimension;

    public Talk(String title, AbstractTimeDimension timeDimension) {
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

    public void addIfFitsToOr(TimeMinutesDimension accTime, Talks talksForContainer, Talks notUsedTalks) {
        if(this.timeDimension.fitsTo(accTime)){
            accTime.reduce(this.timeDimension);
            talksForContainer.add(this);
        }else{
            notUsedTalks.add(this);
        }
    }

    public void addIfFitsSameToOr(TimeMinutesDimension accTime, Talks talksForContainer, Talks notUsedTalks) {
        if(this.timeDimension.fitsSame(accTime)){
            accTime.reduce(this.timeDimension);
            talksForContainer.add(this);
        }else{
            notUsedTalks.add(this);
        }
    }
}
