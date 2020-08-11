package pepelandadmins;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.options.StickyKeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import net.minecraft.world.GameMode;
import org.lwjgl.glfw.GLFW;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;

import java.util.Collection;
import java.util.Collections;

public class PepelandAdminsMod implements ModInitializer {
  private GameMode gameMode;
  @Override
  public void onInitialize() {
    KeyBinding spectator_switcher = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      "Spectator switcher",
      InputUtil.Type.KEYSYM,
      GLFW.GLFW_KEY_U,
      "Pepeland for admins"
  ));
  KeyBinding creative_switcher = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      "Creative switcher",
      InputUtil.Type.KEYSYM,
      GLFW.GLFW_KEY_I,
      "Pepeland for admins"
  ));
  ClientTickCallback.EVENT.register(client -> {
    while (spectator_switcher.wasPressed()) {
      /*GameType[] gameTypes = GameType.values(); 
      for(GameType gameType : gameTypes){
        if(gameType != GameType.SPECTATOR){
          client.player.sendChatMessage("/gamemode spectator");
        } else if (gameType == GameType.SPECTATOR){
          client.player.sendChatMessage("/gamemode survival");
        }
      }*/
      client.player.sendChatMessage("/gamemode spectator");
    }
  });
  ClientTickCallback.EVENT.register(client -> {
    while (creative_switcher.wasPressed()) {
      if(!gameMode.isCreative()){
	    client.player.sendChatMessage("/gamemode creative");
    }else{
      client.player.sendChatMessage("/gamemode survival");
    }
  }
  });
}
}