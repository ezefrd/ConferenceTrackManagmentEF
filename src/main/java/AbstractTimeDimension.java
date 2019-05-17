public abstract class AbstractTimeDimension implements TimeDimension{
    protected Integer minutes;

    public AbstractTimeDimension(Integer minutes){
        this.minutes = minutes;
    }

    public boolean fitsTo(AbstractTimeDimension accTime) {
        return this.minutes <= accTime.minutes;
    }

    public boolean fitsSame(AbstractTimeDimension accTime) {
        return this.minutes == accTime.minutes;
    }

    public void reduce(AbstractTimeDimension timeDimension) {
        this.minutes -= timeDimension.minutes;
    }

    public boolean itsNotZero() {
        return this.minutes != 0;
    }

    public String render() {
        return this.minutes + "min";
    }
}
