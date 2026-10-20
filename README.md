# NoTooExpensive

Removes the anvil's **"Too Expensive!"** cap on Paper/Purpur servers.

Vanilla blocks any single anvil operation that costs 40 levels or more. This plugin raises that per-operation limit (default 32767), so combining enchanted books never gets blocked. It only changes the cap; the XP cost of each step is unchanged, and players still need the levels.

## Install

Drop `NoTooExpensive.jar` into `plugins/` and restart. Built for Purpur/Paper 26.3.

## Config

`plugins/NoTooExpensive/config.yml`

```yaml
max-repair-cost: 32767   # vanilla is 40
```

## How it works

It sets `AnvilView#setMaximumRepairCost` when an anvil opens and again on every `PrepareAnvilEvent`.

## Support

[Buy me a coffee](https://buymeacoffee.com/hackatoa)
