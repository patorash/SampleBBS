package gtug4.controller;

import gtug4.controller.ReadController;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ReadControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/read");
        ReadController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/read.jsp"));
    }
}
