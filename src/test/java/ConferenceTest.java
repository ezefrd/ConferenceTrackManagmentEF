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
        Assert.assertEquals(getExpectedConferenceRender(), conferenceAsString);
    }

    @Test
    public void test_create_conference_structure_adding_the_talks_and_render_the_result(){
        //setup:
        Talks completeSetOfTalks = readTalksFromTxt();
        ArrayList<Track> trackList = new ArrayList<Track>();

        Track track1 = new Track(
                "Track1",
                new MorningSession(
                        LocalTime.of(9,0),
                        LocalTime.of(12,0),
                        completeSetOfTalks
                ),
                new AfternoonSession(
                        LocalTime.of(13,0),
                        LocalTime.of(17,0),
                        completeSetOfTalks
                )
        );

        Track track2 = new Track(
                "Track2",
                new MorningSession(
                        LocalTime.of(9,0),
                        LocalTime.of(12,0),
                        completeSetOfTalks
                ),
                new AfternoonSession(
                        LocalTime.of(13,0),
                        LocalTime.of(17,0),
                        completeSetOfTalks
                )
        );

        trackList.add(track1);
        trackList.add(track2);

        Tracks tracks = new Tracks(trackList);
        Conference conference = new Conference(tracks);

        //when:
        String conferenceStructure = conference.render();

        //then:
        Assert.assertEquals(getEpectedConferenceStructure(), conferenceStructure);

    }

    private String getEpectedConferenceStructure() {
        return "Track1:\n"
                + "9:00 AM Writing Fast Tests Against Enterprise Rails  60min\n"
                + "\n" + "10:00 AM Communicating Over Distance  60min\n" + "\n"
                + "11:00 AM Rails Magic  60min\n" + "12:00 PM Lunch\n"
                + "1:00 PM Ruby on Rails: Why We Should Move On  60min\n" + "\n"
                + "2:00 PM Ruby on Rails Legacy App Maintenance  60min\n" + "\n"
                + "3:00 PM Overdoing it in Python  45min\n" + "\n"
                + "3:45 PM Ruby Errors from Mismatched Gem Versions  45min\n"
                + "\n" + "4:30 PM Lua for the Masses  30min\n"
                + "05:00 PM Networking Event\n" + "\n" + "Track2:\n"
                + "9:00 AM Common Ruby Errors  45min\n" + "\n"
                + "9:45 AM Accounting-Driven Development  45min\n" + "\n"
                + "10:30 AM Pair Programming vs Noise  45min\n" + "\n"
                + "11:15 AM Clojure Ate Scala (on my project)  45min\n"
                + "12:00 PM Lunch\n" + "1:00 PM Woah  30min\n" + "\n"
                + "1:30 PM Sit Down and Write  30min\n" + "\n"
                + "2:00 PM Programming in the Boondocks of Seattle  30min\n"
                + "\n"
                + "2:30 PM Ruby vs. Clojure for Back-End Development  30min\n"
                + "\n" + "3:00 PM A World Without HackerNews  30min\n" + "\n"
                + "3:30 PM User Interface CSS in Rails Apps  30min\n" + "\n"
                + "4:00 PM Rails for Python Developers  5min\n"
                + "05:00 PM Networking Event\n";
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
        return "Track1:\n" + "9:00 AM Talk 4 60min\n" + "\n"
                + "10:00 AM Talk 3 40min\n" + "\n" + "10:40 AM Talk 2 30min\n"
                + "\n" + "11:10 AM Talk 1 10min\n" + "12:00 PM Lunch\n"
                + "1:00 PM Talk 4 60min\n" + "\n" + "2:00 PM Talk 3 40min\n"
                + "\n" + "2:40 PM Talk 2 30min\n" + "\n"
                + "3:10 PM Talk 1 5min\n" + "05:00 PM Networking Event\n" + "\n"
                + "Track2:\n" + "9:00 AM Talk 4 60min\n" + "\n"
                + "10:00 AM Talk 3 40min\n" + "\n" + "10:40 AM Talk 2 30min\n"
                + "\n" + "11:10 AM Talk 1 10min\n" + "12:00 PM Lunch\n"
                + "1:00 PM Talk 3 40min\n" + "\n" + "1:40 PM Talk 2 30min\n"
                + "\n" + "2:10 PM Talk 1 10min\n" + "\n"
                + "2:20 PM Talk 4 5min\n" + "05:00 PM Networking Event\n";
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
