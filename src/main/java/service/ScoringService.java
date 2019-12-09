package service;

import model.Client;
import model.Discount;
import model.Scoring;
import model.Zone;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Generar descuentos.
 * Mostrar la tabla de lideres.
 * Persistir los datos.
 * Premiar a los tres primeros con 50% de descuento.
 */

public class ScoringService {
    private Scoring scoring;


    public Discount createDiscount(String assetType, Integer minScore, Zone zone, int percent) {
        Discount discount = new Discount(assetType, minScore, zone, percent);
        scoring.addDiscount(discount);
        return discount;
    }


    public List<String> showLeaders(List<Client> clients) {

        scoring.sortLeaderBoard(clients);
        List<String> nicknames = new ArrayList<>(10);

        int i = 1;

        for (Client client: clients) {
            if (nicknames.size() <= 10) {
                nicknames.add(i + ". " + client.getNickname());
                i++;
            }
        }

        return nicknames;
    }


    public void rewardBestThree(Date date) {
        //Discount discount = new Discount();
        Date date1 = new Date();

        if (date.after(date1)) {
            //scoring.getLeaderBoard().get(0).addDiscounts();
        }
    }
}
