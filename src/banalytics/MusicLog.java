package banalytics;

public class MusicLog extends MediaLog
{

    public String toString()
    {

        String res = "----------Music usage log----------\n";

        for (LogEntry entry : getEntries())
        {

            res += entry + "\n";
        }

        return res;

    }
}
