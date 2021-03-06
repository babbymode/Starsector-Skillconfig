package skillconfig.campaign.skills;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.impl.campaign.ids.Strings;

public class DefensiveSystems {

    public static final float PERSONAL_FLUX_UPKEEP_REDUCTION = Global.getSettings().getFloat("DSPersonalFluxUpkeepReduction");
    public static final float FLEET_FLUX_UPKEEP_REDUCTION = Global.getSettings().getFloat("DSFleetFluxUpkeepReduction");

    public static final float PERSONAL_SHIELD_DAMAGE_REDUCTION = Global.getSettings().getFloat("DSPersonalShieldDamageReduction");
    public static final float FLEET_SHIELD_DAMAGE_REDUCTION = Global.getSettings().getFloat("DSFleetShieldDamageReduction");
    public static final float PERSONAL_PHASE_COOLDOWN_REDUCTION = Global.getSettings().getFloat("DSPersonalPhaseCooldownReduction");
    public static final float FLEET_PHASE_COOLDOWN_REDUCTION = Global.getSettings().getFloat("DSFleetPhaseCooldownReduction");

    public static final float PERSONAL_FLUX_SHUNT_DISSIPATION = Global.getSettings().getFloat("DSPersonalFluxShuntDissipation");
    public static final float FLEET_FLUX_SHUNT_DISSIPATION = Global.getSettings().getFloat("DSFleetFluxShuntDissipation");


    public static class Level1p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getShieldUpkeepMult().modifyMult(id, 1f - PERSONAL_FLUX_UPKEEP_REDUCTION / 100f);
            stats.getPhaseCloakUpkeepCostBonus().modifyMult(id, 1f - PERSONAL_FLUX_UPKEEP_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getShieldUpkeepMult().unmodify(id);
            stats.getPhaseCloakUpkeepCostBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_FLUX_UPKEEP_REDUCTION) + "% flux generated by active shields and phase cloak";
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
            stats.getShieldUpkeepMult().modifyMult(id, 1f - FLEET_FLUX_UPKEEP_REDUCTION / 100f);
            stats.getPhaseCloakUpkeepCostBonus().modifyMult(id, 1f - FLEET_FLUX_UPKEEP_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getShieldUpkeepMult().unmodify(id);
            stats.getPhaseCloakUpkeepCostBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_FLUX_UPKEEP_REDUCTION) + "% flux generated by active shields and phase cloak";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level2Ap implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getShieldDamageTakenMult().modifyMult(id, 1f - PERSONAL_SHIELD_DAMAGE_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getShieldDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_SHIELD_DAMAGE_REDUCTION) + "% damage taken by shields";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }


    public static class Level2Af implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getShieldDamageTakenMult().modifyMult(id, 1f - FLEET_SHIELD_DAMAGE_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getShieldDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_SHIELD_DAMAGE_REDUCTION) + "% damage taken by shields";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level2Bp implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getPhaseCloakCooldownBonus().modifyMult(id, 1f - PERSONAL_PHASE_COOLDOWN_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getPhaseCloakCooldownBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_PHASE_COOLDOWN_REDUCTION) + "% phase cloak cooldown";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level2Bf implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getPhaseCloakCooldownBonus().modifyMult(id, 1f - FLEET_PHASE_COOLDOWN_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getPhaseCloakCooldownBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_PHASE_COOLDOWN_REDUCTION) + "% phase cloak cooldown";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level3Ap implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getHardFluxDissipationFraction().modifyFlat(id, PERSONAL_FLUX_SHUNT_DISSIPATION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getHardFluxDissipationFraction().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "" + (int)(PERSONAL_FLUX_SHUNT_DISSIPATION) + "% hard flux dissipation while shields are active";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level3Af implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getHardFluxDissipationFraction().modifyFlat(id, FLEET_FLUX_SHUNT_DISSIPATION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getHardFluxDissipationFraction().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "" + (int)(FLEET_FLUX_SHUNT_DISSIPATION) + "% hard flux dissipation while shields are active";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level3B implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            // 1f + 2 * (this stat), * 1.5 means 3x -> 4c
            stats.getDynamic().getStat(Stats.PHASE_TIME_BONUS_MULT).modifyFlat(id, 0.5f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getDynamic().getStat(Stats.PHASE_TIME_BONUS_MULT).unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "Phase cloak time acceleration increased from 3" + Strings.X + " to 4" + Strings.X;
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

}

