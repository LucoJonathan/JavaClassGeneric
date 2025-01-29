package fr.jonathanluco.generic.base.dto;

import fr.jonathanluco.generic.base.GenericId;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseDto implements GenericId<Long>
    {
    private Long id;
    private int version;
}
