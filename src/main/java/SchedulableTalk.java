public interface SchedulableTalk {
    public void addIfFitsToOr(TimeMinutesDimension accTime, Talks talksForContainer, Talks notUsedTalks);
    public void addIfFitsSameToOr(TimeMinutesDimension accTime, Talks talksForContainer, Talks notUsedTalks);
    public boolean fitsInto(TimeMinutesDimension accTime);
}
