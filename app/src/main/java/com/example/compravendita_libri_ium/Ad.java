package com.example.compravendita_libri_ium;

public class Ad {
    private boolean approved = false;
    private AdBase adBase;

    public Ad(AdBase adBase, boolean approved) {
        this.adBase = adBase;
        this.approved = approved;
    }

    public AdBase getAdBase() {
        return adBase;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        approved = true;
    }

}
