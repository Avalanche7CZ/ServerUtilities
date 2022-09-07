package ftb.utils.mod;

import cpw.mods.fml.relauncher.*;
import ftb.lib.api.gui.*;
import ftb.utils.mod.client.gui.claims.GuiClaimChunks;
import ftb.utils.mod.client.gui.friends.GuideFriendsGUI;
import ftb.utils.mod.client.gui.guide.GuiGuide;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;

public class FTBUGuiHandler extends LMGuiHandler {
    public static final FTBUGuiHandler instance = new FTBUGuiHandler(FTBUFinals.MOD_ID);

    public static final int FRIENDS = 1;
    public static final int SECURITY = 2;
    public static final int ADMIN_CLAIMS = 3;

    public FTBUGuiHandler(String s) {
        super(s);
    }

    public Container getContainer(EntityPlayer ep, int id, NBTTagCompound data) {
        return new ContainerEmpty(ep, null);
    }

    @SideOnly(Side.CLIENT)
    public GuiScreen getGui(EntityPlayer ep, int id, NBTTagCompound data) {
        if (id == FRIENDS) return new GuiGuide(null, new GuideFriendsGUI());
        else if (id == ADMIN_CLAIMS) return new GuiClaimChunks(data.getLong("T"));
        return null;
    }
}
