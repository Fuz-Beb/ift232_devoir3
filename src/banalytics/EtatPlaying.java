/**
 * 
 */
package banalytics;

/**
 * @author Bebo
 *
 */
public class EtatPlaying extends Etat
{

    /**
     * Constructeur de confort
     * 
     * @param media
     */
    public EtatPlaying(Media media)
    {
        super(media);
    }

    @Override
    public void start(int position)
    {
        throw new ExceptionDevoir2("Seul l'etat INITIAL et STOPPED sont acceptes dans un start()");
    }

    @Override
    public void stop(long position)
    {
        media.getLog().closePlaySegment(position);
    }

    @Override
    public void pause(long position)
    {
        media.getLog().openPauseEntry(position);
    }

    @Override
    public void resume(long position)
    {
        throw new ExceptionDevoir2("Seul l'etat PAUSED et BUFFERING sont acceptes dans un resume()");
    }
    
    @Override
    public void move(long position)
    {
        media.getLog().addMoveEntry(position);
        media.getLog().openPauseEntry(position);
    }

    @Override
    public void buffer(long position)
    {
        media.getLog().openBufferingEntry(position);
    }
}
