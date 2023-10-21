package net.ironf.alchemind.data;

import net.ironf.alchemind.SmartBlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;

public class arcana_maps extends SavedData {

    //Stuff to Save
    ///Arcana Map
    public static HashMap<SmartBlockPos, Integer> ArcanaMap = new HashMap<>();

    public static HashMap<SmartBlockPos, Integer> getArcanaMap() {
        return ArcanaMap;
    }

    public void addToArcanaMap(SmartBlockPos key, int newValue) {
        ArcanaMap.put(key,newValue);
        this.setDirty();
    }

    public void setArcanaMap(HashMap<SmartBlockPos, Integer> toSet){
        this.ArcanaMap = toSet;
        this.setDirty();
    }
    ///Is Arcana Taker map
    public static HashMap<SmartBlockPos,Boolean> IsArcanaTaker = new HashMap<>();
    public HashMap<SmartBlockPos, Boolean> getisArcanaTakerMap() {
        return this.IsArcanaTaker;
    }
    public void addToArcanaMap(SmartBlockPos key, boolean newValue) {
        IsArcanaTaker.put(key,newValue);
        this.setDirty();
    }
    public void setIsArcanaTakerMap(HashMap<SmartBlockPos, Boolean> toSet){
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
    public static HashMap<SmartBlockPos, Boolean> booleanHashMapUnString(String og){
        HashMap<SmartBlockPos, Boolean> ToReturnMap = new HashMap<SmartBlockPos, Boolean>();
        for (int i = 0; i != og.length(); i++){
            Boolean toPut = null;

            SmartBlockPos newKey = null;

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

                newKey = SmartBlockPos.UnString(og.substring(a, i));

                ToReturnMap.put(newKey,toPut);
            }
        }
        return ToReturnMap;
    }
    public static HashMap<SmartBlockPos, Integer> integerHashMapUnString(String og){
        HashMap<SmartBlockPos, Integer> ToReturnMap = new HashMap<SmartBlockPos, Integer>();
        for (int i = 0; i != og.length(); i++){
            Integer toPut = null;

            SmartBlockPos newKey = null;

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

                newKey = SmartBlockPos.UnString(og.substring(a, i));

                ToReturnMap.put(newKey,toPut);
            }
        }
        return ToReturnMap;
    }

}




