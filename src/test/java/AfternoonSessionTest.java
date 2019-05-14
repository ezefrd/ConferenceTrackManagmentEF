import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

public class AfternoonSessionTest {

    @Test
    public void test_custom_afternoon_seasson_render(){
        //setup:
        Talks afternoonTalks = new Talks();
        afternoonTalks.add(new Talk("Talk 1", new TimeLightning("lightning")));
        afternoonTalks.add(new Talk("Talk 2", new TimeMinutesDimension("min30")));

        afternoonTalks.add(new Talk("Talk 3", new TimeMinutesDimension("min40")));
        afternoonTalks.add(new Talk("Talk 4", new TimeMinutesDimension("min60")));

        AfternoonSession afternoonSession = new AfternoonSession(
                LocalTime.of(14,0),
                LocalTime.of(18,0),
                afternoonTalks
        );
        //when:
        String seassonRendered = afternoonSession.render();
        //then:
        Assert.assertEquals("2:00 PM Talk 1\n" + "\n" + "2:05 PM Talk 2\n"
                + "\n" + "2:35 PM Talk 3\n" + "\n" + "3:15 PM Talk 4\n", seassonRendered);
    }

    @Test
    public void test_afternoon_seasson_render(){
        //setup:
        Talks afternoonTalks = new Talks();
        afternoonTalks.add(new Talk("Talk 1", new TimeLightning("lightning")));
        afternoonTalks.add(new Talk("Talk 2", new TimeMinutesDimension("min30")));

        afternoonTalks.add(new Talk("Talk 3", new TimeMinutesDimension("min40")));
        afternoonTalks.add(new Talk("Talk 4", new TimeMinutesDimension("min60")));

        AfternoonSession afternoonSession = new AfternoonSession(
                afternoonTalks
        );
        //when:
        String seassonRendered = afternoonSession.render();
        //then:
        Assert.assertEquals("1:00 PM Talk 1\n" + "\n" + "1:05 PM Talk 2\n"
                + "\n" + "1:35 PM Talk 3\n" + "\n" + "2:15 PM Talk 4\n", seassonRendered);
    }

}