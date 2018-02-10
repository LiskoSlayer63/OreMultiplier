package liznet.oredrop;

import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;

public class Config {

	@net.minecraftforge.common.config.Config(modid = OreDrop.modId)
	public static class ODConfig{
		
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

		@Comment({"If enabled this inverts the ore list so every ore that drops items instead of the block itself will multiply, except those in the list"})
		@Name("Blacklist mode")
		public static boolean blacklistMode = true;
	}

}
