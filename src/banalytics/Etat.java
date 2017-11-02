package banalytics;

/**
 * Classe abstraite qui contient la définition des méthodes d'états (start,
 * stop, ...). Chacune des classes qui héritent de celle-ci doivent implémenter
 * ces méthodes avec leur propre comportement.
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

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Etat other = (Etat) obj;
        if (media == null)
        {
            if (other.media != null)
                return false;
        }
        else if (!media.equals(other.media))
            return false;
        return true;
    }
}
