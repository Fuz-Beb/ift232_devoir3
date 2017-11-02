package banalytics;

/**
 * Classe qui représente l'état pause
 */
public class EtatPaused extends Etat
{
    /**
     * Constructeur de confort
     * 
     * @param media
     */
    public EtatPaused(Media media)
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
        media.getLog().closePauseEntry(position);
        media.getLog().closePlaySegment(position);
    }

    @Override
    public void pause(long position)
    {
        throw new ExceptionDevoir2("Seul l'etat PLAYING est accepte dans un pause()");
    }

    @Override
    public void resume(long time)
    {
        media.getLog().closePauseEntry(time);
    }

    @Override
    public void move(long position)
    {
        media.getLog().addMoveEntry(position);
    }

    @Override
    public void buffer(long position)
    {
        throw new ExceptionDevoir2("Seul l'etat PLAYING est accepte dans un buffer()");
    }
}
