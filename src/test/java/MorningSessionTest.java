import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

public class MorningSessionTest {

    @Test
    public void test_custom_morning_seasson_render(){
        //setup:
        Talks morningTalks = new Talks();
        morningTalks.add(new Talk("Talk 1", new TimeLightning("lightning")));
        morningTalks.add(new Talk("Talk 2", new TimeMinutesDimension("min30")));

        morningTalks.add(new Talk("Talk 3", new TimeMinutesDimension("min40")));
        morningTalks.add(new Talk("Talk 4", new TimeMinutesDimension("min60")));

        MorningSession morningSession = new MorningSession(
                LocalTime.of(10,0),
                LocalTime.of(13,0),
                morningTalks
        );
        //when:
        String seassonRendered = morningSession.render();
        //then:
        Assert.assertEquals("10:00 AM Talk 1\n" + "\n" + "10:05 AM Talk 2\n"
                + "\n" + "10:35 AM Talk 3\n" + "\n" + "11:15 AM Talk 4\n", seassonRendered);
    }

    @Test
    public void test_morning_seasson_render(){
        //setup:
        Talks morningTalks = new Talks();
        morningTalks.add(new Talk("Talk 1", new TimeLightning("lightning")));
        morningTalks.add(new Talk("Talk 2", new TimeMinutesDimension("min30")));

        morningTalks.add(new Talk("Talk 3", new TimeMinutesDimension("min40")));
        morningTalks.add(new Talk("Talk 4", new TimeMinutesDimension("min60")));

        MorningSession morningSession = new MorningSession(
                morningTalks
        );
        //when:
        String seassonRendered = morningSession.render();
        //then:
        Assert.assertEquals("9:00 AM Talk 1\n" + "\n" + "9:05 AM Talk 2\n"
                + "\n" + "9:35 AM Talk 3\n" + "\n" + "10:15 AM Talk 4\n", seassonRendered);
    }

}