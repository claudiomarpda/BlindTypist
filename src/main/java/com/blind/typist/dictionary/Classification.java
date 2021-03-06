package com.blind.typist.dictionary;

public enum Classification {

    ART_D("art. def."),
    ART_I("art. indef."),
    SUBS("subst."),
    SUBS_MASC("m."),
    SUBS_FEM("f."),
    VERB("v."),
    VERB_T("v. t."),
    VERB_I("v. i."),
    ADJ("adj."),
    PREP("prep."),
    ADJ_F("adj. f."),
    UNDEFINED("UNDEFINED"),
    DOT("dot");

    private String name;

    Classification(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }

}
