package banalytics;

/*
 * Interface g�n�rale pour un journal.
 */

public interface MediaLog
{

    public void openPlaySegment(long pos);

    public void openPauseEntry(long pos);

    public void closePauseEntry(long time);

    public void closePlaySegment(long pos);

    public void openBufferingEntry(long pos);

    public void closeBufferingEntry(long time);

    public void addMoveEntry(long pos);

    public String toString();

    public boolean equals(Object obj);
}
