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
    protected Media media;
    
    /**
     * Constructeur de confort
     * 
     * @param media
     */
    public Etat(Media media)
    {
        this.media = media;
    }
    
    public abstract void start(int position);
    public abstract void stop(long position);
    public abstract void pause(long position);
    public abstract void resume(long time);
    public abstract void move(long position);
    public abstract void buffer(long position);    
}
