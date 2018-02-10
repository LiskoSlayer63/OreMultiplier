package liznet.oredrop;

import java.util.Arrays;
import java.util.Random;

import liznet.oredrop.Config.ODConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BreakHandler {

    @SubscribeEvent
	public static void onPlayerHarvestEvent(HarvestDropsEvent event) {
    	// Check if there's harvester and if the mod is enabled
		
		if (event.getHarvester() != null && ODConfig.extraDropEnabled) {
			
			if(event.isSilkTouching() || !event.getState().getMaterial().equals(Material.ROCK)){
				// Player is using Silk Touching or the material isn't considered as a rock
				return;
			}
			
			// Get block which was destroyed
			Block block = event.getState().getBlock();
			
			// If the block was redstone we need some more configuration (redstone is weird)
			if (block == Blocks.LIT_REDSTONE_ORE) {
				block = Blocks.REDSTONE_ORE;
			}

			try {
				if ((!ODConfig.blacklistMode && Arrays.asList(ODConfig.extraDropOres).contains(block.getRegistryName().toString())) || (ODConfig.blacklistMode && !Arrays.asList(ODConfig.extraDropOres).contains(block.getRegistryName().toString()))) {
					Random rand = new Random();
					
					for(ItemStack itemStack : event.getDrops()){
						if(!itemStack.getItem().getRegistryName().equals(block.getRegistryName()) && !(itemStack.getItem() instanceof ItemBlock)){
							// Item doesn't drop itself and the dropped item wasn't an ItemBlock
							int multi = rand.nextInt(ODConfig.maxDropMulti - ODConfig.minDropMulti + 1) + ODConfig.minDropMulti;
							itemStack.setCount(itemStack.getCount() * multi);
						}
					}
				}
			} catch(Exception ex) { }
		}
	}
}