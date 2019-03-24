package com.laifeng.sopcastsdk.stream.amf;

import java.util.HashMap;
import java.util.Map;


public enum AmfType {
    NUMBER(0x00),
    BOOLEAN(0x01),
    STRING(0x02),
    OBJECT(0x03),
    NULL(0x05),
    UNDEFINED(0x06),
    MAP(0x08),
    ARRAY(0x0A);
    private byte value;
    private static final Map<Byte, AmfType> quickLookupMap = new HashMap<Byte, AmfType>();

    static {
        for (AmfType amfType : AmfType.values()) {
            quickLookupMap.put(amfType.getValue(), amfType);
        }
    }

    private AmfType(int intValue) {
        this.value = (byte) intValue;
    }

    public byte getValue() {
        return value;
    }

    public static AmfType valueOf(byte amfTypeByte) {
        return quickLookupMap.get(amfTypeByte);
    }
}
