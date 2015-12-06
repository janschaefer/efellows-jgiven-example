package com.tngtech.jgiven.efellows;

import com.tngetch.jgiven.efellows.KaffeeAutomat;
import com.tngetch.jgiven.efellows.Kapsel;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.lang.de.Stufe;

public class GegebenKaffeeAutomat extends Stufe<GegebenKaffeeAutomat> {

    @ProvidedScenarioState
    KaffeeAutomat automat = new KaffeeAutomat();

    @ProvidedScenarioState
    TestTasse testTasse = new TestTasse();

    @BeforeStage
    public void tasseEinsetzen() {
        automat.kaffeeEmpfaenger( testTasse );
    }

    public GegebenKaffeeAutomat der_Kaffeeautomat_ist_angeschaltet() {
        automat.schalteAn();
        return self();
    }

    public GegebenKaffeeAutomat es_befinden_sich_$_Liter_Wasser_im_Wassertank( int liter ) {
        automat.fuelleWasser( liter * 1000 );
        return self();
    }

    public GegebenKaffeeAutomat es_befindet_sich_eine_Kaffeekapsel_im_Automat() {
        automat.legeKapselEin( new Kapsel() );
        return self();
    }

}
