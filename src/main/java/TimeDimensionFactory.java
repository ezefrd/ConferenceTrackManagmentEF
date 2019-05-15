import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

public class TimeDimensionFactory {

    LinkedHashMap<String, Class> timeDimensions;

    public TimeDimensionFactory(){
        timeDimensions = new LinkedHashMap<>();
        timeDimensions.put("min", TimeMinutesDimension.class);
        timeDimensions.put("lightning", TimeLightning.class);
    }

    public AbstractTimeDimension createFromCode(TimeDimensionCreator timeDimensionCreator) {
        AbstractTimeDimension timeDimension = new UnknownTimeDimension();
        for(String key : timeDimensions.keySet()){
            try {
                timeDimension = timeDimensionCreator.itsTimeDimensionReturnInstanceOrDefault(key, timeDimensions.get(key), timeDimension);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        return timeDimension;
    }
}
