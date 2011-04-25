package gtug4.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.util.DateUtil;

import com.google.appengine.api.datastore.Key;

/**
 * 掲示板のスレッドのデータモデル
 * 
 * @author patorash
 *
 */
@Model(schemaVersion = 1)
public class Bbs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    
    private String name;
    
    private String title;
    
    private String body;
    
    private String password;
    
    private Date created = new Date();

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
        Bbs other = (Bbs) obj;
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
     * 投稿者の名前を設定します。
     * 
     * @param name 投稿者の名前
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 投稿者の名前を取得します。
     * 
     * @return 投稿者の名前
     */
    public String getName() {
        return name;
    }

    /**
     * スレッドのタイトルを設定します。
     * 
     * @param title スレッドのタイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * スレッドのタイトルを取得します。
     * 
     * @return スレッドのタイトル
     */
    public String getTitle() {
        return title;
    }

    /**
     * スレッドの本文を設定します。
     * 
     * @param body スレッドの本文
     */
    public void setBody(String body) {
        this.body = body;
    }

    
    /**
     * スレッドの本文を取得します。
     * 
     * @return スレッドの本文
     */
    public String getBody() {
        return body;
    }

    /**
     * スレッドの削除用パスワードを設定します。
     * <p>
     * スレッドのパスワードが設定されていない場合、スレッドの削除を行うことができません。<br>
     * なお、このパスワードは平文で保存されます。
     * </p>
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * スレッド削除用パスワードを取得します。
     * 
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * スレッドの投稿日時を設定します。
     * <p>
     * 新規作成の場合、自動的に投稿日時が設定されます。
     * </p>
     * @param created 投稿日時
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * スレッドの投稿日時を取得します。
     * 
     * @return スレッドの投稿日時
     */
    public Date getCreated() {
        return created;
    }

    /**
     * スレッドの投稿日時を取得します。
     * <p>
     * 投稿日時を<b>yyyy/MM/dd HH:mm:ss</b>の形に整形して返します。
     * </p>
     * @return 投稿日時
     */
    public String getCreatedString() {
        return created != null ?
            DateUtil.toString(created, "yyyy/MM/dd HH:mm:ss") : "";
    }
}
