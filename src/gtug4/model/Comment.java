package gtug4.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.util.DateUtil;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private String name;
    
    private String body;
    
    private Date created = new Date();
    
    private ModelRef<Bbs> bbsRef = new ModelRef<Bbs>(Bbs.class);

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Comment other = (Comment) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
    
    /**
     * コメント投稿者の名前を取得します。
     * 
     * @return コメント投稿者名
     */
    public String getName() {
        return name;
    }

    /**
     * コメント投稿者名を設定します。
     * @param name コメント投稿者名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * コメント本文を取得します。
     * 
     * @return コメント本文
     */
    public String getBody() {
        return body;
    }

    /**
     * コメント本文を設定します。
     * @param body コメント本文
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * コメント投稿日時を取得します。
     * 
     * @return コメント投稿日時
     */
    public Date getCreated() {
        return created;
    }

    /**
     * コメント投稿日時を設定します。
     * 
     * @param created コメント投稿日時
     */
    public void setCreated(Date created) {
        this.created = created;
    }
    
    /**
     * コメント投稿日時を取得します。
     * <p>
     * コメント投稿日時を<b>yyyy/MM/dd HH:mm:ss</b>の形に整形して返します。
     * </p>
     * @return コメント投稿日時
     */
    public String getCreatedString() {
        return created != null ?
            DateUtil.toString(created, "yyyy/MM/dd HH:mm:ss") : "";
    }

    /**
     * コメントの親スレッド情報を返します。
     * 
     * @return 親スレッド
     */
    public ModelRef<Bbs> getBbsRef() {
        return bbsRef;
    }
}
