package com.example.compravendita_libri_ium;

public enum MeetingPlace {
    FERMI("Edificio Enrico Fermi", "CU033"),
    DARWIN("Edificio Charles Darwin", "CU026"),
    MINERVA("Piazzale della Minerva", "");

    private final String description;
    private String buildingCode;

    MeetingPlace(String description) {
        this.description = description;
    }

    MeetingPlace(String description, String buildingCode) {
        this.description = description;
        this.buildingCode = buildingCode;
    }

    public String getDescription() {
        return description;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    @Override
    public String toString() {
        return buildingCode.isEmpty() ? description : description + " - " + buildingCode;
    }
}
