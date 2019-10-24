package pw.dotdash.eventtester;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.action.InteractEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

@Plugin(id = "event-tester")
public class EventTester {

    @Listener
    public void onInteract(InteractEvent event, @First Player player) {
        String className = event.getClass().getName()
                .replace("org.spongepowered.api.event.", "")
                .replace("$Impl", "")
                .replace("$", "   ");

        player.sendMessage(Text.of(Text.of(TextColors.YELLOW, className), " detected"));
    }
}