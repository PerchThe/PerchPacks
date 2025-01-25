package me.darkolythe.shulkerpacks;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.ClaimPermission;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GriefPreventionListener {


    public boolean canUseInClaim(Player player) {
        boolean canUse = false;
        UUID claimOwner = this.getClaim(player).getOwnerID();
        if(player.getUniqueId().equals(claimOwner)) canUse = true;
        if(this.getClaim(player).hasExplicitPermission(player, ClaimPermission.Inventory)) canUse = true;
        return canUse;
    }

    public boolean isInClaim(Player player) {
        return this.getClaim(player) != null;
    }

    private Claim getClaim(Player player){
        return GriefPrevention.instance.dataStore.getClaimAt(player.getLocation(), false, null);
    }


}