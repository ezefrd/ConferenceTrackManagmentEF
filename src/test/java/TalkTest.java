import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TalkTest {

    @Test
    public void test_add_talk_to_usable_container_if_it_fits_time_dimension(){
        //setup:
        Talks usableTalks = new Talks();
        Talks notUsableTalks = new Talks();
        Talk talk = new Talk("title", new TimeMinutesDimension("30"));

        //when:
        talk.addIfFitsToOr(new TimeMinutesDimension("40"), usableTalks, notUsableTalks);
        //then:
        Talks expectedTalks = new Talks();
        expectedTalks.add(talk);
        Assert.assertEquals(expectedTalks, usableTalks);
        Assert.assertEquals(new Talks(), notUsableTalks);
    }

    @Test
    public void test_add_talk_to_not_usable_container_if_it_not_fits_time_dimension(){
        //setup:
        Talks usableTalks = new Talks();
        Talks notUsableTalks = new Talks();
        Talk talk = new Talk("title", new TimeMinutesDimension("30"));

        //when:
        talk.addIfFitsToOr(new TimeMinutesDimension("20"), usableTalks, notUsableTalks);
        //then:
        Talks expectedTalks = new Talks();
        expectedTalks.add(talk);
        Assert.assertEquals(expectedTalks, notUsableTalks);
        Assert.assertEquals(new Talks(), usableTalks);
    }

    @Test
    public void test_talk1_is_shorter_than_talk2(){
        //setup:
        Talk talk1 = new Talk("talk 1", new TimeMinutesDimension("30"));
        Talk talk2 = new Talk("talk 1", new TimeMinutesDimension("30"));
        //when
        boolean talk1IsShorterThan2 = talk1.isShorterThan(talk2);
        //then:
        Assert.assertTrue(talk1IsShorterThan2);
    }

}