package pepelandadmins;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.options.StickyKeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;

public class PepelandAdminsMod implements ModInitializer {
  @Override
  public void onInitialize() {
    KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      "Gamemode switcher",
      InputUtil.Type.KEYSYM,
      GLFW.GLFW_KEY_U,
      "Pepeland for admins"
  ));
  ClientTickCallback.EVENT.register(client -> {
    while (keyBinding.wasPressed()) {
	    client.player.sendMessage(new LiteralText("/gamemode creative"), false);
    }
  });
  }
}