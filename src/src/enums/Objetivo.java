package enums;

public enum Objetivo {

    EMAGRECER(-500),
    MANTER(0),
    GANHAR(500);

    private final int ajusteCalorico;

    Objetivo(int ajusteCalorico) {
        this.ajusteCalorico = ajusteCalorico;
    }

    public int getAjusteCalorico() {
        return ajusteCalorico;
    }
}