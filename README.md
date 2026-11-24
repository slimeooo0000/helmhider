# Helm Hider

A RuneLite plugin that hides Ironman helmets from player names in newly
received chat messages while preserving player moderator, Jagex moderator,
and other badges.

## Supported icons

- Ironman
- Ultimate Ironman
- Hardcore Ironman
- Group Ironman
- Hardcore Group Ironman
- Unranked Group Ironman

The plugin processes incoming chat events without restricting the chat channel.

## Behavior and limitations

Changes are local to your client. Message text and timestamps are unchanged.
Existing messages are not processed retroactively. Disabling the plugin does
not restore icons already removed from buffered messages. Other plugins reading
those buffered names may see the cleaned names.

## Development

Install a Java 11 JDK and point JAVA_HOME to it. From the project directory:

```sh
bash ./gradlew run
```

The first run downloads Gradle and required dependencies. The development
launcher starts RuneLite with Helm Hider loaded and developer mode enabled.
Enable **Helm Hider** in the plugin list.

For Jagex Accounts, follow the official [development login instructions](https://github.com/runelite/runelite/wiki/Using-Jagex-Accounts).

Edit `src/main/java/com/helmhider/HelmHiderPlugin.java`, save, close the
client, and run the command again to test changes.

To compile and run the build checks:

```sh
bash ./gradlew build
```

`HelmHiderPluginTest` is the development launcher, not an automated behavior test.

## Manual verification

Check new messages in public, private, friends, clan, guest clan, and group
Ironman chat where available. Verify that Ironman helmets disappear and
moderator crowns and other badges remain. Confirm that message text is intact.
Check that disabling the plugin leaves new messages unchanged; previously
processed messages retain their cleaned names.

## Distribution

This repository contains the plugin source. It has not yet been submitted to
or approved for the RuneLite Plugin Hub.

## License

[BSD 2-Clause](LICENSE).
