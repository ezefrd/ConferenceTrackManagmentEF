import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConferenceTest {

    Talks talks;

    @Before
    public void setup(){
        talks = readTalksFromTxt();
    }

    @Test
    public void test_conference_rendering(){
        //setup:
        Conference conference = makeMockedConference();
        //when:
        String conferenceAsString = conference.render();
        //then:
        Assert.assertEquals(conferenceAsString, getExpectedConferenceRender());
    }

    private Conference makeMockedConference() {
        ArrayList<Track> trackList = new ArrayList<Track>();
        Talks morningTalksTrack1 = new Talks();
        morningTalksTrack1.add(new Talk("Talk 1", new TimeMinutesDimension("min10")));
        morningTalksTrack1.add(new Talk("Talk 2", new TimeMinutesDimension("min30")));

        morningTalksTrack1.add(new Talk("Talk 3", new TimeMinutesDimension("min40")));
        morningTalksTrack1.add(new Talk("Talk 4", new TimeMinutesDimension("min60")));

        Talks morningTalksTrack2 = new Talks();
        morningTalksTrack2.add(new Talk("Talk 1", new TimeMinutesDimension("min10")));
        morningTalksTrack2.add(new Talk("Talk 2", new TimeMinutesDimension("min30")));

        morningTalksTrack2.add(new Talk("Talk 3", new TimeMinutesDimension("min40")));
        morningTalksTrack2.add(new Talk("Talk 4", new TimeMinutesDimension("min60")));

        Talks afternonnTalksTrack1 = new Talks();
        afternonnTalksTrack1.add(new Talk("Talk 1", new TimeLightning("lightning")));
        afternonnTalksTrack1.add(new Talk("Talk 2", new TimeMinutesDimension("min30")));

        afternonnTalksTrack1.add(new Talk("Talk 3", new TimeMinutesDimension("min40")));
        afternonnTalksTrack1.add(new Talk("Talk 4", new TimeMinutesDimension("min60")));

        Talks afternonnTalksTrack2 = new Talks();
        afternonnTalksTrack2.add(new Talk("Talk 1", new TimeMinutesDimension("min10")));
        afternonnTalksTrack2.add(new Talk("Talk 2", new TimeMinutesDimension("min30")));

        afternonnTalksTrack2.add(new Talk("Talk 3", new TimeMinutesDimension("min40")));
        afternonnTalksTrack2.add(new Talk("Talk 4", new TimeLightning("lightning")));

        Track track1 = new Track(
                "Track1",
                new MorningSession(
                        LocalTime.of(9,0),
                        LocalTime.of(12,0),
                        morningTalksTrack1
                ),
                new AfternoonSession(
                        LocalTime.of(13,0),
                        LocalTime.of(17,0),
                        afternonnTalksTrack1
                )
        );

        Track track2 = new Track(
                "Track2",
                new MorningSession(
                        LocalTime.of(9,0),
                        LocalTime.of(12,0),
                        morningTalksTrack2
                ),
                new AfternoonSession(
                        LocalTime.of(13,0),
                        LocalTime.of(17,0),
                        afternonnTalksTrack2
                )
        );

        trackList.add(track1);
        trackList.add(track2);

        Tracks tracks = new Tracks(trackList);
        return new Conference(tracks);
    }

    private String getExpectedConferenceRender() {
        return "Track1:\n" + "9:00 AM Talk 1\n" + "\n" + "9:10 AM Talk 2\n"
                + "\n" + "9:40 AM Talk 3\n" + "\n" + "10:20 AM Talk 4\n"
                + "12:00 PM Lunch\n" + "1:00 PM Talk 1\n" + "\n"
                + "1:05 PM Talk 2\n" + "\n" + "1:35 PM Talk 3\n" + "\n"
                + "2:15 PM Talk 4\n" + "05:00 PM Networking Event\n" + "\n"
                + "Track2:\n" + "9:00 AM Talk 1\n" + "\n" + "9:10 AM Talk 2\n"
                + "\n" + "9:40 AM Talk 3\n" + "\n" + "10:20 AM Talk 4\n"
                + "12:00 PM Lunch\n" + "1:00 PM Talk 1\n" + "\n"
                + "1:10 PM Talk 2\n" + "\n" + "1:40 PM Talk 3\n" + "\n"
                + "2:20 PM Talk 4\n" + "05:00 PM Networking Event\n";
    }

    private Talks readTalksFromTxt(){
        Talks talks = new Talks();
        TimeDimensionFactory timeDimensionFactory = new TimeDimensionFactory();
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/talks.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                int durationIx = values.length;
                String duration = values[durationIx - 1];
                String title = line.replace(duration, "");
                talks.add(
                        new Talk(
                                title,
                                timeDimensionFactory.createFromCode(new TimeDimensionCode(duration))
                        )
                );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return talks;
    }

}
