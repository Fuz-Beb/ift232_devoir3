package banalytics;

/**
 * Classe qui représente le média music
 */
public class MediaMusic extends Media
{
    /**
     * Constructeur de confort
     * 
     * @param author
     * @param title
     * @param type
     * @param duration
     */
    public MediaMusic(String author, String title, String type, long duration)
    {
        super(author, title, type, duration);
        setLog(new MusicLog());
    }

    @Override
    public String toString()
    {
        String res = "";
        res += "Audio: ";

        long hours = getDuration() / (3600 * 1000);
        long minutes = (getDuration() % (3600 * 1000)) / (60 * 1000);
        long seconds = ((getDuration()) % (60 * 1000)) / 1000;
        res += getAuthor() + ": " + getTitle() + " (" + hours + "h" + minutes + "m" + seconds + "s)";

        return res;
    }
}