package com.bigdecimal.dockerizedspringboot;

import lombok.Data;

@Data
public class WhatsAppMessage {
    private String fromNumber;
    private String toNumber;
    private String text;
}
