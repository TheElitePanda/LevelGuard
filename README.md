# LevelGuard

Advanced Minecraft region protection framework for Paper servers.

---

## About

LevelGuard is a lightweight and expandable Minecraft protection framework designed for modern Paper servers.

The plugin focuses on precision region handling, advanced protection systems, and future polygon-based region support.

Built by Level Check Studios, LevelGuard is designed to provide developers and server owners with a modern alternative to traditional protection systems while remaining lightweight and highly configurable.

---

# Features

- Region protection system
- Precision-based region handling
- Real-time protection checks
- Region visualisation support
- Lightweight architecture
- Expandable API system
- Future polygon region support
- Modern Paper compatibility
- Developer integration support

---

# Protection Features

LevelGuard is capable of protecting regions against:

- Block breaking
- Block placing
- Unauthorised interaction
- Container access
- General griefing behaviour

---

# Commands

| Command | Description | Permission |
|---|---|---|
| `/levelguard` | Main LevelGuard command | `levelguard.use` |
| `/lg` | Alias for `/levelguard` | `levelguard.use` |

---

# Permissions

| Permission | Description |
|---|---|
| `levelguard.use` | Allows access to LevelGuard commands |
| `levelguard.admin` | Allows administrative functionality |
| `levelguard.bypass` | Bypass all protection checks |

---

# Installation

1. Download the latest release
2. Place the plugin inside your `/plugins/` folder
3. Restart the server
4. Configure LevelGuard if required

---

# Requirements

## Server Software
- Paper

## Minecraft Version
- 1.20+

---

# Developer API

LevelGuard includes an expandable API designed for developers who want to integrate custom systems into the protection framework.

The API can be used for:

- Region protection checks
- Custom gameplay systems
- Region-aware mechanics
- Administrative tools
- External plugin integrations
- Future custom protection logic

---

# Example API Usage

## plugin.yml

```yaml
depend: [LevelGuard]
```

Or:

```yaml
softdepend: [LevelGuard]
```

---

## Accessing The API

```java
LevelGuardAPI api = LevelGuardProvider.get();
```

---

## Protection Check Example

```java
if (!api.canBuild(player, location)) {

    player.sendMessage("You cannot build here.");
}
```

---

## Public API Package

```text
me.dtmpanda.levelguard.api
```

Anything within the API package is considered public and safe for developers to use.

Internal packages may change between updates.

---

# Planned Features

- Polygon region support
- Advanced visual region previews
- Region flags and priorities
- GUI management systems
- Database support
- Cross-world region handling
- Advanced ownership systems
- Expanded developer hooks
- Region analytics & logging

---

# Project Goals

LevelGuard is designed around:

- Lightweight performance
- Expandable architecture
- Modern Paper support
- Precision-based protection
- Developer-friendly integration
- Future scalability

---

# Compatibility

LevelGuard is designed for modern Paper server environments and future Minecraft compatibility whenever possible.

---

# Disclaimer

LevelGuard is intended solely for legitimate server protection and administrative use.

The plugin does not contain:
- Malicious code
- Backdoors
- Client crashing systems
- Packet abuse
- Troll mechanics
- Harmful behaviour

---

# Support

Website:

https://levelcheckstudios.com

---

# License

This project is licensed under the MIT License unless otherwise specified.
