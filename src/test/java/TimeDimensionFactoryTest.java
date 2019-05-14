import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;

public class TimeDimensionFactoryTest {

    TimeDimensionFactory timeDimensionFactory;

    @Before
    public void setup(){
        timeDimensionFactory = new TimeDimensionFactory();
    }

    @Test
    public void test_create_time_minutes_dimension(){
        //before:
        String timeInText = "45min";
        //when:
        TimeDimension timeMinutesDimension = timeDimensionFactory.createFromCode(new TimeDimensionCode(timeInText));
        //then:
        Assert.assertEquals(new TimeMinutesDimension(timeInText), timeMinutesDimension);
    }

    @Test
    public void test_create_time_lightning_dimension(){
        //before:
        String timeInText = "lightning";
        //when:
        TimeDimension timeLightning = timeDimensionFactory.createFromCode(new TimeDimensionCode(timeInText));
        //then:
        Assert.assertEquals(new TimeLightning("lightning"), timeLightning);
    }

    @Test
    public void test_create_time_unknown_dimension(){
        //before:
        String timeInText = "whatever";
        //when:
        TimeDimension timeLightning = timeDimensionFactory.createFromCode(new TimeDimensionCode(timeInText));
        //then:
        Assert.assertEquals(new UnknownTimeDimension(), timeLightning);
    }

    //@Smell: following tests don't say too much.. should them?
    @Test
    public void test_create_from_code_unknown_fails_illegal_accesse_exception()
            throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //given:
        TimeDimensionCode timeDimensionCode = Mockito.mock(TimeDimensionCode.class);

        Mockito.when(
                timeDimensionCode.itsTimeDimensionReturnInstanceOrDefault(
                        "unknown",
                        TimeMinutesDimension.class,
                        new UnknownTimeDimension())
        ).thenThrow(IllegalAccessException.class);
        //when:
        TimeDimension timeDimension = timeDimensionFactory.createFromCode(timeDimensionCode);
        //then:
        Assert.assertNull(timeDimension);
    }

    @Test
    public void test_create_from_code_unknown_fails_invocation_target_exception()
            throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //given:
        TimeDimensionCode timeDimensionCode = Mockito.mock(TimeDimensionCode.class);

        Mockito.when(
                timeDimensionCode.itsTimeDimensionReturnInstanceOrDefault(
                        "unknown",
                        TimeMinutesDimension.class,
                        new UnknownTimeDimension())
        ).thenThrow(InvocationTargetException.class);
        //when:
        TimeDimension timeDimension = timeDimensionFactory.createFromCode(timeDimensionCode);
        //then:
        Assert.assertNull(timeDimension);
    }

    @Test
    public void test_create_from_code_unknown_fails_instantiation_exception()
            throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //given:
        TimeDimensionCode timeDimensionCode = Mockito.mock(TimeDimensionCode.class);

        Mockito.when(
                timeDimensionCode.itsTimeDimensionReturnInstanceOrDefault(
                        "unknown",
                        TimeMinutesDimension.class,
                        new UnknownTimeDimension())
        ).thenThrow(InstantiationException.class);
        //when:
        TimeDimension timeDimension = timeDimensionFactory.createFromCode(timeDimensionCode);
        //then:
        Assert.assertNull(timeDimension);
    }

}