package com.blind.typist.syntactic;

import com.blind.typist.dictionary.Classification;
import com.blind.typist.dictionary.Word;
import com.blind.typist.lexical.Token;

import java.util.ArrayList;
import java.util.List;

import static com.blind.typist.dictionary.Classification.*;

public class SyntacticAnalyzer implements SyntacticAnalysis {

    private List<Token> tokens;
    private Token token;
    private int current;
    private List<String> result;

    public SyntacticAnalyzer(List<Token> tokens) {
        this.tokens = tokens;
        token = tokens.get(0);
        current = 0;
        result = new ArrayList<>();
    }

    @Override
    public void analyze() {
        System.out.println("\nSyntactic analysis start\n");

        checkAgreement();

        checkTexto();
        result.forEach(System.out::println);

        clear();
        System.out.println("\nSyntactic analysis end\n");
    }

    private void clear() {
        tokens.clear();
        current = 0;
        result.clear();
    }

    private void goToNextToken() {
        if (++current < tokens.size()) {
            token = tokens.get(current);
        }
    }

    private boolean classMatches(Classification classification) {
        return token.getWord().getClassification().equals(classification.toString());
    }

    /**
     * Texto -> Sentença. | Sentença. Texto
     */
    private void checkTexto() {
        checkSentence();

        if (!getName().equals(".")) {
            result.add("'.' esperado depois de '" + getName() + "'");
        }

    }

    /**
     * Sentença -> Sintagma_nominal Sintagma_verbal
     */
    private void checkSentence() {
        checkSintagmaNominal();
        checkSintagmaVerbal();
    }

    /**
     * Sintagma_nominal -> Substantivo | Artigo Substantivo
     */
    private void checkSintagmaNominal() {
        if (artigoMatches()) {
            if (!substantivoMatches()) {
                result.add("Substantivo esperado em '" + getName() + "'");
            }
        } else if (!substantivoMatches()) {
            result.add("Substantivo esperado em '" + getName() + "'");
        }

        goToNextToken();
    }

    /**
     * Sintagma_verbal -> Verbo | Verbo Sintagma_verbal
     */
    private void checkSintagmaVerbal() {
        if (verboMatches()) {
            goToNextToken();

            if (verboMatches()) {
                checkSintagmaVerbal();
            }

        } else {
            result.add("Verbo esperado em '" + getName() + "'");
        }
    }

    private boolean substantivoMatches() {
        return classificationMatches(SUBS) ||
                classificationMatches(SUBS_MASC) ||
                classificationMatches(SUBS_FEM);
    }

    private boolean artigoMatches() {
        return token.getWord().getClassification().equals(ART_D.toString());
    }

    private boolean verboMatches() {
        return classificationMatches(VERB) ||
                classificationMatches(VERB_T) ||
                classificationMatches(VERB_I);
    }

    private boolean classificationMatches(Classification classification) {
        return classification.toString().equals(token.getWord().getClassification());
    }

    private String getName() {
        return token.getWord().getName();
    }

    private void checkAgreement() {
        for (int i = 0; i < tokens.size() - 1; i++) {
            Word current = tokens.get(i).getWord();
            Word next = tokens.get(i + 1).getWord();

            if (!current.getGender().equals("") && !next.getGender().equals("")) {
                if (!current.getGender().equals(next.getGender())) {
                    result.add("Incompatibilidade." +
                            "\nEsperado " + current.getGender() + " por " + current.getName() +
                            "\nRecebido " + next.getGender() + " de " + next.getName());
                }
            }

            if (!current.getSingularPlural().equals("") && !next.getSingularPlural().equals("")) {
                if (!current.getSingularPlural().equals(next.getSingularPlural())) {
                    result.add("Incompatibilidade." +
                            "\nEsperado " + current.getSingularPlural() + " por " + current.getName() +
                            "\nRecebido " + next.getSingularPlural() + " de " + next.getName());
                }
            }
        }

    }

}
