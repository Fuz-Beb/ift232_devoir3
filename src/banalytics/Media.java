package banalytics;

/*
 * Structure repr�sentant un contenu multim�dia.
 */

public class Media
{
    final static String VIDEO = ".mov";
    final static String MUSIC = ".mp3";

    private String author;
    private String title;
    private String type; // MUSIC or VIDEO
    private long duration;

    public String getType()
    {
        return type;
    }

    public Media(String author, String title, String type, long duration)
    {
        this.author = author;
        this.title = title;
        this.type = type;
        this.duration = duration;
    }

    public String toString()
    {

        String res = "";

        if (type == MUSIC)
        {

            res += "Audio: ";
        }
        else
        {
            res += "Video: ";
        }

        long hours = duration / (3600 * 1000);
        long minutes = (duration % (3600 * 1000)) / (60 * 1000);
        long seconds = ((duration) % (60 * 1000)) / 1000;
        res += author + ": " + title + " (" + hours + "h" + minutes + "m" + seconds + "s)";

        return res;

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + (int) (duration ^ (duration >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
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
}
