package com.tngtech.jgiven.efellows;

import com.tngetch.jgiven.efellows.Fluessigkeit;
import com.tngetch.jgiven.efellows.FluessigkeitsEmpfaenger;

public class TestTasse implements FluessigkeitsEmpfaenger {
    private Fluessigkeit fluessigkeit = Fluessigkeit.NICHTS;

    @Override
    public void empfange( Fluessigkeit fluessigkeit ) {
        this.fluessigkeit = this.fluessigkeit.fuegeHinzu( fluessigkeit );
    }

    public Fluessigkeit inhalt() {
        return fluessigkeit;
    }

}
