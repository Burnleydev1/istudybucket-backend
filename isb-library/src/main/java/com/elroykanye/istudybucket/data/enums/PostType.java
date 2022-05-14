package com.elroykanye.istudybucket.data.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum PostType {
    QUESTION("QUESTION"),
    RESOURCE("RESOURCE"),
    COMMENT("COMMENT"),DEFAULT("DEFAULT");

    private String postType;
}
