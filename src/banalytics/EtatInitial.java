/**
 * 
 */
package banalytics;

/**
 * @author Bebo
 *
 */
public class EtatInitial extends Etat
{

    /**
     * Constructeur de confort
     * 
     * @param media
     */
    public EtatInitial(Media media)
    {
        super(media);
    }

    @Override
    public void start(int position)
    {
        getMedia().getLog().openPlaySegment(position);
    }

    @Override
    public void stop(long position)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pause(long position)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume(long position)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void move(long position)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void buffer(long position)
    {
        // TODO Auto-generated method stub
        
    }

}