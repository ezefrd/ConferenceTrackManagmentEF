import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TalksTest {

    @Test
    public void test_extract_talks_for_a_time_period(){
        //setup:
        Talks talks = getOriginalTalks();
        //when:
        Talks talksForOneHour = talks.extractTalksFor(new TimeMinutesDimension("60min"));
        //then:
        Assert.assertEquals(getTalksWihoutTheExtracted(), talks);
        Assert.assertEquals(getExtractedTalks(), talksForOneHour);
    }

    @Test
    public void test_the_equality(){
        Assert.assertEquals(getExtractedTalks(), getExtractedTalks());
    }

    private Talks getOriginalTalks() {
        Talks talks = new Talks();
        talks.add(new Talk("title 1", new TimeMinutesDimension("15min")));
        talks.add(new Talk("title 2", new TimeMinutesDimension("35min")));
        talks.add(new Talk("title 3", new TimeMinutesDimension("45min")));
        talks.add(new Talk("title 4", new TimeMinutesDimension("5min")));
        talks.add(new Talk("title 5", new TimeMinutesDimension("10min")));
        return talks;
    }

    private Talks getTalksWihoutTheExtracted() {
        Talks talks = new Talks();
        talks.add(new Talk("title 2", new TimeMinutesDimension("35min")));
        talks.add(new Talk("title 4", new TimeMinutesDimension("5min")));
        talks.add(new Talk("title 5", new TimeMinutesDimension("10min")));
        return talks;
    }

    private Talks getExtractedTalks() {
        Talks talks = new Talks();
        talks.add(new Talk("title 1", new TimeMinutesDimension("15min")));
        talks.add(new Talk("title 3", new TimeMinutesDimension("45min")));
        return talks;
    }

}