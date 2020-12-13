package com.sberbank.tractor;

import com.sberbank.tractor.exceptions.*;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Тестовый клас для Tractor
 */
public class TractorImplTest {

    @Test
    public void testMoveForward(){
        Tractor tractor = TractorFactory.createTractor();
        tractor.moveListCommands("F");
        Position position = tractor.getPosition();
        assertEquals(0, position.getX());
        assertEquals(1, position.getY());
    }

    @Test
    public void testTurn(){
        Tractor tractor = TractorFactory.createTractor();
        tractor.moveListCommands("T");
        assertEquals(Orientation.E, tractor.getOrientation());
        tractor.moveListCommands("T");
        assertEquals(Orientation.S, tractor.getOrientation());
        tractor.moveListCommands("T");
        assertEquals(Orientation.W, tractor.getOrientation());
        tractor.moveListCommands("T");
        assertEquals(Orientation.N, tractor.getOrientation());
    }

    @Test(expected = TractorInDitchException.class)
    public void testTractorInDitchException() {
        Tractor tractor = TractorFactory.createTractor();
        tractor.moveListCommands("F");
        tractor.moveListCommands("F");
        tractor.moveListCommands("F");
        tractor.moveListCommands("F");
        tractor.moveListCommands("F");
        tractor.moveListCommands("F");
    }

    @Test(expected = TractorFieldException.class)
    public void testTractorFieldException() {
        Tractor tractor = TractorFactory.createTractor(new Position(0,0), null);
        tractor.moveListCommands("F");
    }

    @Test(expected = TractorInputFileException.class)
    public void testTractorJsonFileException() throws IOException, ParseException {
        TractorFactory.createTractorDriver(new File("___notfound.json"));
    }

    @Test(expected = TractorOrientationException.class)
    public void testTractorOrientationException() throws IOException, ParseException {
        Tractor tractor = TractorFactory.createTractor();
        tractor.setOrientation(null);
        tractor.moveListCommands("F");
    }

    @Test(expected = TractorPositionException.class)
    public void testTractorPositionException() throws IOException, ParseException {
        Tractor tractor = TractorFactory.createTractor(null,null);
        tractor.moveListCommands("F");
    }

    @Test
    public void testTwoMove(){
        Tractor tractor = TractorFactory.createTractor();
        tractor.moveListCommands("T");
        tractor.moveListCommands("F");
        assertEquals(1, tractor.getPosition().getX());
        assertEquals(0, tractor.getPosition().getY());
        tractor.moveListCommands("T");
        assertEquals(1, tractor.getPosition().getX());
        tractor.moveListCommands("T");
        tractor.moveListCommands("T");
        tractor.moveListCommands("F");
        assertEquals(1, tractor.getPosition().getX());
        assertEquals(1, tractor.getPosition().getY());
    }

    @Test
    public void testErrorCommand() {
        Tractor tractor = TractorFactory.createTractor();
        tractor.moveListCommands("G");
    }
}