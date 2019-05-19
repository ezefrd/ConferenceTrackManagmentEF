public class Track {
    private String trackTitle;
    private Session morningSession;
    private Session afternoonSession;


    public Track(String title, Session morningSession, Session afternoonSession){
        this.trackTitle = title;
        this.morningSession = morningSession;
        this.afternoonSession = afternoonSession;
    }

    public String render() {
        StringBuilder trackBuilder = new StringBuilder();
        trackBuilder.append(trackTitle + ":\n");
        trackBuilder.append(morningSession.render(new LunchEvent()));
        trackBuilder.append(afternoonSession.render(new NetworkingEvent()));
        return trackBuilder.toString();

    }
}
