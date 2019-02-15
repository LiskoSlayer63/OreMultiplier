package liznet.oredrop;

import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@net.minecraftforge.common.config.Config(modid = OreDrop.modId)
public class Config {
	@Comment({"Enables this mod"})
	@Name("Enabled")
	public static boolean extraDropEnabled = true;

	@Comment({"Minimum multiplier for drops"})
	@Name("Min. multiplier")
	public static int minDropMulti = 2;
	
	@Comment({"Maximum multiplier for drops"})
	@Name("Max. multiplier")
	public static int maxDropMulti = 4;
	
	@Comment({"List of ores that should drop extra loot"})
	@Name("Ore list")
	public static String[] extraDropOres = new String[]{};

	@Comment({"If enabled this inverts the ore list so every ore will multiply, except those in the list"})
	@Name("Blacklist mode")
	public static boolean blacklistMode = true;
	
	@EventBusSubscriber(modid = OreDrop.modId)
	private static class EventHandler {
		@SubscribeEvent
		public static void onConfigChanged(final OnConfigChangedEvent event) {
			if (event.getModID().equals(OreDrop.modId)) {
				ConfigManager.sync(OreDrop.modId, net.minecraftforge.common.config.Config.Type.INSTANCE);
			}
		}
}
}
