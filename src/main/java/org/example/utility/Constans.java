package org.example.utility;

import org.example.repository.entity.BaseEntity;

public class Constans {
    public static BaseEntity getBaseEntity(){
        return BaseEntity.builder()
                .createat(System.currentTimeMillis())
                .updateat(System.currentTimeMillis())
                .state(true)
                .build();
    }
}
