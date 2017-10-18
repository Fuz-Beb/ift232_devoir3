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

    private MediaLog log;

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
        res += "\n" + log + "\n";
        return res;
    }

    public void start(int position)
    {

        if (etat == INITIAL)
        {
            if (media.getType() == Media.MUSIC)
            {
                log = new MusicLog();
                log.openPlaySegment(position);
                etat = PLAYING;
            }
            if (media.getType() == Media.VIDEO)
            {
                log = new VideoLog();
                log.openPlaySegment(position);
                etat = PLAYING;
            }
        }
        else if (etat == STOPPED)
        {

            if (media.getType() == Media.MUSIC)
            {
                log.openPlaySegment(position);
                etat = PLAYING;
            }
            if (media.getType() == Media.VIDEO)
            {
                log.openPlaySegment(position);
                etat = PLAYING;
            }
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
                log.closePlaySegment(position);
                etat = STOPPED;
            }
            if (media.getType() == Media.VIDEO)
            {
                log.closePlaySegment(position);
                etat = STOPPED;
            }
        }
        else if (etat == PAUSED)
        {
            if (media.getType() == Media.MUSIC)
            {
                log.closePauseEntry(position);
                log.closePlaySegment(position);
                etat = STOPPED;
            }
            if (media.getType() == Media.VIDEO)
            {
                log.closePauseEntry(position);
                log.closePlaySegment(position);
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
                log.openPauseEntry(position);
                etat = PAUSED;
            }
            if (media.getType() == Media.VIDEO)
            {
                log.openPauseEntry(position);
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
                log.closePauseEntry(time);
                etat = PLAYING;
            }
            if (media.getType() == Media.VIDEO)
            {
                log.closePauseEntry(time);
                etat = PLAYING;
            }
        }

        else if (etat == BUFFERING)
        {
            if (media.getType() == Media.MUSIC)
            {
                log.closeBufferingEntry(time);
                etat = PLAYING;
            }
            if (media.getType() == Media.VIDEO)
            {
                log.closeBufferingEntry(time);
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
                log.addMoveEntry(position);
                log.openPauseEntry(position);
                etat = PAUSED;
            }
            if (media.getType() == Media.VIDEO)
            {
                log.addMoveEntry(position);
                log.openPauseEntry(position);
                etat = PAUSED;
            }
        }
        else if (etat == PAUSED)
        {
            if (media.getType() == Media.MUSIC)
            {
                log.addMoveEntry(position);

            }
            if (media.getType() == Media.VIDEO)
            {
                log.addMoveEntry(position);

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
                log.openBufferingEntry(position);
                etat = BUFFERING;
            }
            if (media.getType() == Media.VIDEO)
            {
                log.openBufferingEntry(position);
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
        if (log == null)
        {
            if (other.log != null)
                return false;
        }
        else if (!log.equals(other.log))
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
