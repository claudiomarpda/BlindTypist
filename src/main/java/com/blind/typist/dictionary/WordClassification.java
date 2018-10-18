package com.blind.typist.dictionary;

public enum WordClassification {

    ART_D("art. def."),
    SUBS("subst."),
    SUBS_MASC("m."),
    SUBS_FEM("f."),
    VERB("v."),
    VERB_T("v. t."),
    VERB_I("v. i,"),
    ADJ("adj."),
    PREP("prep."),
    ADJ_F("adj. f.");

    private String name;

    WordClassification(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}
