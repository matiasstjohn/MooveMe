package model;

import util.AssetType;

public interface AssetI {

    AssetType getType();

    PurchaseLot getLot();

    Zone getZone();

    Terminal getTerminal();

    Integer getMinScore();

    void setTerminalToHandOver(Terminal terminal);
}
