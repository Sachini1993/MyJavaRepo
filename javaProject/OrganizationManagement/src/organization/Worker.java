package organization;

// Leaf class - represents a single worker in the organization
public class Worker extends Component {

    private String role; // optional role like "secretary"

    public Worker(String name) {
        super(name);
        this.role = null;
    }

    // constructor with role
    public Worker(String name, String role) {
        super(name);
        this.role = role;
    }

    @Override
    public void print(String indent) {
        if (role != null && !role.isEmpty()) {
            System.out.println(indent + "Worker: " + name + " (" + role + ")");
        } else {
            System.out.println(indent + "Worker: " + name);
        }
    }

    @Override
    public Worker findWorker(String name) {
        if (this.name.equals(name)) {
            return this;
        }
        return null;
    }

    // worker cant contain groups so just return null
    @Override
    public Group findGroup(String name) {
        return null;
    }

    @Override
    public boolean removeWorker(String name) {
        return false;
    }
}
