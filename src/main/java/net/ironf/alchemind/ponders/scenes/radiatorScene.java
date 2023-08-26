package net.ironf.alchemind.ponders.scenes;

import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

public class radiatorScene {

    public static void essenceRadiating(SceneBuilder scene, SceneBuildingUtil util){
        scene.title("arcana_radiator_scene", "Radiating Essence to make Arcana");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.world.showSection(util.select.layer(0), Direction.UP);
        scene.idle(3);


        scene.world.showSection(util.select.position(2,1,1),Direction.WEST);
        scene.idle(3);

        scene.overlay.showText(80).pointAt(new Vec3(2,1,1)).text("Arcana is a magical energy used to power various machines");
        scene.idle(85);

        scene.world.showSection(util.select.fromTo(2,1,2,2,2,3),Direction.SOUTH);
        scene.overlay.showText(80).pointAt(new Vec3(2,1,1)).text("Its produced though the Arcana Radiator, using Essence liquid");
        scene.idle(85);

        scene.world.showSection(util.select.position(2,2,1),Direction.DOWN);
        scene.overlay.showText(80).pointAt(new Vec3(2,2,1)).text("Like all arcana machines, an Arcana Accelerator is required above it for it to function");
        scene.idle(85);

        scene.world.showSection(util.select.fromTo(3,1,1,3,2,4),Direction.DOWN);
        scene.overlay.showText(80).pointAt(new Vec3(2,2,1)).text("The Accelerator requires Rotational Energy, its speed controls the speed of the Radiator");
        scene.idle(85);



        scene.overlay.showText(50).pointAt(new Vec3(2,1,2)).text("The Radiator will send arcana to all Adjacent blocks, like this mineral extractor ");
        scene.idle(25);
        scene.world.showSection(util.select.position(2,1,0),Direction.WEST);
        scene.idle(30);

        scene.markAsFinished();


    }

    public static void HeatedEssenceRadiating(SceneBuilder scene, SceneBuildingUtil util){
        scene.title("heated_essence_radiating", "Heated Essence Radiating");
        scene.configureBasePlate(0, 0, 5);
        scene.world.showSection(util.select.layer(0), Direction.EAST);
        scene.idle(3);
        scene.world.showSection(util.select.layer(1), Direction.NORTH);
        scene.idle(3);
        scene.world.showSection(util.select.layer(2), Direction.SOUTH);
        scene.idle(3);
        scene.world.showSection(util.select.layer(3), Direction.WEST);
        scene.idle(6);

        scene.overlay.showText(80).pointAt(new Vec3(2,2,2)).text("When your radiator isn't providing arcana fast enough you can multiply its efficiency with heating");
        scene.idle(85);
        scene.overlay.showText(80).pointAt(new Vec3(2,2,2)).text("Even while heating is provided, the Accelerator's speed still takes an effect on the radiator.");
        scene.idle(85);
        scene.overlay.showText(70).pointAt(new Vec3(2,1,2)).text("Place and heat a blase burner below");
        scene.idle(75);
        scene.overlay.showText(70).pointAt(new Vec3(2,1,2)).text("Only fueled burners improve the radiator, superheated burners even more so");
        scene.idle(75);
        scene.overlay.showText(70).pointAt(new Vec3(2,1,1)).text("you may want to consider adding a system to input fuel automatically using a mechanical arm");
        scene.idle(75);

        scene.markAsFinished();

    }
}
