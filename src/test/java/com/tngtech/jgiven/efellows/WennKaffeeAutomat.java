package com.tngtech.jgiven.efellows;

import com.tngetch.jgiven.efellows.KaffeeAutomat;
import com.tngtech.jgiven.annotation.ScenarioState;

public class WennKaffeeAutomat {

    @ScenarioState
    KaffeeAutomat automat;

    public void die_Kaffeetaste_gedrueckt_wird() {
        automat.drueckeKaffeeTaste();
    }

}
