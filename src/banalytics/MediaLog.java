package banalytics;

import java.util.ArrayList;

/*
 * Interface g�n�rale pour un journal.
 */

public abstract class MediaLog
{
    private ArrayList<LogEntry> entries;

    public MediaLog()
    {
        entries = new ArrayList<LogEntry>();
    }

    public void openPlaySegment(long pos)
    {
        entries.add(new LogEntry(LogEntry.OPENPLAY, pos));

    }

    public void openPauseEntry(long pos)
    {
        entries.add(new LogEntry(LogEntry.OPENPAUSE, pos));

    }

    public void closePauseEntry(long time)
    {
        entries.add(new LogEntry(LogEntry.CLOSEPAUSE, time));

    }

    public void closePlaySegment(long pos)
    {
        entries.add(new LogEntry(LogEntry.CLOSEPLAY, pos));

    }

    public void openBufferingEntry(long pos)
    {
        entries.add(new LogEntry(LogEntry.OPENBUFFERING, pos));

    }

    public void closeBufferingEntry(long time)
    {
        entries.add(new LogEntry(LogEntry.CLOSEBUFFERING, time));

    }

    public void addMoveEntry(long pos)
    {
        entries.add(new LogEntry(LogEntry.MOVE, pos));

    }

    public abstract String toString();

    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MediaLog other = (MediaLog) obj;
        if (getEntries() == null)
        {
            if (other.getEntries() != null)
                return false;
        }
        else if (getEntries().size() != other.getEntries().size())
            return false;

        for (int boucle = 0; boucle < getEntries().size(); boucle++)
        {
            if (!(getEntries().get(boucle).toString().equals(other.getEntries().get(boucle).toString())))
                return false;
        }

        return true;
    }

    /**
     * @return the entries
     */
    public ArrayList<LogEntry> getEntries()
    {
        return entries;
    }

    /**
     * @param entries
     *            the entries to set
     */
    public void setEntries(ArrayList<LogEntry> entries)
    {
        this.entries = entries;
    }
}
