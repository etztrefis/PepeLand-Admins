package pepelandadmins;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.world.GameMode;
import org.lwjgl.glfw.GLFW;

public class PepelandAdminsMod implements ModInitializer {
  private GameMode gameMode;
  int i = 0;

  @Override
  public void onInitialize() {
    KeyBinding spectator_switcher = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Spectator switch",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_U,
            "Pepeland for admins"
    ));
    KeyBinding creative_switcher = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Creative switch",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_I,
            "Pepeland for admins"
    ));
    KeyBinding co_switcher = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Co i hotkey",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_O,
            "Pepeland for admins"
    ));
    ClientTickCallback.EVENT.register(client -> {
      while (spectator_switcher.wasPressed()) {
        if (!MinecraftClient.getInstance().player.isSpectator()) {
          client.player.sendChatMessage("/gamemode spectator");
        }
        if (MinecraftClient.getInstance().player.isSpectator()) {
          client.player.sendChatMessage("/gamemode survival");
        }
      }
    });
    ClientTickCallback.EVENT.register(client -> {
      while (creative_switcher.wasPressed()) {
        i++;
        if (i % 2 == 0) {
          client.player.sendChatMessage("/gamemode survival");
        } else {
          client.player.sendChatMessage("/gamemode creative");
        }
        //don`t ask me about this ^ LULW
      }
    });
    ClientTickCallback.EVENT.register(client -> {
      while (co_switcher.wasPressed()) {
        client.player.sendChatMessage("/co i");

      }
    });
  }
}