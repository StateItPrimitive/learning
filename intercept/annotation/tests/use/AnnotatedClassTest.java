package use;

import lib.MyAnnonationsReader;
import org.junit.Before;

/**
 * Created by sbt-yablokov-mv on 06.06.2016.
 */
public class AnnotatedClassTest {
    @Before
    public void setUp() throws Exception {
        MyAnnonationsReader.run(AnnotatedClass.class);
    }
}