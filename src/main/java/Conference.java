public class Conference {
    private Tracks tracks;

    public Conference(Tracks tracks){
        this.tracks = tracks;
    }

    public String render() {
        return tracks.render();
    }
}
