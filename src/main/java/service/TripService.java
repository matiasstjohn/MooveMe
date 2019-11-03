package service;

import model.*;

import java.util.Date;

/**
 * Setear un asset.
 * Setear zona.
 * Setear terminal.
 * Setear discount.
 * Elegir tiempo del viaje.
 * Otorgar puntos (puntos por minuto del viaje).
 * Calcular tarifa (por zona se agrega un porcentaje al valor del viaje y tener en cuenta que
 * se pueden sumar multas, despues supongo que por minuto de viaje se cobrara cierto precio
 * dependiendo del activo, capaz haya que agregarle eso al asset)
 */

public class TripService {

    private Trip trip;
    public void setAsset(Asset asset) {

        trip.setAsset(asset);

    }

    public void setZone(Zone zone) {

        trip.setZone(zone);
    }

    public void setTerminal(Terminal terminal){

        trip.setTerminal(terminal);

    }

    public void setDiscount(Discount discount){

        trip.setDiscount(discount);

    }

    public void setTime(Date date){

        trip.setTripTime(date);
    }

    public Double calculateTariff(){


          Double tripValue = trip.getTariff().getTripValue();
                 tripValue = tripValue * trip.getZone().getRate();
                 return tripValue;


    }

    public Double givePoints(){

        Double tripValue = trip.getTariff().getTripValue();
        tripValue = tripValue * trip.getZone().getRate();
        Double awardedPoints = tripValue * 0.85;
        return awardedPoints;


    }

}
