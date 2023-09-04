package net.ironf.alchemind.data;

import com.mojang.logging.LogUtils;
import net.ironf.alchemind.BlockDimPos;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class arcana_maps extends SavedData {

    //Stuff to Save
    ///Arcana Map
    public static HashMap<BlockDimPos, Integer> ArcanaMap = new HashMap<>();

    public HashMap<BlockDimPos, Integer> getArcanaMap() {
        return this.ArcanaMap;
    }

    public void addToArcanaMap(BlockDimPos key, int newValue) {
        this.ArcanaMap.put(key,newValue);
        this.setDirty();
    }

    public void setArcanaMap(HashMap<BlockDimPos, Integer> toSet){
        this.ArcanaMap = toSet;
        this.setDirty();
    }
    ///Is Arcana Taker map
    public static HashMap<BlockDimPos,Boolean> IsArcanaTaker = new HashMap<>();
    public HashMap<BlockDimPos, Boolean> getisArcanaTakerMap() {
        return this.IsArcanaTaker;
    }
    public void addToArcanaMap(BlockDimPos key, boolean newValue) {
        this.IsArcanaTaker.put(key,newValue);
        this.setDirty();
    }
    public void setIsArcanaTakerMap(HashMap<BlockDimPos, Boolean> toSet){
        this.IsArcanaTaker = toSet;
        this.setDirty();
    }
    //Actual Stuff
    public static arcana_maps create() {
        return new arcana_maps();
    }

    public static arcana_maps load(CompoundTag tag) {
        arcana_maps data = create();
        data.IsArcanaTaker = booleanHashMapUnString(tag.getString("IsArcanaTaker"));
        data.ArcanaMap = integerHashMapUnString(tag.getString("ArcanaMap"));
        return data;
    }

    public CompoundTag save(CompoundTag tag) {
        tag.putString("IsArcanaTaker", IsArcanaTaker.toString());
        tag.putString("ArcanaMap", ArcanaMap.toString());
        this.setDirty();
        return tag;
    }

    public static arcana_maps manage(MinecraftServer server) {
        arcana_maps data = server.overworld().getDataStorage().computeIfAbsent(arcana_maps::load, arcana_maps::create, "arcana-hashmap");
        return data;
    }

    //Helper Functions because minecraft is a certified hashmap disliker
    public static HashMap<BlockDimPos, Boolean> booleanHashMapUnString(String og){
        HashMap<BlockDimPos, Boolean> ToReturnMap = new HashMap<BlockDimPos, Boolean>();
        for (int i = 0; i != og.length(); i++){
            Boolean toPut = null;

            BlockDimPos newKey = null;

            if (og.charAt(i) == '='){
                int a = i;
                while (og.charAt(a) != ',' && og.charAt(a) != '}'){
                    a++;
                }
                toPut = Boolean.parseBoolean(og.substring(i+1,a));

                a = i;
                while (og.charAt(a) != '('){
                    a = a - 1;
                }

                newKey = BlockDimPos.UnString(og.substring(a, i));

                ToReturnMap.put(newKey,toPut);
            }
        }
        return ToReturnMap;
    }
    public static HashMap<BlockDimPos, Integer> integerHashMapUnString(String og){
        HashMap<BlockDimPos, Integer> ToReturnMap = new HashMap<BlockDimPos, Integer>();
        for (int i = 0; i != og.length(); i++){
            Integer toPut = null;

            BlockDimPos newKey = null;

            if (og.charAt(i) == '='){
                int a = i;
                while (og.charAt(a) != ',' && og.charAt(a) != '}'){
                    a++;
                }
                toPut = Integer.parseInt(og.substring(i+1,a));

                a = i;
                while (og.charAt(a) != '('){
                    a = a - 1;
                }

                newKey = BlockDimPos.UnString(og.substring(a, i));

                ToReturnMap.put(newKey,toPut);
            }
        }
        return ToReturnMap;
    }

    //Doing the Do (yes)

    /*
    private static final Logger LOGGER = LogUtils.getLogger();
    @SubscribeEvent
    public void ServerStarting(ServerStartingEvent event)
    {




    }

    @SubscribeEvent
    public void ServerStopping(ServerStoppingEvent event)
    {


    }

     */
}




