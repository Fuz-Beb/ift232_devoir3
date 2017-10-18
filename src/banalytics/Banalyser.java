package banalytics;

/*
 * Classe qui sert � journaliser les �v�nements qui surviennent durant
 * l'utilisation d'un contenu multim�dia par un utilisateur. Une fois les
 * �v�nements correctement journalis�s, il deviendra possible d'analyser le
 * comportement de l'utilisateur et d'en tirer des statistiques d'utilisation.
 * 
 */

public class Banalyser
{

    private Media media;
    private Etat etat;
    final static protected int INITIAL = 1;
    final static protected int PAUSED = 2;
    final static protected int PLAYING = 3;
    final static protected int STOPPED = 4;
    final static protected int BUFFERING = 5;

    public Banalyser(Media m)
    {
        setMedia(m);
        etat = new EtatInitial(media);
    }

    public String getTextLog()
    {

        String res = "" + getMedia();
        res += "\n" + getMedia().getLog() + "\n";
        return res;
    }

    public void start(int position)
    {
        etat.start(position);
        etat = new EtatPlaying(media);

    }

    public void stop(long position)
    {
        etat.stop(position);
        etat = new EtatStopped(media);
    }

    public void pause(long position)
    {
        etat.pause(position);
        etat = new EtatPaused(media);
    }

    public void resume(long time)
    {
        etat.resume(time);
        etat = new EtatPlaying(media);
    }

    public void move(long position)
    {
        etat.move(position);
        etat = new EtatPaused(media);
    }

    public void buffer(long position)
    {
        etat.buffer(position);
        etat = new EtatBuffering(media);
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
        Banalyser other = (Banalyser) obj;
        if (etat != other.etat)
            return false;
        if (getMedia().getLog() == null)
        {
            if (other.getMedia().getLog() != null)
                return false;
        }
        else if (!getMedia().getLog().equals(other.getMedia().getLog()))
            return false;
        if (getMedia() == null)
        {
            if (other.getMedia() != null)
                return false;
        }
        else if (!getMedia().equals(other.getMedia()))
            return false;
        if (getMedia().getType() == null)
        {
            if (other.getMedia().getType() != null)
                return false;
        }
        else if (!getMedia().getType().equals(other.getMedia().getType()))
            return false;
        return true;
    }

    /**
     * @return the etat
     */
    public Etat getEtat()
    {
        return etat;
    }

    /**
     * @param etat
     *            the etat to set
     */
    public void setEtat(Etat etat)
    {
        this.etat = etat;
    }

    /**
     * @return the media
     */
    public Media getMedia()
    {
        return media;
    }

    /**
     * @param media
     *            the media to set
     */
    public void setMedia(Media media)
    {
        this.media = media;
    }

}
