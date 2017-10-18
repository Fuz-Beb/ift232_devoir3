/**
 * 
 */
package banalytics;

/**
 * @author Bebo
 *
 */
public class EtatBuffering extends Etat
{

    /**
     * Constructeur de confort
     * 
     * @param media
     */
    public EtatBuffering(Media media)
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
        throw new ExceptionDevoir2("Seul l'etat PLAYING et PAUSED sont acceptes dans un stop()");
    }

    @Override
    public void pause(long position)
    {
        throw new ExceptionDevoir2("Seul l'etat PLAYING est accepte dans un pause()");
    }

    @Override
    public void resume(long time)
    {
        media.getLog().closeBufferingEntry(time);
    }

    @Override
    public void move(long position)
    {
        throw new ExceptionDevoir2("Seul l'etat PLAYING et PAUSED sont acceptes dans un move()");
    }

    @Override
    public void buffer(long position)
    {
        throw new ExceptionDevoir2("Seul l'etat PLAYING est accepte dans un buffer()");
    }
}