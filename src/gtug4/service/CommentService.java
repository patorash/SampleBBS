package gtug4.service;

import gtug4.meta.BbsMeta;
import gtug4.meta.CommentMeta;
import gtug4.model.Bbs;
import gtug4.model.Comment;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;


public class CommentService {
    
    private final CommentMeta meta = CommentMeta.get();
    
    private final BbsMeta bbsMeta = BbsMeta.get();
    
    /**
     * 指定スレッドにコメントを投稿します。
     * 
     * @param id スレッドID
     * @param input コメント情報
     * @return 投稿されたコメント情報
     */
    public Comment insert(long id, Map<String, Object> input) {
        Key key = Datastore.createKey(Bbs.class, id);
        Bbs bbs = Datastore.get(bbsMeta, key);
        Comment comment = new Comment();
        BeanUtil.copy(input, comment);
        comment.getBbsRef().setModel(bbs);
        Datastore.put(comment);
        return comment;
    }
    
    /**
     * 指定スレッドの全コメントを取得します。
     * <p>
     * 投稿日時昇順でコメントのリストを取得します。
     * </p>
     * @param id スレッドID
     * @return 指定スレッドの全コメント
     */
    public List<Comment> getAll(long id) {
        Key key = Datastore.createKey(Bbs.class, id);
        return Datastore.query(meta).filter(meta.bbsRef.equal(key)).sort(meta.created.asc).asList();
    }
    
    /**
     * 指定スレッドの全コメントのKeyを取得します。
     * 
     * @param id スレッドID
     * @return 指定スレッドの全コメントのKey
     */
    public List<Key> getAllKey(long id) {
        Key key = Datastore.createKey(Bbs.class, id);
        return Datastore.query(meta).filter(meta.bbsRef.equal(key)).sort(meta.created.asc).asKeyList();
    }
}
