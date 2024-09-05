package org.apache.coyote.session;

import java.util.HashMap;
import java.util.Map;

public class Session {

    private final String id;
    private final Map<String, Object> values;

    public Session(final String id) {
        this.id = id;
        this.values = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public Object getAttribute(final String name) {
        if (values.containsKey(name)) {
            return values.get(name);
        }
        throw new IllegalArgumentException("존재하지 않습니다.");
    }

    public void setAttribute(final String name, final Object value) {
        values.put(name, value);
    }

    public void removeAttribute(final String name) {
        values.remove(name);
    }

    public void invalidate() {
        values.clear();
    }
}