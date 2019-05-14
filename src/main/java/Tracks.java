import java.util.ArrayList;
import java.util.stream.Collectors;

public class Tracks {
    private ArrayList<Track> tracks;
    public Tracks(ArrayList<Track> tracks){
        this.tracks = tracks;
    }

    public String render() {
        return this.tracks.stream().map(track -> track.render()).collect(
                Collectors.joining("\n"));
    }
}
