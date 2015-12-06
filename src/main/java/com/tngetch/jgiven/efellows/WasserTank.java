package com.tngetch.jgiven.efellows;

import com.tngetch.jgiven.efellows.Fluessigkeit.Art;

public class WasserTank implements FluessigkeitsEmpfaenger {
    private Fluessigkeit inhalt = Fluessigkeit.NICHTS;

    @Override
    public void empfange( Fluessigkeit fluessigkeit ) {
        if( fluessigkeit.art != Art.WASSER )
            throw new IllegalArgumentException( "Nur Wasser ist als Flüssigkeit erlaubt" );
        inhalt = inhalt.fuegeHinzu( fluessigkeit );
    }

    public Fluessigkeit inhalt() {
        return inhalt;
    }

    public void entnehme( int milliLiter ) {
        inhalt = inhalt.entnehme( milliLiter );
    }

}
