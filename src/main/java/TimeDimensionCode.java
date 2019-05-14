import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class TimeDimensionCode implements TimeDimensionCreator {
    private String timeCode;
    public TimeDimensionCode(String timeCode){
        this.timeCode = timeCode;
    }

    @Override
    public TimeDimension itsTimeDimensionReturnInstanceOrDefault(String timeCode, Class validDimension, TimeDimension defaultDimension)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        if(this.timeCode.endsWith(timeCode)){
            Constructor constructor = validDimension.getDeclaredConstructor(String.class);
            return (TimeDimension) constructor.newInstance(this.timeCode);
        }

        return defaultDimension;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TimeDimensionCode that = (TimeDimensionCode) o;
        return Objects.equals(timeCode, that.timeCode);
    }

    @Override public int hashCode() {
        return Objects.hash(timeCode);
    }
}
