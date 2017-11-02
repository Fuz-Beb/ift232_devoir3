package banalytics;

/*
 * Journal sp�cialis� pour les vid�os.
 */

public class VideoLog extends MediaLog
{

    public String toString()
    {

        String res = "----------Video usage log----------\n";

        for (LogEntry entry : getEntries())
        {
            res += entry + "\n";
        }

        return res;

    }
}
