package gtug4.service;

import gtug4.model.Bbs;
import gtug4.model.Comment;
import gtug4.service.BbsService;
import gtug4.service.CommentService;

import java.util.HashMap;
import java.util.List;


import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import com.google.appengine.api.datastore.Key;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CommentServiceTest extends AppEngineTestCase {

    private CommentService service = new CommentService();
    private BbsService bbsService = new BbsService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
    
    @Test
    public void insert() throws Exception{
        Bbs bbs = insertBbsResult();
        Comment comment = insertCommentResult(bbs.getKey().getId());
        assertEquals(comment.getName(), "パトラッシュ");
        assertEquals(comment.getBody(), "本文です。");
        assertEquals(comment.getBbsRef().getModel().getTitle(), "test");
    }
    
    @Test
    public void getAll() throws Exception{
        Bbs bbs = insertBbsResult();
        for(int i = 0; i < 5; i++) {
            insertCommentResult(bbs.getKey().getId());
        }
        List<Comment> list = service.getAll(bbs.getKey().getId());
        assertNotNull(list);
        assertEquals(list.size(), 5);
    }
    
    @Test
    public void getAllKey() throws Exception {
        Bbs bbs = insertBbsResult();
        for(int i = 0; i < 5; i++) {
            insertCommentResult(bbs.getKey().getId());
        }
        List<Key> list = service.getAllKey(bbs.getKey().getId());
        assertNotNull(list);
        assertEquals(list.size(), 5);
        
    }
    
    
    private Bbs insertBbsResult() {
        HashMap<String, Object> input = new HashMap<String, Object>();
        input.put("title", "test");
        input.put("name", "パトラッシュ");
        input.put("body", "本文です。");
        input.put("password", "test");
        return bbsService.insert(input);
    }
    
    private Comment insertCommentResult(long id) {
        HashMap<String, Object> input = new HashMap<String, Object>();
        input.put("name", "パトラッシュ");
        input.put("body", "本文です。");
        return service.insert(id, input);
    }

}
