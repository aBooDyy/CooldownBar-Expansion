[Available placeholders]: https://helpch.at/placeholders

# CooldownBar-Expansion
This is a [PlaceholderAPI](http://placeholderapi.com/) expansion that allows you to display your cooldown in a fancy bar using the symbols
of your choice!

## Placeholders
The expansion provides two placeholder that can be customized with additional values/options.
If a option provides a invalid value, then the default one set in the config.yml of PlaceholderAPI is used.

### `%cooldownbar_{placeholder}%`

#### `{placeholder}` (**Required field**)
> **Requires**: A placeholder that returns a number (The time in seconds) OR `Xd`, `Xh`, `Xm`, `Xs`. [Available placeholders] <br />
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}%`

#### `p:`
> **Requires**: `TEXT` <br />
> **Default (Config option)**: `&a|` (`passed`) <br />
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}_p:&a■%`

Sets the symbol/text that is used for already passed time.

#### `r:`
> **Requires**: `TEXT` <br />
> **Default (Config option)**: `&7|` (`remaining`) <br />
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}_r:&7■%`

Sets the symbol/text that is used for the remaining time.

#### `l:`
> **Requires**: `NUMBER` <br />
> **Default (Config option)**: `10` (`length`) <br />
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}_l:5%`

Sets the maximum length of the cooldown bar. This also affects the bar itself.

#### `c:`
> **Requires**: `NUMBER` OR `DURATION` (`Xd`, `Xh`, `Xm`, `Xs`) <br />
> **Default (Config option)**: `100` (`cooldown`) <br />
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}_c:10%`

Sets the main cooldown (cooldown at the beginning). This affects the bar itself.

#### `rdy:`
> **Requires**: `TEXT` <br />
> **Default (Config option)**: `&aReady!` (`ready`) <br />
> **Example**: `%cooldownbar_{essentials_kit_time_until_available_tools}_rdy:&aClaim now!%`

Sets the text that is shown when the cooldown has passed out (reached the set cooldown value `c:`).

### `%cooldownbar_percentage_{placeholder}%`

#### `{placeholder}` (**Required field**)
> **Requires**: A placeholder that returns a number (The time in seconds) OR `Xd`, `Xh`, `Xm`, `Xs`. [Available placeholders] <br />
> **Example**: `%cooldownbar_percentage_{essentials_kit_time_until_available_tools}%`

#### `c:`
> **Requires**: `NUMBER` OR `DURATION` (`Xd`, `Xh`, `Xm`, `Xs`) <br />
> **Default (Config option)**: `100` (`cooldown`) <br />
> **Example**: `%cooldownbar_percentage_{essentials_kit_time_until_available_tools}_c:10%`

Sets the main cooldown (cooldown at the beginning). This affects the percentage itself.

#### `d:`
> **Requires**: `NUMBER` <br />
> **Default (Config option)**: `2` (`decimal`) <br />
> **Example**: `%cooldownbar_percentage_{essentials_kit_time_until_available_tools}_d:0%` <br />

Sets the amount of decimals that will be shown. For example, with d:3 if the percentage is 50 it will return 50.000

# Download
You can download this expansion automatically using PAPI download commands:

> ```
> /papi ecloud download CooldownBar
> /papi reload
> ```

Or you can download it manaually from the [eCloud](https://api.extendedclip.com/expansions/cooldownbar/) and then put it in the `expansions` folder (Path: `/plugins/PlaceholderAPI/expansions/`)