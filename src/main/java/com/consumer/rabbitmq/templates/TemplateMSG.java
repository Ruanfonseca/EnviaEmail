package com.consumer.rabbitmq.templates;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TemplateMSG implements Serializable {

    private static final long serialVersionUID = 1L;

    private String MSG;
    private String EMAIL;
    private String NOME;

    @JsonCreator
    public TemplateMSG(@JsonProperty("MSG") String MSG,
                       @JsonProperty("EMAIL") String EMAIL,
                       @JsonProperty("NOME") String NOME) {
        this.MSG = MSG;
        this.EMAIL = EMAIL;
        this.NOME = NOME;
    }
}