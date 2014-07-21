package geek.livingstone.interviews.flipkart.set6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeDirectory {
  private Map<Integer, Employee> idToEmpMapping;
  private EmployeeTrieNode root;

  public EmployeeDirectory() {
    idToEmpMapping = new HashMap<Integer, Employee>();
    root = new EmployeeTrieNode();
  }

  public void addEmployee(int id, String name, String post, int managerId) throws EmployeeExistsException {
    if (idToEmpMapping.containsKey(id))
      throw new EmployeeExistsException(String.format("Employee with id %d already exists.", id));
    Employee manager = idToEmpMapping.get(managerId);
    Employee emp = new Employee(id, name, post, manager);
    if (manager != null) {
      manager.subordinates.add(emp);
    }
    idToEmpMapping.put(id, emp);
    root.insert(emp, 0);
  }

  public void changeManager(int id, int managerId) throws UnknownEmployeeException {
    if (!idToEmpMapping.containsKey(id))
      throw new UnknownEmployeeException(String.format("Employee with id %d does not exist.", id));
    if (!idToEmpMapping.containsKey(managerId))
      throw new UnknownEmployeeException(String.format("Manager with id %d does not exist.", managerId));
    Employee emp = idToEmpMapping.get(id);
    Employee oldManager = emp.manager;
    Employee newManager = idToEmpMapping.get(managerId);
    if (oldManager != null) {
      oldManager.subordinates.remove(emp);
    }
    emp.manager = newManager;
    newManager.subordinates.add(emp);
  }

  public List<Employee> subordinates(int id) throws UnknownEmployeeException {
    if (!idToEmpMapping.containsKey(id))
      throw new UnknownEmployeeException(String.format("Employee with id %d does not exist.", id));
    List<Employee> subordinates = new ArrayList<>();
    LinkedList<Employee> q = new LinkedList<>();
    q.add(idToEmpMapping.get(id));
    while (!q.isEmpty()) {
      Employee cur = q.remove();
      for (Employee sub : cur.subordinates) {
        subordinates.add(sub);
        q.add(sub);
      }
    }
    return subordinates;
  }

  public List<Employee> prefixSearch(String prefix) {
    return root.prefixSearch(prefix, 0);
  }

  static class EmployeeTrieNode {
    boolean isLeafNode;
    Employee emp = null;
    Map<Character, EmployeeTrieNode> edges = new HashMap<>();

    public void insert(Employee emp, int index) {
      if (emp.name.length() == index) {
        this.isLeafNode = true;
        this.emp = emp;
        return;
      }
      if (!edges.containsKey(emp.name.charAt(index)))
        edges.put(emp.name.charAt(index), new EmployeeTrieNode());
      edges.get(emp.name.charAt(index)).insert(emp, index + 1);
    }

    public List<Employee> prefixSearch(String prefix, int index) {
      if (index == prefix.length()) {
        List<Employee> empList = new ArrayList<>();
        findEmployees(empList);
        return empList;
      }
      if (!edges.containsKey(prefix.charAt(index)))
        return new ArrayList<Employee>();
      return edges.get(prefix.charAt(index)).prefixSearch(prefix, index + 1);
    }

    private void findEmployees(List<Employee> empList) {
      if (isLeafNode)
        empList.add(this.emp);
      for (EmployeeTrieNode node : edges.values())
        node.findEmployees(empList);
    }
  }

  static class Employee {
    int id;
    String name;
    String post;
    Employee manager;
    Set<Employee> subordinates;

    public Employee(int id, String name, String post, Employee manager) {
      super();
      this.id = id;
      this.name = name;
      this.post = post;
      this.manager = manager;
      this.subordinates = new HashSet<>();
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + id;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Employee other = (Employee) obj;
      if (id != other.id)
        return false;
      return true;
    }

    @Override
    public String toString() {
      return "Employee [id=" + id + ", name=" + name + ", post=" + post + "]";
    }
  }

  private static void printEmployees(List<Employee> empList) {
    for (Employee emp : empList)
      System.out.println(emp);
  }

  public static void main(String[] args) {
    EmployeeDirectory ed = new EmployeeDirectory();
    try {
      ed.addEmployee(1, "Harish", "CEO", -1);
      ed.addEmployee(2, "Hariharan", "Managing Director", 1);
      ed.addEmployee(3, "Ram Shankar", "Director - Finance", 2);
      ed.addEmployee(4, "Ramanujan", "Admin and Finance Assistant", 3);
      ed.addEmployee(5, "Rajesh Varathan", "Assistant Manager Finance", 3);
      ed.addEmployee(6, "Bhagyam", "Office Assistant", 3);
      ed.addEmployee(7, "Bharath", "Admin and Finance Assistant", 3);
      ed.addEmployee(8, "Venkata Jyothi D", "Director - Algo Trading Technologies", 1);
      ed.addEmployee(9, "Ramakrishnan", "Senior Software Tester", 8);
      ed.addEmployee(10, "Bharani Moorthy", "Lead Software Tester", 8);

      System.out.println("Employees under Harish :");
      printEmployees(ed.subordinates(1));
      System.out.println();
      System.out.println("Employees with prefix Ra :");
      printEmployees(ed.prefixSearch("Ra"));
      System.out.println();
      System.out.println("Employees with prefix Rama :");
      printEmployees(ed.prefixSearch("Rama"));
      System.out.println();
      System.out.println("Employees under Raj :");
      printEmployees(ed.subordinates(2));
      System.out.println();
      System.out.println("Employees with prefix Venk :");
      printEmployees(ed.prefixSearch("Venk"));

    } catch (EmployeeExistsException | UnknownEmployeeException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static class EmployeeExistsException extends Exception {
    private static final long serialVersionUID = 1L;

    public EmployeeExistsException(String message) {
      super(message);
    }
  }

  public static class UnknownEmployeeException extends Exception {
    private static final long serialVersionUID = 1L;

    public UnknownEmployeeException(String message) {
      super(message);
    }
  }
}
