package fr.jonathanluco.generic.base;

import java.io.Serializable;

public interface GenericId<I> extends Serializable {
    I getId();
}
