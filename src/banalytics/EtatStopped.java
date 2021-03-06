package banalytics;

/**
 * Classe qui représente l'état stop
 */
public class EtatStopped extends Etat
{
    /**
     * Constructeur de confort
     * 
     * @param media
     */
    public EtatStopped(Media media)
    {
        super(media);
    }

    @Override
    public void start(int position)
    {
        media.getLog().openPlaySegment(position);
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
        throw new ExceptionDevoir2("Seul l'etat PAUSED et BUFFERING sont acceptes dans un resume()");
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