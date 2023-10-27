package net.ironf.alchemind.ponders.scenes;

import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

public class essenceMixerScenes {
    public static void essenceMixing(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("essence_mixer_scene", "Mixing Essences with an Essene Mixer");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.world.showSection(util.select.layer(0), Direction.UP);
        scene.world.showSection(util.select.column(2,2),Direction.DOWN);
        scene.idle(3);

        scene.overlay.showText(75).pointAt(new Vec3(2, 4, 2)).text("The essence mixer pulls from the 3 drains below it to make new essences");
        scene.idle(80);

        scene.world.showSection(util.select.fromTo(2,4,0,3,5,1),Direction.UP);
        scene.idle(3);
        scene.overlay.showText(75).pointAt(new Vec3(2, 4, 2)).text("It Requires Arcana and an Accelerator, which control the speed of the machine");
        scene.idle(80);


        scene.overlay.showText(75).pointAt(new Vec3(2, 2, 2)).text("The fluids must be placed in the drains in the proper order based on the recipe shown in JEI");
        scene.idle(80);

        scene.world.showSection(util.select.position(3,4,2),Direction.DOWN);
        scene.world.showSection(util.select.fromTo(3,4,3,2,4,4),Direction.DOWN);

        scene.overlay.showText(75).pointAt(new Vec3(2, 4, 2)).text("If enough Arcana is provided, the recipe completes, and the resulting fluid can be extracted from the Essence Mixer");
        scene.idle(80);

        scene.world.showSection(util.select.everywhere(), Direction.DOWN);
        scene.overlay.showText(75).pointAt(new Vec3(2, 2, 2)).text("You may want to consider using Mechanical Arms and Spouts to insert fluids automatically, but using belts may work");
        scene.idle(80);

        scene.markAsFinished();
    }

    public static void compoundEssenceRadiating(SceneBuilder scene, SceneBuildingUtil util){
        scene.title("compound_essence_radiating", "Radiating Compound Essences");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.world.showSection(util.select.layer(0), Direction.UP);
        scene.world.showSection(util.select.everywhere(), Direction.DOWN);
        scene.idle(3);

        scene.overlay.showText(75).pointAt(new Vec3(2, 2, 2)).text("Compound Essences made with the Essence Mixer create more Arcana per mB for fluid");
        scene.idle(80);

        scene.overlay.showText(75).pointAt(new Vec3(2, 2, 2)).text("This makes arcana storage more compact. Potere is especially Arcana dense");
        scene.idle(80);

        scene.overlay.showText(75).pointAt(new Vec3(2, 2, 2)).text("Other Fluids may be radiate-able, check JEI. Stellar Fuel is incredibly effective");
        scene.idle(80);

        scene.markAsFinished();

    }
}
