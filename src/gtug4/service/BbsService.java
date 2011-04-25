package gtug4.service;

import gtug4.meta.BbsMeta;
import gtug4.model.Bbs;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;


public class BbsService {

    private final BbsMeta meta = BbsMeta.get();
    
    /**
     * スレッドの新規登録を行います。
     * 
     * @param input
     * @return 登録されたスレッド情報
     */
    public Bbs insert(Map<String, Object> input) {
        Bbs bbs = new Bbs();
        BeanUtil.copy(input, bbs);
        Datastore.put(bbs);
        return bbs;
    }
    
    /**
     * 指定されたスレッドの情報を返します。
     * @param id スレッドのID
     * @return 指定されたスレッドの情報
     */
    public Bbs getBbs(long id) {
        Key key = Datastore.createKey(meta, id);
        return Datastore.getOrNull(meta, key);
    }
    
    /**
     * 全スレッドのリストを返します。
     * 
     * @return 全スレッド
     */
    public List<Bbs> getAll() {
        return Datastore.query(meta).sort(meta.created.asc).asList();
    }
    
    /**
     * 指定されたスレッドを削除します。
     * <p>
     * 指定されたスレッドに付いているコメントも全て削除します。
     * </p>
     * @param id スレッドID
     */
    public void deleteBbs(long id) {
        Key key = Datastore.createKey(meta, id);
        CommentService commentService = new CommentService();
        List<Key> commentKeys = commentService.getAllKey(id);
        // グローバルトランザクションを使って整合性を保つ
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        gtx.delete(key);
        gtx.delete(commentKeys);
        gtx.commit();
    }
}
