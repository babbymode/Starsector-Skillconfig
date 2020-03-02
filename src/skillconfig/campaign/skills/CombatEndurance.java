package skillconfig.campaign.skills;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;


public class CombatEndurance {

    public static final float PERSONAL_MALFUNCTION_REDUCTION = Global.getSettings().getFloat("CEPersonalMalfunctionReduction");
    public static final float FLEET_MALFUNCTION_REDUCTION = Global.getSettings().getFloat("CEFleetMalfunctionReduction");
    public static final float PERSONAL_CRITICAL_MALFUNCTION_REDUCTION = Global.getSettings().getFloat("CEPersonalCriticalMalfunctionReduction");
    public static final float FLEET_CRITICAL_MALFUNCTION_REDUCTION = Global.getSettings().getFloat("CEFleetCriticalMalfunctionReduction");
    public static final float PERSONAL_PEAK_TIME_BONUS = Global.getSettings().getFloat("CEPersonalPeakTimeBonus");
    public static final float FLEET_PEAK_TIME_BONUS = Global.getSettings().getFloat("CEFleetPeakTimeBonus");
    public static final float PERSONAL_MAX_CR_BONUS = Global.getSettings().getFloat("CEPersonalMaxCRBonus");
    public static final float FLEET_MAX_CR_BONUS = Global.getSettings().getFloat("CEFleetMaxCRBonus");

    public static class Level1p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getPeakCRDuration().modifyPercent(id, PERSONAL_PEAK_TIME_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getPeakCRDuration().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_PEAK_TIME_BONUS) + "% peak operating time";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level1f implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getPeakCRDuration().modifyPercent(id, FLEET_PEAK_TIME_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getPeakCRDuration().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_PEAK_TIME_BONUS) + "% peak operating time";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level2p implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getCriticalMalfunctionChance().modifyMult(id, 1f - PERSONAL_CRITICAL_MALFUNCTION_REDUCTION / 100f);
            stats.getWeaponMalfunctionChance().modifyMult(id, 1f - PERSONAL_MALFUNCTION_REDUCTION / 100f);
            stats.getEngineMalfunctionChance().modifyMult(id, 1f - PERSONAL_MALFUNCTION_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getCriticalMalfunctionChance().unmodify(id);
            stats.getWeaponMalfunctionChance().unmodify(id);
            stats.getEngineMalfunctionChance().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int) (PERSONAL_CRITICAL_MALFUNCTION_REDUCTION) + "% chance of malfunctions when at low combat readiness";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }

    }

    public static class Level2f implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getCriticalMalfunctionChance().modifyMult(id, 1f - FLEET_CRITICAL_MALFUNCTION_REDUCTION / 100f);
            stats.getWeaponMalfunctionChance().modifyMult(id, 1f - FLEET_MALFUNCTION_REDUCTION / 100f);
            stats.getEngineMalfunctionChance().modifyMult(id, 1f - FLEET_MALFUNCTION_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getCriticalMalfunctionChance().unmodify(id);
            stats.getWeaponMalfunctionChance().unmodify(id);
            stats.getEngineMalfunctionChance().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_CRITICAL_MALFUNCTION_REDUCTION) + "% chance of malfunctions when at low combat readiness";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level3p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getMaxCombatReadiness().modifyFlat(id, PERSONAL_MAX_CR_BONUS * 0.01f, "Combat endurance skill");
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMaxCombatReadiness().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_MAX_CR_BONUS) + "% maximum combat readiness";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }


    public static class Level3f implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getMaxCombatReadiness().modifyFlat(id, FLEET_MAX_CR_BONUS * 0.01f, "Combat endurance skill");
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMaxCombatReadiness().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_MAX_CR_BONUS) + "% maximum combat readiness";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

}

