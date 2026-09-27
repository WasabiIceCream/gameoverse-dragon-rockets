# Gameoverse Dragon Rockets

Elytra boosting needs a **Dragon's Breath Firework**. A vanilla Firework Rocket used while
gliding does nothing (an action-bar message explains why); everything else about vanilla
rockets (crossbows, displays, dispensers, launching one from the ground) is unchanged.

- Item `gameoverse_dragon_rockets:dragon_breath_firework`: a plain `FireworkRocketItem`, so it
  boosts exactly like a vanilla rocket of the same flight duration.
- Recipes (shapeless, 8 per craft, the bottle comes back as a Glass Bottle through Dragon's
  Breath's own crafting remainder): Dragon's Breath + Paper + 1, 2 or 3 Gunpowder for flight
  duration 1, 2 or 3. Recipe-book unlock on picking up Dragon's Breath.
- `FireworkRocketItemMixin`: `FireworkRocketItem.use` returns FAIL for `minecraft:firework_rocket`
  while the player `isFallFlying()`.
- Texture: vanilla's firework rocket with its reds swapped for the Dragon's Breath bottle's
  pinks.

Other boosts on this server, checked 2026-09-26: Do a Barrel Roll's thrust is off
(`allowThrusting` defaults to false server-side); Riptide and Wind Charges are vanilla and
situational, left alone. Dragon's Breath sources: bottling the Ender Dragon's breath, the
Dragon Wight (one of Dragonkind Evolved's 15 respawned-dragon variants, `dke:dragons/wight`,
3-4 rolls over 4 equal entries), and, the only one before the End, Moog's Mineshafts' jungle
`brewing_scraps` chests (weight 2 of 23).

Both sides (the item and its texture are needed on the client); install on the server,
AutoModpack ships it. Build: `./gradlew build`. MIT.
