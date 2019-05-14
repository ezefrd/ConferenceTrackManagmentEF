import java.time.LocalTime;

public class TimeReference {
    private LocalTime timeReference;
    public TimeReference(LocalTime startingTime) {
        this.timeReference = startingTime;
    }

    public void setTimeReference(LocalTime time){
        this.timeReference = time;
    }

    public LocalTime getTimeReference(){
        return this.timeReference;
    }

}
