package data.scripts.rulecmd;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.impl.campaign.rulecmd.BaseCommandPlugin;
import com.fs.starfarer.api.util.Misc;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class EquestriaDialogManager extends BaseCommandPlugin {

    public boolean execute(String ruleId, InteractionDialogAPI dialog, List<Misc.Token> params, Map<String, MemoryAPI> memoryMap){
        Global.getLogger(this.getClass()).info("Fired Event " + ruleId.toLowerCase(Locale.ROOT) + dialog.getInteractionTarget().getId());

        // When the player first interacts with Equestria
        if (dialog.getInteractionTarget().getId() == "equestrian_alpha"){
            dialog.getOptionPanel().clearOptions();
            dialog.getTextPanel().addImage("graphics/portraits/portrait_celestia01.png");
            dialog.getTextPanel().addPara("Your fleet closes in on a dreary world.");
            dialog.getOptionPanel().addOption("Get closer.", test());
        }

        return true;
    }

    private boolean test(){
        Global.getLogger(this.getClass()).info("All good on the western front!");
        return true;
    }
}
