import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * The idea of this class is to be an implementation that allow the user to
 * extract talks for conference using a next fit decreasing order algorithm
 *
 * As I'm using the AbstractClass with SchedulableTalks, I can create others
 * implementations that uses others algorithms to make the extract for a time slot
 */
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

        //This implementation of talks use decresing time sorting.
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
