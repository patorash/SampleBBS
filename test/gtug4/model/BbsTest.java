package gtug4.model;

import gtug4.model.Bbs;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BbsTest extends AppEngineTestCase {

    private Bbs model = new Bbs();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
