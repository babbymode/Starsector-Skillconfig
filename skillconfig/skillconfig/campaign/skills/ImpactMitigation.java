package skillconfig.campaign.skills;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class ImpactMitigation {

    public static final float PERSONAL_ARMOR_BONUS = Global.getSettings().getFloat("IMPersonalArmorBonus");
    public static final float FLEET_ARMOR_BONUS = Global.getSettings().getFloat("IMFleetArmorBonus");
    public static final float PERSONAL_MAX_DAMAGE_REDUCTION_BONUS = Global.getSettings().getFloat("IMPersonalMaxDamageReductionBonus");
    public static final float FLEET_MAX_DAMAGE_REDUCTION_BONUS = Global.getSettings().getFloat("IMFleetMaxDamageReductionBonus");
    public static final float PERSONAL_ARMOR_DAMAGE_REDUCTION = Global.getSettings().getFloat("IMPersonalArmorDamageReduction");
    public static final float FLEET_ARMOR_DAMAGE_REDUCTION = Global.getSettings().getFloat("IMFleetArmorDamageReduction");


    public static class Level1p implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getEffectiveArmorBonus().modifyPercent(id, PERSONAL_ARMOR_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getEffectiveArmorBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_ARMOR_BONUS) + " armor for damage reduction calculation only";
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
            stats.getEffectiveArmorBonus().modifyPercent(id, FLEET_ARMOR_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getEffectiveArmorBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_ARMOR_BONUS) + " armor for damage reduction calculation only";
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
            stats.getMaxArmorDamageReduction().modifyFlat(id, PERSONAL_MAX_DAMAGE_REDUCTION_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMaxArmorDamageReduction().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "Maximum damage reduction by armor raised by " + (int)(PERSONAL_MAX_DAMAGE_REDUCTION_BONUS * 100f) + "%, from 85% to " + (int)((0.85f + PERSONAL_MAX_DAMAGE_REDUCTION_BONUS) * 100f) + "%";
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
            stats.getMaxArmorDamageReduction().modifyFlat(id, FLEET_MAX_DAMAGE_REDUCTION_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMaxArmorDamageReduction().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "Maximum damage reduction by armor raised by " + (int)(FLEET_MAX_DAMAGE_REDUCTION_BONUS * 100f) + "%, to " + (int)(( 0.85f + FLEET_MAX_DAMAGE_REDUCTION_BONUS) * 100f) + "% or " + (int)((0.85f + FLEET_MAX_DAMAGE_REDUCTION_BONUS + PERSONAL_MAX_DAMAGE_REDUCTION_BONUS ) * 100f) + "% if stacking with above)";
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
            stats.getArmorDamageTakenMult().modifyMult(id, 1f - PERSONAL_ARMOR_DAMAGE_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getArmorDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_ARMOR_DAMAGE_REDUCTION) + "% armor damage taken";
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
            stats.getArmorDamageTakenMult().modifyMult(id, 1f - FLEET_ARMOR_DAMAGE_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getArmorDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_ARMOR_DAMAGE_REDUCTION) + "% armor damage taken";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

}
