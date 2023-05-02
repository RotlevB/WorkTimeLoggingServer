import java.util.HashMap;
import java.util.Map;

public class LogServer {
    private Map<Integer, Employee> employee_map;

    public LogServer() {
        this.employee_map = new HashMap<>();
    }

    public boolean newEntry(int id) {
        if (employee_map.containsKey(id)) {
            return employee_map.get(id).newEntry();
        } else {
            Employee employee = new Employee(id);
            employee_map.put(id, employee);
            return employee.newEntry();
        }
    }

    public boolean newExit(int id) {
        if (employee_map.containsKey(id)) {
            return employee_map.get(id).newExit();
        } else {
            return false;
        }
    }
    
    public String getEmployeeString(int id) {
    	Employee employee = employee_map.get(id);
    	if(employee != null) {
    		return employee.toString();
    	}
    	return "";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (Map.Entry<Integer, Employee> entry : employee_map.entrySet()) {
            sb.append("\t{\n");
            sb.append(String.format("\t\t\"employee_id\": %d,\n", entry.getKey()));
            sb.append("\t\t\"dates\": [\n");
            for (LogEntry entryLog : entry.getValue().getEntryLog()) {
                sb.append("\t\t\t" + entryLog.toString() + ",\n");
            }
            if (!entry.getValue().getEntryLog().isEmpty()) {
                sb.deleteCharAt(sb.lastIndexOf(","));
            }
            sb.append("\t\t]\n");
            sb.append("\t},\n");
        }
        if (!employee_map.isEmpty()) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("]");
        return sb.toString();
    }

}
