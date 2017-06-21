package alltests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ element.ElementTest.class, elementfactory.ElementFactoryTest.class, model.MapTest.class })
public class AllTests {

}
