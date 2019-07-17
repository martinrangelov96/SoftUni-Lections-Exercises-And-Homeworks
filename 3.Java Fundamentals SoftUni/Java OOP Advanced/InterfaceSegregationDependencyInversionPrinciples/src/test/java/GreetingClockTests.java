import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p01_system_resources.impl.ConsoleWriter;
import p01_system_resources.impl.GreetingClock;
import p01_system_resources.impl.TimeProviderImpl;
import p01_system_resources.interfaces.GreetingDevice;
import p01_system_resources.interfaces.TimeProvider;
import p01_system_resources.interfaces.Writer;

public class GreetingClockTests {

    @Test
    public void TestMorningGreeting() {
        TimeProvider mockTime = Mockito.mock(TimeProvider.class);
        Mockito.when(mockTime.getCurrentHour()).thenReturn(8);

        Writer mockConsoleWriter = Mockito.mock(ConsoleWriter.class);

        GreetingDevice gd = new GreetingClock(mockTime,
                mockConsoleWriter);

        gd.greeting();

        Mockito.verify(mockConsoleWriter).writeLine("Good morning...");

        Mockito.verify(mockConsoleWriter, Mockito.times(1))
                .writeLine("Good morning...");

    }

}
