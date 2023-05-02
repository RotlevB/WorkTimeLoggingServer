import java.time.LocalDateTime;

public class LogEntry {
    private LocalDateTime entry_time;
    private LocalDateTime exit_time;

    public LogEntry() {
        this.entry_time = null;
        this.exit_time = null;
    }

    public LogEntry(LocalDateTime entry_time, LocalDateTime exit_time) {
        this.entry_time = entry_time;
        this.exit_time = exit_time;
    }

    public LocalDateTime getEntryTime() {
        return entry_time;
    }

    public void setEntryTime(LocalDateTime entry_time) {
        this.entry_time = entry_time;
    }

    public LocalDateTime getExitTime() {
        return exit_time;
    }

    public void setExitTime(LocalDateTime exit_time) {
        this.exit_time = exit_time;
    }

    @Override
    public String toString() {
    	if(exit_time == null) {
    		if(entry_time == null) {
    			return "";
    		}
    		return "[\"" + entry_time + "\"] # Only enter time was received";
    	}
        return "[\"" + entry_time + "\", \"" + exit_time + "\"]";
    }
}
