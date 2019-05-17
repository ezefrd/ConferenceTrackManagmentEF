import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

public class MorningSessionTest {

    @Test
    public void test_custom_morning_seasson_render(){
        //setup:
        Talks morningTalks = new Talks();
        morningTalks.add(new Talk("Talk 1", new TimeLightning("lightning")));
        morningTalks.add(new Talk("Talk 2", new TimeMinutesDimension("30min")));

        morningTalks.add(new Talk("Talk 3", new TimeMinutesDimension("40min")));
        morningTalks.add(new Talk("Talk 4", new TimeMinutesDimension("60min")));

        MorningSession morningSession = new MorningSession(
                LocalTime.of(10,0),
                LocalTime.of(11,0),
                morningTalks
        );
        //when:
        String seassonRendered = morningSession.render();
        //then:
        Assert.assertEquals("10:00 AM Talk 4 60min\n", seassonRendered);
    }

    @Test
    public void test_morning_seasson_render(){
        //setup:
        Talks morningTalks = new Talks();
        morningTalks.add(new Talk("Talk 1", new TimeLightning("lightning")));
        morningTalks.add(new Talk("Talk 2", new TimeMinutesDimension("30min")));

        morningTalks.add(new Talk("Talk 3", new TimeMinutesDimension("40min")));
        morningTalks.add(new Talk("Talk 4", new TimeMinutesDimension("60min")));

        MorningSession morningSession = new MorningSession(
                morningTalks
        );
        //when:
        String seassonRendered = morningSession.render();
        //then:
        Assert.assertEquals("9:00 AM Talk 4 60min\n" + "\n"
                + "10:00 AM Talk 3 40min\n" + "\n" + "10:40 AM Talk 2 30min\n"
                + "\n" + "11:10 AM Talk 1 5min\n", seassonRendered);
    }

}