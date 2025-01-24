package me.darkolythe.shulkerpacks;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.ClaimPermission;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GriefPreventionListener {

    public static boolean canUseInClaim(Player player) {

        Claim claim = GriefPrevention.instance.dataStore.getClaimAt(player.getLocation(), false, null);
        if(claim == null) return true; // Claim doesn't exist

        boolean canUse = false;
        UUID claimOwner = claim.getOwnerID();
        if(player.getUniqueId().equals(claimOwner)) canUse = true;
        if(claim.hasExplicitPermission(player, ClaimPermission.Inventory)) canUse = true;


        return canUse;
    }


}