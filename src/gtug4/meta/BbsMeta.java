package gtug4.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-04-26 05:08:03")
/** */
public final class BbsMeta extends org.slim3.datastore.ModelMeta<gtug4.model.Bbs> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<gtug4.model.Bbs> body = new org.slim3.datastore.StringAttributeMeta<gtug4.model.Bbs>(this, "body", "body");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<gtug4.model.Bbs, java.util.Date> created = new org.slim3.datastore.CoreAttributeMeta<gtug4.model.Bbs, java.util.Date>(this, "created", "created", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<gtug4.model.Bbs, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<gtug4.model.Bbs, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<gtug4.model.Bbs> name = new org.slim3.datastore.StringAttributeMeta<gtug4.model.Bbs>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<gtug4.model.Bbs> password = new org.slim3.datastore.StringAttributeMeta<gtug4.model.Bbs>(this, "password", "password");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<gtug4.model.Bbs> title = new org.slim3.datastore.StringAttributeMeta<gtug4.model.Bbs>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<gtug4.model.Bbs, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<gtug4.model.Bbs, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final BbsMeta slim3_singleton = new BbsMeta();

    /**
     * @return the singleton
     */
    public static BbsMeta get() {
       return slim3_singleton;
    }

    /** */
    public BbsMeta() {
        super("Bbs", gtug4.model.Bbs.class);
    }

    @Override
    public gtug4.model.Bbs entityToModel(com.google.appengine.api.datastore.Entity entity) {
        gtug4.model.Bbs model = new gtug4.model.Bbs();
        model.setBody((java.lang.String) entity.getProperty("body"));
        model.setCreated((java.util.Date) entity.getProperty("created"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setPassword((java.lang.String) entity.getProperty("password"));
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        gtug4.model.Bbs m = (gtug4.model.Bbs) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("body", m.getBody());
        entity.setProperty("created", m.getCreated());
        entity.setProperty("name", m.getName());
        entity.setProperty("password", m.getPassword());
        entity.setProperty("title", m.getTitle());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        gtug4.model.Bbs m = (gtug4.model.Bbs) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        gtug4.model.Bbs m = (gtug4.model.Bbs) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        gtug4.model.Bbs m = (gtug4.model.Bbs) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        gtug4.model.Bbs m = (gtug4.model.Bbs) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        gtug4.model.Bbs m = (gtug4.model.Bbs) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getBody() != null){
            writer.setNextPropertyName("body");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getBody());
        }
        if(m.getCreated() != null){
            writer.setNextPropertyName("created");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getCreated());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getName());
        }
        if(m.getPassword() != null){
            writer.setNextPropertyName("password");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getPassword());
        }
        if(m.getTitle() != null){
            writer.setNextPropertyName("title");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getTitle());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected gtug4.model.Bbs jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        gtug4.model.Bbs m = new gtug4.model.Bbs();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("body");
        decoder = new org.slim3.datastore.json.Default();
        m.setBody(decoder.decode(reader, m.getBody()));
        reader = rootReader.newObjectReader("created");
        decoder = new org.slim3.datastore.json.Default();
        m.setCreated(decoder.decode(reader, m.getCreated()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        decoder = new org.slim3.datastore.json.Default();
        m.setName(decoder.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("password");
        decoder = new org.slim3.datastore.json.Default();
        m.setPassword(decoder.decode(reader, m.getPassword()));
        reader = rootReader.newObjectReader("title");
        decoder = new org.slim3.datastore.json.Default();
        m.setTitle(decoder.decode(reader, m.getTitle()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
        return m;
    }
}