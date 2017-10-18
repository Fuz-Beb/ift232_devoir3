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



    private int etat;
    final static private int INITIAL = 1;
    final static private int PAUSED = 2;
    final static private int PLAYING = 3;
    final static private int STOPPED = 4;
    final static private int BUFFERING = 5;

    public Banalyser(Media m)
    {

        media = m;
        etat = INITIAL;

    }

    public String getTextLog()
    {

        String res = "" + media;
        res += "\n" + media.getLog() + "\n";
        return res;
    }

    public void start(int position)
    {

        if (etat == INITIAL)
        {
            media.getLog().openPlaySegment(position);
            etat = PLAYING;
        }
        else if (etat == STOPPED)
        {
            media.getLog().openPlaySegment(position);
            etat = PLAYING;
        }
        else
        {

            throw new ExceptionDevoir2("Seul l'etat INITIAL et STOPPED sont acceptes dans un start()");
        }

    }

    public void stop(long position)
    {

        if (etat == PLAYING)
        {
            if (media.getType() == Media.MUSIC)
            {
                media.getLog().closePlaySegment(position);
                etat = STOPPED;
            }
            if (media.getType() == Media.VIDEO)
            {
                media.getLog().closePlaySegment(position);
                etat = STOPPED;
            }
        }
        else if (etat == PAUSED)
        {
            if (media.getType() == Media.MUSIC)
            {
                media.getLog().closePauseEntry(position);
                media.getLog().closePlaySegment(position);
                etat = STOPPED;
            }
            if (media.getType() == Media.VIDEO)
            {
                media.getLog().closePauseEntry(position);
                media.getLog().closePlaySegment(position);
                etat = STOPPED;
            }
        }
        else
        {
            throw new ExceptionDevoir2("Seul l'etat PLAYING et PAUSED sont acceptes dans un stop()");
        }

    }

    public void pause(long position)
    {

        if (etat == PLAYING)
        {
            if (media.getType() == Media.MUSIC)
            {
                media.getLog().openPauseEntry(position);
                etat = PAUSED;
            }
            if (media.getType() == Media.VIDEO)
            {
                media.getLog().openPauseEntry(position);
                etat = PAUSED;
            }
        }
        else
        {
            throw new ExceptionDevoir2("Seul l'etat PLAYING est accepte dans un pause()");
        }
    }

    public void resume(long time)
    {

        if (etat == PAUSED)
        {
            if (media.getType() == Media.MUSIC)
            {
                media.getLog().closePauseEntry(time);
                etat = PLAYING;
            }
            if (media.getType() == Media.VIDEO)
            {
                media.getLog().closePauseEntry(time);
                etat = PLAYING;
            }
        }

        else if (etat == BUFFERING)
        {
            if (media.getType() == Media.MUSIC)
            {
                media.getLog().closeBufferingEntry(time);
                etat = PLAYING;
            }
            if (media.getType() == Media.VIDEO)
            {
                media.getLog().closeBufferingEntry(time);
                etat = PLAYING;
            }
        }
        else
        {
            throw new ExceptionDevoir2("Seul l'etat PAUSED et BUFFERING sont acceptes dans un resume()");
        }
    }

    public void move(long position)
    {

        if (etat == PLAYING)
        {
            if (media.getType() == Media.MUSIC)
            {
                media.getLog().addMoveEntry(position);
                media.getLog().openPauseEntry(position);
                etat = PAUSED;
            }
            if (media.getType() == Media.VIDEO)
            {
                media.getLog().addMoveEntry(position);
                media.getLog().openPauseEntry(position);
                etat = PAUSED;
            }
        }
        else if (etat == PAUSED)
        {
            if (media.getType() == Media.MUSIC)
            {
                media.getLog().addMoveEntry(position);

            }
            if (media.getType() == Media.VIDEO)
            {
                media.getLog().addMoveEntry(position);

            }
        }
        else
        {
            throw new ExceptionDevoir2("Seul l'etat PLAYING et PAUSED sont acceptes dans un move()");
        }
    }

    public void buffer(long position)
    {
        if (etat == PLAYING)
        {
            if (media.getType() == Media.MUSIC)
            {
                media.getLog().openBufferingEntry(position);
                etat = BUFFERING;
            }
            if (media.getType() == Media.VIDEO)
            {
                media.getLog().openBufferingEntry(position);
                etat = BUFFERING;
            }
        }
        else
        {
            throw new ExceptionDevoir2("Seul l'etat PLAYING est accepte dans un buffer()");
        }
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
        if (media.getLog() == null)
        {
            if (other.media.getLog() != null)
                return false;
        }
        else if (!media.getLog().equals(other.media.getLog()))
            return false;
        if (media == null)
        {
            if (other.media != null)
                return false;
        }
        else if (!media.equals(other.media))
            return false;
        if (media.getType() == null)
        {
            if (other.media.getType() != null)
                return false;
        }
        else if (!media.getType().equals(other.media.getType()))
            return false;
        return true;
    }

}
