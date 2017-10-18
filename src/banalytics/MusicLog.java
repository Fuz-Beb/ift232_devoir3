package banalytics;

import java.util.ArrayList;
/*
 * Journal sp�cialis� pour la musique.
 */

public class MusicLog implements MediaLog
{

    ArrayList<LogEntry> entries;

    public MusicLog()
    {
        entries = new ArrayList<LogEntry>();
    }

    @Override
    public void openPlaySegment(long pos)
    {
        entries.add(new LogEntry(LogEntry.OPENPLAY, pos));

    }

    @Override
    public void openPauseEntry(long pos)
    {
        entries.add(new LogEntry(LogEntry.OPENPAUSE, pos));

    }

    @Override
    public void closePauseEntry(long time)
    {
        entries.add(new LogEntry(LogEntry.CLOSEPAUSE, time));

    }

    @Override
    public void closePlaySegment(long pos)
    {
        entries.add(new LogEntry(LogEntry.CLOSEPLAY, pos));

    }

    @Override
    public void openBufferingEntry(long pos)
    {
        entries.add(new LogEntry(LogEntry.OPENBUFFERING, pos));

    }

    @Override
    public void closeBufferingEntry(long time)
    {
        entries.add(new LogEntry(LogEntry.CLOSEBUFFERING, time));

    }

    @Override
    public void addMoveEntry(long pos)
    {
        entries.add(new LogEntry(LogEntry.MOVE, pos));

    }

    public String toString()
    {

        String res = "----------Music usage log----------\n";

        for (LogEntry entry : entries)
        {

            res += entry + "\n";
        }

        return res;

    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MusicLog other = (MusicLog) obj;
        if (entries == null)
        {
            if (other.entries != null)
                return false;
        }
        else if (entries.size() != other.entries.size())
            return false;

        for (int boucle = 0; boucle < entries.size(); boucle++)
        {
            if (!(entries.get(boucle).toString().equals(other.entries.get(boucle).toString())))
                return false;
        }

        return true;
    }
}
