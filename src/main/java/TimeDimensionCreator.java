import java.lang.reflect.InvocationTargetException;

public interface TimeDimensionCreator {
    public TimeDimension itsTimeDimensionReturnInstanceOrDefault(String timeDimensionCode, Class validDimension, TimeDimension defaultDimension) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException;
}
