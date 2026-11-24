package com.helmhider;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.IconID;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
    name = "Helm Hider",
    description = "Hide Ironman helmets in chat"
)
public class HelmHiderPlugin extends Plugin
{
    private static final IconID[] HIDDEN_ICONS =
    {
        IconID.IRONMAN,
        IconID.ULTIMATE_IRONMAN,
        IconID.HARDCORE_IRONMAN,
        IconID.GROUP_IRONMAN,
        IconID.HARDCORE_GROUP_IRONMAN,
        IconID.UNRANKED_GROUP_IRONMAN
    };

    @Inject
    private Client client;

    @Subscribe
    public void onChatMessage(ChatMessage event)
    {
        MessageNode node = event.getMessageNode();

        if (node == null || node.getName() == null)
        {
            return;
        }

        String originalName = node.getName();
        String cleanedName = removeIronmanIcons(originalName);

        if (!originalName.equals(cleanedName))
        {
            node.setName(cleanedName);
            client.refreshChat();
        }
    }

    private static String removeIronmanIcons(String name)
    {
        for (IconID icon : HIDDEN_ICONS)
        {
            name = name.replace(icon.toString(), "");
        }

        return name;
    }
}