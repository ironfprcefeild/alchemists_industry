execute as @e[type=!#alchemind:fluid_effect_immune] if block ~ ~ ~ alchemind:aero_fluid_block run effect give @e[sort=nearest,limit=1] minecraft:levitation 1 30
execute as @e[type=!#alchemind:fluid_effect_immune] if block ~ ~ ~ alchemind:aqua_fluid_block run effect give @e[sort=nearest,limit=1] minecraft:dolphins_grace 10 10
execute as @e[type=!#alchemind:fluid_effect_immune] if block ~ ~ ~ alchemind:ignus_fluid_block run effect give @e[sort=nearest,limit=1] minecraft:fire_resistance 15 3
execute as @e[type=!#alchemind:fluid_effect_immune] if block ~ ~ ~ alchemind:terra_fluid_block run effect give @e[sort=nearest,limit=1] minecraft:resistance 15 3
execute as @e[type=!#alchemind:fluid_effect_immune] if block ~ ~ ~ alchemind:terra_fluid_block run effect give @e[sort=nearest,limit=1] minecraft:slowness 15 2

##TODO make sure the fix to all nearby entities floating when stepping in aero actually worked