package other.itsk;

import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ResponseITSKCASoap {
    HashMap propertyMap;
    String log = "";
    String result = "ERROR";

    public HashMap getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(HashMap parametrMap) {
        this.propertyMap = parametrMap;
    }
}
