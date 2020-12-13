package other.itsk;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ITCK {
    @Test
    public void test1() {
        //Map<Map<String,Map>, List<Map<String, String>>> benfAndCatToCtx = new HashMap();
        Map<MapByStringMap, List<MapByStringString>> benfAndCatToCtx = new HashMap<>();
    }
    public static interface MapByStringMap extends Map<String,Map> {
    }
    public static interface MapByStringString extends Map<String,String> {
    }

}
