package gtug4.model;

import gtug4.model.Comment;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CommentTest extends AppEngineTestCase {

    private Comment model = new Comment();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
