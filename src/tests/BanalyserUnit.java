
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import banalytics.Banalyser;
import banalytics.ExceptionDevoir2;
import banalytics.Media;
import banalytics.MediaMusic;
import banalytics.MediaVideo;

/**
 * Classe de test permettant de tester le bon fonctionnemnt de la classe
 * Banalyser
 */
public class BanalyserUnit
{
    private Media music, video;
    private Banalyser analyser1, analyser2, analyser3, analyser4, analyser5, analyser6;

    /**
     * Initalisation des variables avant l'execution des tests
     */
    @Before
    public void setup()
    {
        music = new MediaMusic("The Space Explorers", "Big Falcon Rocket", ".mp3", 180000);
        video = new MediaVideo("ESA Channel", "The Beagle hasn't landed", ".mov", 953000);

        // Test de la methode equals avec une musique
        analyser1 = new Banalyser(music);

        analyser1.start(0);
        analyser1.pause(30000);
        analyser1.resume(10000);
        analyser1.move(102000);
        analyser1.resume(1000);
        analyser1.buffer(150000);
        analyser1.resume(5000);
        analyser1.stop(180000);

        analyser2 = new Banalyser(music);

        analyser2.start(0);
        analyser2.pause(30000);
        analyser2.resume(10000);
        analyser2.move(102000);
        analyser2.resume(1000);
        analyser2.buffer(150000);
        analyser2.resume(5000);
        analyser2.stop(180000);

        // Test de la methode equals avec une video
        analyser3 = new Banalyser(video);

        analyser3.start(0);
        analyser3.buffer(5000);
        analyser3.resume(60000);
        analyser3.pause(30000);
        analyser3.resume(105000);
        analyser3.move(570000);
        analyser3.resume(1000);
        analyser3.stop(900000);

        analyser4 = new Banalyser(video);

        analyser4.start(0);
        analyser4.buffer(5000);
        analyser4.resume(60000);
        analyser4.pause(30000);
        analyser4.resume(105000);
        analyser4.move(570000);
        analyser4.resume(1000);
        analyser4.stop(900000);

        // Test de la classe equals avec une autre sequence d'evenement
        analyser5 = new Banalyser(video);

        analyser5.start(0);
        analyser5.buffer(5000);
        analyser5.resume(10000);
        analyser5.move(70000);
        analyser5.resume(1000);
        analyser5.pause(100000);
        analyser5.resume(2000);
        analyser5.stop(140000);

        analyser6 = new Banalyser(video);

        analyser6.start(0);
        analyser6.buffer(5000);
        analyser6.resume(10000);
        analyser6.move(70000);
        analyser6.resume(1000);
        analyser6.pause(100000);
        analyser6.resume(2000);
        analyser6.stop(140000);
    }

    /**
     * Test de la methode equals de la classe Banalyser avec une music
     */
    @Test
    public void testEqualsMusic()
    {
        assertTrue(analyser1.equals(analyser2));
    }

    /**
     * Test de la methode equals de la classe Banalyser avec une video
     */
    @Test
    public void testEqualsVideo()
    {
        assertTrue(analyser1.equals(analyser2));
    }

    /**
     * Test de la classe equals avec une autre sequence d'evenement
     */
    @Test
    public void testEqualsVideo2()
    {
        assertTrue(analyser1.equals(analyser2));
    }

    /**
     * Interdiction de mettre deux fois un etat a PAUSED de manière séquentielle
     */
    @Test(expected = ExceptionDevoir2.class)
    public void testVideoSituationAnormale1()
    {
        analyser1 = new Banalyser(video);

        analyser1.start(0);
        analyser1.pause(100000);

        // Ligne suivante engendre une exception
        analyser1.buffer(5000);
    }

    /**
     * Interdiction de mettre deux fois un etat a PLAYING de manière
     * séquentielle
     */
    @Test(expected = ExceptionDevoir2.class)
    public void testVideoSituationAnormale2()
    {
        analyser1 = new Banalyser(video);

        analyser1.start(0);
        analyser1.buffer(5000);
        analyser1.resume(1000);

        // Ligne suivante engendre une exception
        analyser1.resume(1000);
    }

    /**
     * Interdiction de mettre deux fois un etat a PAUSED de manière séquentielle
     */
    @Test(expected = ExceptionDevoir2.class)
    public void testVideoSituationAnormale3()
    {
        analyser1 = new Banalyser(video);

        analyser1.start(0);
        analyser1.buffer(1000);

        // Ligne suivante engendre une exception
        analyser1.buffer(1000);
    }

    /**
     * Interdiction de mettre deux fois un etat a STOPPED de manière
     * séquentielle
     */
    @Test(expected = ExceptionDevoir2.class)
    public void testVideoSituationAnormale4()
    {
        analyser1 = new Banalyser(video);

        analyser1.start(0);
        analyser1.stop(1000);

        analyser1.stop(2000);
    }
}