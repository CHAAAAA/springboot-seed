package edu.pku.springbootseed.common.model;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

/**
 * ResultSetHashMap
 *
 * @author wangyc
 * @since 2019/11/10
 */
public class ResultSetHashMap extends HashMap<String, Object> {

    ResultSetHashMap() {
        super();
    }

    public boolean containsKey(Object key) {
        return super.containsKey(upperCaseKey(key)) || super.containsKey(lowerCaseKey(key));
    }

    public Object get(Object key) {
        if (super.containsKey(upperCaseKey(key))) {
            return super.get(upperCaseKey(key));
        } else {
            return super.get(lowerCaseKey(key));
        }
    }

    public Object put(String key, Object value) {
        return super.put(upperCaseKey(key), value);
    }

    public Object remove(Object key) {
        if (super.containsKey(upperCaseKey(key))) {
            return super.remove(upperCaseKey(key));
        } else {
            return super.remove(lowerCaseKey(key));
        }
    }

    @Override
    public Set<String> keySet() {
        Set<String> ks = super.keySet();
        for (String s : ks) {
            s = s.toString().toLowerCase();
        }
        return ks;
    }

    private String upperCaseKey(Object object) {
        return object == null ? null : object.toString().toUpperCase();
    }

    private String lowerCaseKey(Object object) {
        return object == null ? null : object.toString().toLowerCase();
    }
}
