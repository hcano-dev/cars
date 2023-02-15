package com.hcano.cars.dto.extra;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcano.cars.dto.PayloadID;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class ExtraPayload extends PayloadID {
    public ExtraPayload(String id, String name, Date created, Date modified) {
        super(id);
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    @NotBlank
    @JsonProperty("name")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty(value = "created")
    private Date created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty(value = "modified")
    private Date modified;
}
