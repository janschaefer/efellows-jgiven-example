package com.tngetch.jgiven.efellows;

import com.tngetch.jgiven.efellows.Fluessigkeit.Art;

public class KaffeeAutomat {
    private static final int MILLILITER_PRO_TASSE = 200;

    private boolean an;
    private Kapsel kapsel;
    private String fehler;
    private FluessigkeitsEmpfaenger kaffeeEmpfaenger;

    private final WasserTank tank = new WasserTank();

    public void kaffeeEmpfaenger( FluessigkeitsEmpfaenger kaffeeEmpfaenger ) {
        this.kaffeeEmpfaenger = kaffeeEmpfaenger;
    }

    public void drueckeKaffeeTaste() {
        if( !an )
            return;

        if( !ueberpruefeWasserMenge() )
            return;

        tank.entnehme( MILLILITER_PRO_TASSE );

        Fluessigkeit fluessigkeit = kapsel == null ? new Fluessigkeit( Art.WASSER, MILLILITER_PRO_TASSE )
                : new Fluessigkeit( Art.KAFFEE, MILLILITER_PRO_TASSE );

        kaffeeEmpfaenger.empfange( fluessigkeit );

        kapsel = null;
        fehler = null;
    }

    private boolean ueberpruefeWasserMenge() {
        if( wasserMengeInMilliLitern() < MILLILITER_PRO_TASSE ) {
            zeigeFehler( "Bitte Wasser nachfüllen" );
            return false;
        }

        return true;
    }

    private void zeigeFehler( String fehler ) {
        this.fehler = fehler;
    }

    public String fehler() {
        return fehler;
    }

    public void legeKapselEin( Kapsel kapsel ) {
        this.kapsel = kapsel;
    }

    public void fuelleWasser( int milliLiter ) {
        fehler = null;
        tank.empfange( new Fluessigkeit( Art.WASSER, milliLiter ) );
    }

    public int wasserMengeInMilliLitern() {
        return tank.inhalt().mengeInMilliLitern;
    }

    public void schalteAn() {
        an = true;
    }

}
