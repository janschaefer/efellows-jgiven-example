package com.tngtech.jgiven.efellows;

import org.junit.Test;

import com.tngtech.jgiven.junit.de.SzenarioTest;

public class KaffeeAutomatTest extends SzenarioTest<GegebenKaffeeAutomat, WennKaffeeAutomat, DannKaffeeAutomat> {

    @Test
    @Story( "COFFEE-1" )
    public void der_Kaffeeautomat_produziert_Kaffee() {

        angenommen().der_Kaffeeautomat_ist_angeschaltet()
            .und().es_befinden_sich_$_Liter_Wasser_im_Wassertank( 2 )
            .und().es_befindet_sich_eine_Kaffeekapsel_im_Automat();
        wenn().die_Kaffeetaste_gedrueckt_wird();
        dann().produziert_der_Kaffeeautomat_$_ml_Kaffee( 200 );

    }

    public GegebenKaffeeAutomat angenommen() {
        return getScenario().given( "Angenommen" );
    }

}
