# Changelog

## Version 1.0.1

### Added

* Implemented core region protection framework.
* Added region ownership support using player UUIDs.
* Added block break protection within protected regions.
* Added block placement protection within protected regions.
* Added automatic owner bypass for region owners.
* Added region lookup functionality through `RegionManager`.

### Improved

* Refactored region handling into dedicated classes.
* Improved separation between event listeners and region management systems.
* Improved overall project structure for future expansion.
* Updated project documentation and repository configuration.

### Testing

* Added temporary hardcoded test regions for protection validation.
* Verified owner protection bypass functionality.
* Verified administrative bypass permissions.
* Performed initial protection and grief-prevention testing.

### Planned Features

* Precision polygon-based land protection.
* Region visualisation system.
* `/checkregion` command.
* Region member and trust management.
* Container protection.
* Door and interaction protection.
* Entity interaction protection.
* PvP and gameplay flags.
* Native protection engine independent of WorldGuard.

### Notes

LevelGuard is currently in active development and serves as the foundation for future protection and land-claiming systems, including integration with PrecisionClaims.
