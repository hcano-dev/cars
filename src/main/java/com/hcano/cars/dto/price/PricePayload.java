package com.hcano.cars.dto.price;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcano.cars.dto.PayloadID;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
public class PricePayload extends PayloadID {
    @NotNull
    @JsonProperty("price")
    private BigInteger price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty(value = "init_date")
    private Date initDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty(value = "end_date")
    private Date endDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty(value = "created")
    private Date created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty(value = "modified")
    private Date modified;
}
