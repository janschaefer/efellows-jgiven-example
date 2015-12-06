package com.tngtech.jgiven.efellows;

import org.assertj.core.api.Assertions;

import com.tngetch.jgiven.efellows.Fluessigkeit.Art;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.lang.de.Stufe;

public class DannKaffeeAutomat extends Stufe<DannKaffeeAutomat> {

    @ExpectedScenarioState
    TestTasse testTasse;

    public DannKaffeeAutomat produziert_der_Kaffeeautomat_$_ml_Kaffee( int kaffeeInMilliLittern ) {
        Assertions.assertThat( testTasse.inhalt().art ).isEqualTo( Art.KAFFEE );
        Assertions.assertThat( testTasse.inhalt().mengeInMilliLitern ).isEqualTo( kaffeeInMilliLittern );
        return self();
    }

}
