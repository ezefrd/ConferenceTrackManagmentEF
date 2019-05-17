import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Talks extends AbstractTalks{

    public Talks(){
        super();
    }

    public String render(LocalTime startingTime) {
        TimeReference time = new TimeReference(startingTime);

        return this.talks.stream().map(track -> track.render(time)).collect(
                Collectors.joining("\n"));
    }

    @Override
    public Talks extractTalksFor(TimeMinutesDimension maxTimeToFit) {
        TimeMinutesDimension accTime = maxTimeToFit;
        Talks talksForContainer = new Talks();
        Talks notUsedTalks;

        Collections.sort(this.talks, new TalksDecresingTimeSorter());

        while(accTime.itsNotZero() && anyTalkFitsInto(accTime)){
            notUsedTalks = new Talks();

            for(Talk talk : this.talks){
                talk.addIfFitsSameToOr(accTime, talksForContainer, notUsedTalks);
            }

            if(this.equals(notUsedTalks)){
                Talk edgeTalk = talks.get(0);
                notUsedTalks.talks.remove(edgeTalk);
                talks.get(0).addIfFitsToOr(accTime,talksForContainer, notUsedTalks);
            }

            this.talks = (ArrayList<Talk>) notUsedTalks.talks.clone();
        }

        return talksForContainer;
    }

    private boolean anyTalkFitsInto(TimeMinutesDimension accTime) {
        boolean anyTalksFits = false;

        for(SchedulableTalk talk : talks){
            if(talk.fitsInto(accTime)){
                anyTalksFits = true;
            }
        }

        return anyTalksFits;
    }
}
