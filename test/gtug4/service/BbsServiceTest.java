package gtug4.service;

import gtug4.model.Bbs;
import gtug4.service.BbsService;

import java.util.HashMap;
import java.util.List;


import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BbsServiceTest extends AppEngineTestCase {

    private BbsService service = new BbsService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
    
    @Test
    public void insert() throws Exception {
        Bbs bbs = insertResult();
        assertThat(bbs, is(notNullValue()));
        Bbs stored = Datastore.get(Bbs.class, bbs.getKey());
        assertEquals(stored.getTitle(), "test");
        assertEquals(stored.getName(), "パトラッシュ");
        assertEquals(stored.getBody(), "本文です。");
        assertEquals(stored.getPassword(), "test");
    }
    
    @Test
    public void getBbs() throws Exception {
        Bbs bbs = insertResult();
        Bbs stored = service.getBbs(bbs.getKey().getId());
        assertEquals(stored.getTitle(), "test");
        assertEquals(stored.getName(), "パトラッシュ");
        assertEquals(stored.getBody(), "本文です。");
        assertEquals(stored.getPassword(), "test");
    }
    
    @Test
    public void getAll() throws Exception {
        for (int i = 0; i < 5; i++) {
            insertResult();
        }
        List<Bbs> list = service.getAll();
        assertNotNull(list);
        assertEquals(list.size(), 5);
    }
    
    @Test
    public void deleteBbs() throws Exception {
        Bbs bbs = insertResult();
        service.deleteBbs(bbs.getKey().getId());
        Bbs deleted = service.getBbs(bbs.getKey().getId());
        assertNull(deleted);
    }
    
    private Bbs insertResult() {
        HashMap<String, Object> input = new HashMap<String, Object>();
        input.put("title", "test");
        input.put("name", "パトラッシュ");
        input.put("body", "本文です。");
        input.put("password", "test");
        return service.insert(input);
    }
}
