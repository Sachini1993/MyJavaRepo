package organization;

// abstract parent class for Worker and Group (composite pattern)
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // subclasses implement this
    public abstract void print(String indent);

    // default add and remove - only Group overrides these
    public void add(Component comp) {
        throw new UnsupportedOperationException("Cannot add to a leaf component.");
    }

    public void remove(Component comp) {
        throw new UnsupportedOperationException("Cannot remove from a leaf component.");
    }

    public abstract Worker findWorker(String name);

    public abstract Group findGroup(String name);

    public abstract boolean removeWorker(String name);
}
