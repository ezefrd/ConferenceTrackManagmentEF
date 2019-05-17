import java.util.Comparator;

public class TalksDecresingTimeSorter implements Comparator<Talk> {
    @Override public int compare(Talk talk1, Talk talk2) {
        if(talk1.isShorterThan(talk2)){
            return 1;
        }else{
            return -1;
        }
    }
}
