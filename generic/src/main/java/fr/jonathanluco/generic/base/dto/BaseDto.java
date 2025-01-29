package fr.jonathanluco.generic.base.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class BaseDto implements Serializable {
    private long id;
    private int version;
}
