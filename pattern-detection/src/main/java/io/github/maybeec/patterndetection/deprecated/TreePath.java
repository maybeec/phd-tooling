package io.github.maybeec.patterndetection.deprecated;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TreePath implements Cloneable {

    private static final String PREFIX = "(F|f)m_";

    private static final String SEP = "/";

    private String name;

    private String text;

    private TreePath parent;

    private TreePath child;

    private String placeholder;

    private Set<TreePath> substitutions;

    public TreePath(String name) {
        this.name = name;
    }

    public TreePath(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public Set<TreePath> getSubstitutions() {
        return substitutions;
    }

    public boolean matches(TreePath appPath, Map<String, String> listPatterns) {
        if (name.equals(appPath.name)) {
            if (hasChild() && appPath.hasChild()) {
                return child.matches(appPath.child, listPatterns);
            } else if (hasChild() && !appPath.hasChild() || !hasChild() && appPath.hasChild()) {
                return false;
            } else {
                return true;
            }
        } else if (name.matches(PREFIX + appPath.name + "(Star|Op|Plus)?Context") || listPatterns.containsKey(name)
            && listPatterns.get(name).matches(PREFIX + appPath.name + "(Star|Op|Plus)?Context")) {
            if (hasChild() && appPath.hasChild()) {
                return child.matches(appPath.child, listPatterns);
            } else if (hasChild() && !appPath.hasChild() && child.name.equals("FM_PLACEHOLDER")) {
                getRoot().placeholder = child.text;
                if (getRoot().substitutions == null) {
                    getRoot().substitutions = new HashSet<>();
                }
                getRoot().substitutions.add(appPath);
                return true;
            } else if (hasChild() && !appPath.hasChild() || !hasChild() && appPath.hasChild()) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean hasChild() {
        return child != null;
    }

    public TreePath resolve(String childName, String text) {
        TreePath _this = clone();
        if (text != null) {
            _this.child = new TreePath(childName, text);
            _this.child.parent = _this;
        } else {
            _this.child = new TreePath(childName);
            _this.child.parent = _this;
        }
        return _this.child;
    }

    public TreePath getRoot() {
        if (parent != null) {
            return parent.getRoot();
        } else {
            return this;
        }
    }

    public String getLeafValue() {
        if (child != null) {
            return child.getLeafValue();
        } else {
            return name;
        }
    }

    @Override
    protected TreePath clone() {
        TreePath _this = new TreePath(name, text);
        if (parent != null) {
            TreePath _parent = parent.clone();
            _this.parent = _parent;
            _this.parent.child = _this;
        }
        return _this;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return name + (child != null ? SEP + child.toString() : "");
    }
}
