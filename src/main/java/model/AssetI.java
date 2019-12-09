package model;

public interface AssetI {

    String getType();

    PurchaseLot getLot();

    Zone getZone();

    Terminal getTerminal();

    Integer getMinScore();

    void setTerminalToHandOver(Terminal terminal);
}
