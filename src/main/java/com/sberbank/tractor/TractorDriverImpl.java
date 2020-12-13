package com.sberbank.tractor;

import com.sberbank.tractor.exceptions.TractorInputFileException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс, осуществляющий управление трактором, на основе входного JSON-файла.
 * Пример входного файла:
 *   {"position" : [0,0], "field" : [5,5], "commands" : ["F","T"] }
 */
class TractorDriverImpl extends TractorDriver {

    private JsonWrap jsonWrap;
    private Tractor tractor;
    private final ReentrantLock lock = new ReentrantLock();

    TractorDriverImpl(final File file) throws IOException, ParseException {
        lock.lock();
        try {
            if (file == null) {
                throw new TractorInputFileException("File is not set to control the tractor");
            }
            if (file.exists() && file.canRead()) {
                jsonWrap = readFile(file);
            }
            else {
                throw new TractorInputFileException("Tractor management file unavailable");
            }
        }
        finally {
            lock.unlock();
        }
    }

    /**
     * Возвращает трактор, над которым производится управление, начальное положение трактора и размеры поля в json-файле
     */
    @Override
    public Tractor getTractor() {
        lock.lock();
        try {
            if (tractor == null) {
                tractor = TractorFactory.createTractor(jsonWrap.position, jsonWrap.field);
            }
        }
        finally {
            lock.unlock();
        }
        return tractor;
    }

    /**
     * Запускает цепочку команд управления трактором, источник команд - json-файл
     */
    @Override
    public void startTractor() {
        String sList = getStringList(jsonWrap.commandsList);
        getTractor().moveListCommands(sList);
    }

    private String getStringList(List<String> commandsList) {
        if (commandsList == null) return null;
        StringBuilder buf = new StringBuilder();
        for (String item : commandsList) {
            buf.append(item).append(",");
        }
        if (buf.length() > 0) {
            buf.setLength(buf.length()-1);
        }
        return buf.toString();
    }

    /**
     * Чтение JSON-файла с локального диска
     * @param file
     * @return JsonWrap
     * @throws IOException
     * @throws ParseException
     */
    private JsonWrap readFile(File file) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(new FileReader(file));
        JSONArray position = (JSONArray) object.get("position");
        Long positionX = (Long) position.get(0);
        Long positionY = (Long) position.get(1);

        JSONArray field = (JSONArray) object.get("field");
        Long fieldWidth  = (Long) field.get(0);
        Long fieldLength = (Long) field.get(1);

        JSONArray commands = (JSONArray) object.get("commands");
        @SuppressWarnings("unchecked")
        ListIterator<String> commandsIterator = commands.listIterator();
        List<String> commandsList = new ArrayList<>();

        while (commandsIterator.hasNext()) {
            commandsList.add(commandsIterator.next());
        }
        //----
        JsonWrap rc = new JsonWrap();
        rc.position = new Position(positionX.intValue(), positionY.intValue());
        rc.field = new Field(fieldWidth.intValue(), fieldLength.intValue());
        rc.commandsList = commandsList;
        return rc;
    }

    //----------
    class JsonWrap {
        Position position;
        Field field;
        List<String> commandsList;
    }
}