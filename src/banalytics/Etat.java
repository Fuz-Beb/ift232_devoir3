/**
 * 
 */
package banalytics;

/**
 * @author Bebo
 *
 */
public abstract class Etat
{
    private Media media;
    
    /**
     * Constructeur de confort
     * 
     * @param media
     */
    public Etat(Media media)
    {
        this.setMedia(media);
    }
    
    public abstract void start(int position);
    public abstract void stop(long position);
    public abstract void pause(long position);
    public abstract void resume(long time);
    public abstract void move(long position);
    public abstract void buffer(long position);

    /**
     * @return the media
     */
    public Media getMedia()
    {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(Media media)
    {
        this.media = media;
    }
    
}
