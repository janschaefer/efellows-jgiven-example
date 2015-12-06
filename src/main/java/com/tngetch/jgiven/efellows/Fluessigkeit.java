package com.tngetch.jgiven.efellows;

public class Fluessigkeit {
    public static final Fluessigkeit NICHTS = new Fluessigkeit( Art.NICHTS, 0 );

    public final Art art;
    public final int mengeInMilliLitern;

    public Fluessigkeit( Art art, int mengeInMilliLitern ) {
        if( art == Art.NICHTS && mengeInMilliLitern != 0 )
            throw new IllegalArgumentException( "Nichts muss nichts sein" );
        this.art = art;
        this.mengeInMilliLitern = mengeInMilliLitern;
    }

    public enum Art {
        WASSER,
        KAFFEE,
        NICHTS
    }

    public Fluessigkeit fuegeHinzu( Fluessigkeit fluessigkeit ) {
        if( art != Art.NICHTS && art != fluessigkeit.art )
            throw new IllegalArgumentException( "Nur Flüssigkeiten der gleichen Art darf hinzugefügt werden" );
        return new Fluessigkeit( fluessigkeit.art, mengeInMilliLitern + fluessigkeit.mengeInMilliLitern );
    }

    public Fluessigkeit entnehme( int milliLiter ) {
        if( milliLiter > mengeInMilliLitern )
            throw new IllegalArgumentException( "Es kann nicht mehr entnommen werden als da ist" );
        return new Fluessigkeit( art, mengeInMilliLitern - milliLiter );
    }
}
