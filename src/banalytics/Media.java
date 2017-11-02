package banalytics;

/*
 * Structure repr�sentant un contenu multim�dia.
 */

public abstract class Media
{
    final static String VIDEO = ".mov";
    final static String MUSIC = ".mp3";

    private String author;
    private String title;
    private String type; // MUSIC or VIDEO
    private long duration;
    private MediaLog log;

    /**
     * Con
     * 
     * @param author
     * @param title
     * @param type
     * @param duration
     */
    public Media(String author, String title, String type, long duration)
    {
        this.author = author;
        this.title = title;
        this.type = type;
        this.duration = duration;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Media other = (Media) obj;
        if (author == null)
        {
            if (other.author != null)
                return false;
        }
        else if (!author.equals(other.author))
            return false;
        if (duration != other.duration)
            return false;
        if (title == null)
        {
            if (other.title != null)
                return false;
        }
        else if (!title.equals(other.title))
            return false;
        if (type == null)
        {
            if (other.type != null)
                return false;
        }
        else if (!type.equals(other.type))
            return false;
        return true;
    }

    /**
     * @return the log
     */
    public MediaLog getLog()
    {
        return log;
    }

    /**
     * @param log
     *            the log to set
     */
    public void setLog(MediaLog log)
    {
        this.log = log;
    }

    /**
     * @return the author
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * @param author
     *            the author to set
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the duration
     */
    public long getDuration()
    {
        return duration;
    }

    /**
     * @param duration
     *            the duration to set
     */
    public void setDuration(long duration)
    {
        this.duration = duration;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }
}