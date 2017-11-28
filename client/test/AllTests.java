import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClientCallTest.class, ClientConnectionTest.class, ClientLoadTest.class, ClientRequestTest.class,
		ClientSpatialTest.class, ClientVariableTest.class })
public class AllTests {

}
