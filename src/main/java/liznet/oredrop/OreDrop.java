package liznet.oredrop;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = OreDrop.modId, name = OreDrop.name, version = OreDrop.version, acceptedMinecraftVersions = "[1.12.2]", acceptableRemoteVersions = "*")
public class OreDrop {

	public static final String modId = "oredrop";
	public static final String name = "Ore Drop Multiplier";
	public static final String version = "1.0.1";

	@Mod.Instance(modId)
	public static OreDrop instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		CLogger.init(event.getModLog());
		MinecraftForge.EVENT_BUS.register(BreakHandler.class);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}