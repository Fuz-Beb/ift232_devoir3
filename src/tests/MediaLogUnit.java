
package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import banalytics.Media;
import banalytics.MediaMusic;
import banalytics.MediaVideo;

/**
 * Classe de test qui permet d'assurer le bon fonctionnement de la classe
 * MediaLog
 */
public class MediaLogUnit
{
    @Test
    public void testMediaMusic()
    {
        assertTrue(new MediaMusic("L'auteur d'une musique", "Le titre du musique", ".mp3", 1500)
                .equals(new MediaMusic("L'auteur d'une musique", "Le titre du musique", ".mp3", 1500)));
    }

    @Test
    public void testMediaMusicMauvaisTitre()
    {
        assertFalse(new MediaMusic("L'auteur d'une musique", "Le titre du musique", ".mp3", 1500)
                .equals(new MediaMusic("L'auteur d'une musique", "Un autre titre", ".mp3", 1500)));
    }

    @Test
    public void testMediaFilm()
    {
        assertTrue(new MediaVideo("L'auteur d'une film", "Le titre du film", ".mov", 140000)
                .equals(new MediaVideo("L'auteur d'une film", "Le titre du film", ".mov", 140000)));
    }

    @Test
    public void testMediaFilmMauvaisTitre()
    {
        assertFalse(new MediaVideo("L'auteur d'une film", "Le titre du film", ".mov", 140000)
                .equals(new MediaVideo("L'auteur d'une film", "Un autre titre", ".mov", 140000)));
    }
}