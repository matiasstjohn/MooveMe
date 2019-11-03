package service;

import model.Discount;
import model.Trip;

import java.util.ArrayList;
import java.util.List;

/**
 * Mostrar los descuentos existentes, chequeando que se puedan usar en un trip especifico.
 */

public class DiscountService {
    private Discount discount;

    public List<Discount> showDiscounts(List<Discount> discounts, Trip trip) {
        List<Discount> discountsToUse = new ArrayList<>();
        for (Discount discount: discounts) {
            if (canUse(discount, trip)) {
                discountsToUse.add(discount);
            }
        }

        return discountsToUse;
    }

    private boolean canUse(Discount discount, Trip trip) {

        return trip.getClient().getAccumulatedScore() >= discount.getMinScore() &&
                trip.getAsset().getType().equals(discount.getAssetType()) &&
                trip.getZone().getType().equals(discount.getZone().getType());
    }
}
