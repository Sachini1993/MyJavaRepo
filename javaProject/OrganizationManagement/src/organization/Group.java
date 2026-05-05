package organization;

import java.util.ArrayList;

// Composite class - a group/department that can contain workers and subgroups
public class Group extends Component {

    private String bossName;
    private ArrayList<Component> members;

    public Group(String name, String bossName) {
        super(name);
        this.bossName = bossName;
        this.members = new ArrayList<>();
    }

    public String getBossName() {
        return bossName;
    }

    @Override
    public void add(Component comp) {
        members.add(comp);
    }

    @Override
    public void remove(Component comp) {
        members.remove(comp);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Group: " + name + ", boss's name: " + bossName);

        // print all children with more indentation
        for (Component m : members) {
            if (m instanceof Group) {
                System.out.println(); // empty line before subgroups
            }
            m.print(indent + "    ");
        }
    }

    @Override
    public Worker findWorker(String name) {
        // search through all members recursively
        for (Component m : members) {
            Worker found = m.findWorker(name);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    @Override
    public Group findGroup(String name) {
        // check this group first
        if (this.name.equals(name)) {
            return this;
        }

        // then check subgroups
        for (Component m : members) {
            Group found = m.findGroup(name);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    @Override
    public boolean removeWorker(String name) {
        // check direct children first
        for (int i = 0; i < members.size(); i++) {
            Component m = members.get(i);
            if (m instanceof Worker && m.getName().equals(name)) {
                members.remove(i);
                return true;
            }
        }

        // then search in subgroups recursively
        for (Component m : members) {
            if (m instanceof Group) {
                if (m.removeWorker(name)) {
                    return true;
                }
            }
        }
        return false;
    }
}
