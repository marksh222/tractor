package com.sberbank.tractor;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

/**
 * Тестовый класс для TractorDriver
 */
public class TractorDriverImplTest {
    @Test
    public void test1() throws IOException, ParseException {
        Tractor tractor = createAndStartTractorByResource("/test1.json");
        assertEquals(0, tractor.getPosition().getX());
        assertEquals(1, tractor.getPosition().getY());
        assertEquals(Orientation.E, tractor.getOrientation());
    }

    @Test
    public void test2() throws IOException, ParseException {
        Tractor tractor = createAndStartTractorByResource("/test2.json");
        assertEquals(0, tractor.getPosition().getX());
        assertEquals(2, tractor.getPosition().getY());
        assertEquals(Orientation.S, tractor.getOrientation());
    }

    @Test
    public void test3() throws IOException, ParseException {
        Tractor tractor = createAndStartTractorByResource("/test3.json");
        assertEquals(0, tractor.getPosition().getX());
        assertEquals(2, tractor.getPosition().getY());
        assertEquals(Orientation.S, tractor.getOrientation());
    }

    private Tractor createAndStartTractorByResource(String resource) throws IOException, ParseException {
        String sFile = this.getClass().getResource(resource).getFile();
        File file = new File(sFile);
        TractorDriver tractorDriver = TractorFactory.createTractorDriver(file);
        tractorDriver.startTractor();
        return tractorDriver.getTractor();
    }
}