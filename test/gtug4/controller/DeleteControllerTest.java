package gtug4.controller;

import gtug4.controller.DeleteController;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DeleteControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/delete");
        DeleteController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/delete.jsp"));
    }
}
