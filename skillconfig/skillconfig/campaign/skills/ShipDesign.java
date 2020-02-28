package skillconfig.campaign.skills;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.CharacterStatsSkillEffect;
import com.fs.starfarer.api.characters.MutableCharacterStatsAPI;

public class ShipDesign {

    public static final float CAPACITORS_L1_BONUS = Global.getSettings().getFloat("SDCapacitorsLvl1Bonus");
    public static final float CAPACITORS_L2_BONUS = Global.getSettings().getFloat("SDCapacitorsLvl2Bonus");
    public static final float CAPACITORS_L3_BONUS = Global.getSettings().getFloat("SDCapacitorsLvl3Bonus");
    // 20 total

    public static final float VENTS_L1_BONUS = Global.getSettings().getFloat("SDVentsLvl1Bonus");
    public static final float VENTS_L2_BONUS = Global.getSettings().getFloat("SDVentsLvl2Bonus");
    public static final float VENTS_L3_BONUS = Global.getSettings().getFloat("SDVentsLvl3Bonus");
    // 20 total

    public static final float OP_L1_BONUS = Global.getSettings().getFloat("SDOPLvl1Bonus");
    public static final float OP_L2_BONUS = Global.getSettings().getFloat("SDOPLvl2Bonus");
    public static final float OP_L3_BONUS = Global.getSettings().getFloat("SDOPLvl3Bonus");
    // 10 total



    public static class Level1 implements CharacterStatsSkillEffect {
        public void apply(MutableCharacterStatsAPI stats, String id, float level) {
            stats.getMaxCapacitorsBonus().modifyPercent(id, CAPACITORS_L1_BONUS);
            stats.getMaxVentsBonus().modifyPercent(id, VENTS_L1_BONUS);
            stats.getShipOrdnancePointBonus().modifyPercent(id, OP_L1_BONUS);
        }

        public void unapply(MutableCharacterStatsAPI stats, String id) {
            stats.getMaxCapacitorsBonus().unmodify(id);
            stats.getMaxVentsBonus().unmodify(id);
            stats.getMaxVentsBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int) CAPACITORS_L1_BONUS + "% maximum flux capacitors, "
                    + "+" + (int) VENTS_L1_BONUS + "% maximum flux vents and "
                    + "+" + (int) OP_L1_BONUS + "% ordnance points";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level2 implements CharacterStatsSkillEffect {
        public void apply(MutableCharacterStatsAPI stats, String id, float level) {
            stats.getMaxCapacitorsBonus().modifyPercent(id, CAPACITORS_L2_BONUS);
            stats.getMaxVentsBonus().modifyPercent(id, VENTS_L2_BONUS);
            stats.getShipOrdnancePointBonus().modifyPercent(id, OP_L2_BONUS);
        }

        public void unapply(MutableCharacterStatsAPI stats, String id) {
            stats.getMaxCapacitorsBonus().unmodify(id);
            stats.getMaxVentsBonus().unmodify(id);
            stats.getMaxVentsBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int) CAPACITORS_L2_BONUS + "% maximum flux capacitors, "
                    + "+" + (int) VENTS_L2_BONUS + "% maximum flux vents and "
                    + "+" + (int) OP_L2_BONUS + "% ordnance points";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level3 implements CharacterStatsSkillEffect {
        public void apply(MutableCharacterStatsAPI stats, String id, float level) {
            stats.getMaxCapacitorsBonus().modifyPercent(id, CAPACITORS_L3_BONUS);
            stats.getMaxVentsBonus().modifyPercent(id, VENTS_L3_BONUS);
            stats.getShipOrdnancePointBonus().modifyPercent(id, OP_L3_BONUS);
        }

        public void unapply(MutableCharacterStatsAPI stats, String id) {
            stats.getMaxCapacitorsBonus().unmodify(id);
            stats.getMaxVentsBonus().unmodify(id);
            stats.getMaxVentsBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int) CAPACITORS_L3_BONUS + "% maximum flux capacitors, "
                    + "+" + (int) VENTS_L3_BONUS + "% maximum flux vents and "
                    + "+" + (int) OP_L3_BONUS + "% ordnance points";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

}
