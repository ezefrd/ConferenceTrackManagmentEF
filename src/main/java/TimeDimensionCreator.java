import java.lang.reflect.InvocationTargetException;

public interface TimeDimensionCreator {
    public AbstractTimeDimension itsTimeDimensionReturnInstanceOrDefault(String timeDimensionCode, Class validDimension, AbstractTimeDimension defaultDimension) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException;
}
