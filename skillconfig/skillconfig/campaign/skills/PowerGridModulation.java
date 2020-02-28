package skillconfig.campaign.skills;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class PowerGridModulation {

    public static final float PERSONAL_FLUX_CAPACITY_BONUS = Global.getSettings().getFloat("PGMPersonalFluxCapacityBonus");
    public static final float FLEET_FLUX_CAPACITY_BONUS = Global.getSettings().getFloat("PGMFleetFluxCapacityBonus");
    public static final float PERSONAL_VENT_RATE_BONUS = Global.getSettings().getFloat("PGMPersonalVentRateBonus");
    public static final float FLEET_VENT_RATE_BONUS = Global.getSettings().getFloat("PGMFleetVentRateBonus");
    public static final float PERSONAL_FLUX_DISSIPATION_BONUS = Global.getSettings().getFloat("PGMPersonalFluxDissipationBonus");
    public static final float FLEET_FLUX_DISSIPATION_BONUS = Global.getSettings().getFloat("PGMFleetFluxDissipationBonus");



    public static class Level1a implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getFluxCapacity().modifyPercent(id, PERSONAL_FLUX_CAPACITY_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getFluxCapacity().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_FLUX_CAPACITY_BONUS) + "% flux capacity";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level1b implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getFluxCapacity().modifyPercent(id, FLEET_FLUX_CAPACITY_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getFluxCapacity().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_FLUX_CAPACITY_BONUS) + "% flux capacity";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level2a implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getVentRateMult().modifyFlat(id, PERSONAL_VENT_RATE_BONUS * 0.01f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getVentRateMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int) PERSONAL_VENT_RATE_BONUS + "% flux dissipation rate while venting";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level2b implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getVentRateMult().modifyFlat(id, FLEET_VENT_RATE_BONUS * 0.01f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getVentRateMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int) FLEET_VENT_RATE_BONUS + "% flux dissipation rate while venting";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level3a implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getFluxDissipation().modifyPercent(id, PERSONAL_FLUX_DISSIPATION_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getFluxDissipation().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_FLUX_DISSIPATION_BONUS) + "% flux dissipation rate";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level3b implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getFluxDissipation().modifyPercent(id, FLEET_FLUX_DISSIPATION_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getFluxDissipation().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_FLUX_DISSIPATION_BONUS) + "% flux dissipation rate";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

}
