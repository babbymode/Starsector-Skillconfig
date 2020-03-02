package skillconfig.campaign.skills;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class MissileSpecialization {

    public static final float PERSONAL_MISSILE_SPEC_SPEED_BONUS = Global.getSettings().getFloat("PersonalMissileSpecSpeedBonus");
    public static final float PERSONAL_MISSILE_SPEC_RANGE_MULT = Global.getSettings().getFloat("PersonalMissileSpecRangeMult");
    public static final float PERSONAL_MISSILE_SPEC_ACCEL_BONUS = Global.getSettings().getFloat("PersonalMissileSpecAccelBonus");
    public static final float PERSONAL_MISSILE_TURN_RATE_BONUS = Global.getSettings().getFloat("PersonalMissileTurnRateBonus");
    public static final float PERSONAL_MISSILE_TURN_ACCEL_BONUS = Global.getSettings().getFloat("PersonalMissileTurnAccelBonus");
    public static final float FLEET_MISSILE_SPEC_SPEED_BONUS = Global.getSettings().getFloat("FleetMissileSpecSpeedBonus");
    public static final float FLEET_MISSILE_SPEC_RANGE_MULT = Global.getSettings().getFloat("FleetMissileSpecRangeMult");
    public static final float FLEET_MISSILE_SPEC_ACCEL_BONUS = Global.getSettings().getFloat("FleetMissileSpecAccelBonus");
    public static final float FLEET_MISSILE_TURN_RATE_BONUS = Global.getSettings().getFloat("FleetMissileTurnRateBonus");
    public static final float FLEET_MISSILE_TURN_ACCEL_BONUS = Global.getSettings().getFloat("FleetMissileTurnAccelBonus");

    public static final float PERSONAL_MISSILE_SPEC_PERK_HEALTH_BONUS = Global.getSettings().getFloat("PersonalMissileSpecPerkHealthBonus");
    public static final float FLEET_MISSILE_SPEC_PERK_HEALTH_BONUS = Global.getSettings().getFloat("FleetMissileSpecPerkHealthBonus");

    public static final float PERSONAL_MISSILE_SPEC_PERK_DAMAGE_BONUS = Global.getSettings().getFloat("PersonalMissileSpecPerkDamageBonus");
    public static final float FLEET_MISSILE_SPEC_PERK_DAMAGE_BONUS = Global.getSettings().getFloat("FleetMissileSpecPerkDamageBonus");

    public static class Level1p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getMissileMaxSpeedBonus().modifyPercent(id, PERSONAL_MISSILE_SPEC_SPEED_BONUS);
            stats.getMissileWeaponRangeBonus().modifyMult(id, PERSONAL_MISSILE_SPEC_RANGE_MULT);

            stats.getMissileAccelerationBonus().modifyPercent(id, PERSONAL_MISSILE_SPEC_ACCEL_BONUS);
            stats.getMissileMaxTurnRateBonus().modifyPercent(id, PERSONAL_MISSILE_TURN_RATE_BONUS);
            stats.getMissileTurnAccelerationBonus().modifyPercent(id, PERSONAL_MISSILE_TURN_ACCEL_BONUS);

        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileMaxSpeedBonus().unmodify(id);
            stats.getMissileWeaponRangeBonus().unmodify(id);

            stats.getMissileAccelerationBonus().unmodify(id);
            stats.getMissileMaxTurnRateBonus().unmodify(id);
            stats.getMissileTurnAccelerationBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_MISSILE_SPEC_SPEED_BONUS) + "% missile speed and maneuverability";
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
            stats.getMissileMaxSpeedBonus().modifyPercent(id, FLEET_MISSILE_SPEC_SPEED_BONUS);
            stats.getMissileWeaponRangeBonus().modifyMult(id, FLEET_MISSILE_SPEC_RANGE_MULT);

            stats.getMissileAccelerationBonus().modifyPercent(id, FLEET_MISSILE_SPEC_ACCEL_BONUS);
            stats.getMissileMaxTurnRateBonus().modifyPercent(id, FLEET_MISSILE_TURN_RATE_BONUS);
            stats.getMissileTurnAccelerationBonus().modifyPercent(id, FLEET_MISSILE_TURN_ACCEL_BONUS);

        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileMaxSpeedBonus().unmodify(id);
            stats.getMissileWeaponRangeBonus().unmodify(id);

            stats.getMissileAccelerationBonus().unmodify(id);
            stats.getMissileMaxTurnRateBonus().unmodify(id);
            stats.getMissileTurnAccelerationBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_MISSILE_SPEC_SPEED_BONUS) + "% missile speed and maneuverability";
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
            stats.getMissileHealthBonus().modifyPercent(id, PERSONAL_MISSILE_SPEC_PERK_HEALTH_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileHealthBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_MISSILE_SPEC_PERK_HEALTH_BONUS) + "% missile, rocket, bomb, and torpedo hitpoints";
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
            stats.getMissileHealthBonus().modifyPercent(id, FLEET_MISSILE_SPEC_PERK_HEALTH_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileHealthBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_MISSILE_SPEC_PERK_HEALTH_BONUS) + "% missile, rocket, bomb, and torpedo hitpoints";
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
            stats.getMissileWeaponDamageMult().modifyPercent(id, PERSONAL_MISSILE_SPEC_PERK_DAMAGE_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileWeaponDamageMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_MISSILE_SPEC_PERK_DAMAGE_BONUS) + "% missile damage";
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
            stats.getMissileWeaponDamageMult().modifyPercent(id, FLEET_MISSILE_SPEC_PERK_DAMAGE_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileWeaponDamageMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_MISSILE_SPEC_PERK_DAMAGE_BONUS) + "% missile damage";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }

    }
}

