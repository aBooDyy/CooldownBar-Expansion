[Available placeholders]: https://helpch.at/placeholders

# CooldownBar-Expansion
This is a [PlaceholderAPI](http://placeholderapi.com/) expansion that allows you to display your cooldown in a fancy bar using the symbols
of your choice!

## Placeholders
The expansion provides one placeholder that can be customized with additional values/options.
If a option provides a invalid value, then the default one set in the config.yml of PlaceholderAPI is used.

The default placeholder is `%cooldownbar_{placeholder}%` where `{placeholder}` can be any [available placeholder] that returns a number or any cooldown placeholder
that returns `Xd`, `Xh`, `Xm`, `Xs`.

### `p:`
> **Requires**: `TEXT`
> **Default (Config option)**: `&a|` (`passed`)
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}_p:&a■%`

Sets the symbol/text that is used for already passed time.

### `r:`
> **Requires**: `TEXT`
> **Default (Config option)**: `&7|` (`remaining`)
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}_r:&7■%`

Sets the symbol/text that is used for the remaining time.

### `l:`
> **Requires**: `NUMBER`
> **Default (Config option)**: `10` (`length`)
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}_l:5%`

Sets the maximum length of the cooldown bar. This also affects the bar itself.

### `c:`
> **Requires**: `NUMBER`
> **Default (Config option)**: `100` (`cooldown`)
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}_c:10%`

Sets the main cooldown (cooldown at the beginning). This affects the bar itself.

### `rdy:`
> **Requires**: `TEXT`
> **Default (Config option)**: `&aReady!` (`ready`)
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}_rdy:&aClaim now!%`

Sets the text that is shown when the cooldown has passed out (reached the set cooldown value `c:`).

# Download
You can download this expansion automatically using PAPI download commands:

> ```
> /papi ecloud download CooldownBar
> /papi reload
> ```

Or you can download it manaually from the [eCloud](https://api.extendedclip.com/expansions/cooldownbar/) and then put it in the `expansions` folder (Path: `/plugins/PlaceholderAPI/expansions/`)