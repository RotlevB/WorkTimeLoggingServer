import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private List<LogEntry> entry_log;

    public Employee(int id) {
        this.id = id;
        this.entry_log = new ArrayList<>();
    }

    public boolean newEntry() {
        if (!entry_log.isEmpty() && entry_log.get(entry_log.size() - 1).getExitTime() == null) {
            return false;
        } else {
            entry_log.add(new LogEntry(LocalDateTime.now(), null));
            return true;
        }
    }

    public boolean newExit() {
        if (!entry_log.isEmpty() && entry_log.get(entry_log.size() - 1).getExitTime() == null) {
            entry_log.get(entry_log.size() - 1).setExitTime(LocalDateTime.now());
            return true;
        } else {
            return false;
        }
    }
    
    public List<LogEntry> getEntryLog() {
    	List<LogEntry> copyList = new ArrayList<>(this.entry_log);
    	return copyList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n")
                .append("\t\"employee_id\": ").append(id).append(",\n")
                .append("\t\"dates\": [\n");
        for (LogEntry entry : entry_log) {
            sb.append("\t\t").append(entry.toString()).append(",\n");
        }
        if (!entry_log.isEmpty()) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("\t]\n}");
        return sb.toString();
    }
}
