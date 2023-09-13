package net.ironf.alchemind.ponders.scenes;

import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

public class acceleratorScenes {

    public static void accelerator(SceneBuilder scene, SceneBuildingUtil util){
        scene.title("accelerator_scene", "Rotating an Accelerator to manage Arcana Machines");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.world.showSection(util.select.layer(0), Direction.UP);
        scene.idle(3);

        scene.world.showSection(util.select.fromTo(2,1,2,4,2,2),Direction.NORTH);
        scene.overlay.showText(80).text("The Accelerator is used to Manage Arcana Machines beneath it, like this radiator").pointAt(new Vec3(2,1,2));
        scene.idle(86);

        scene.overlay.showText(80).text("The Accelerator's speed controls the efficiency of the machine beneath it, but the Accelerator is very Stress intensive").pointAt(new Vec3(2,1,2));
        scene.idle(86);

        scene.world.showSection(util.select.layer(1),Direction.NORTH);
        scene.world.showSection(util.select.layer(2),Direction.SOUTH);
        scene.world.showSection(util.select.layer(3),Direction.EAST);
        scene.world.showSection(util.select.layer(5),Direction.WEST);
        scene.world.showSection(util.select.layer(6),Direction.UP);

        scene.overlay.showText(80).text("As you can see, it has a wide variety of applications");
        scene.idle(86);

        scene.markAsFinished();

    }

    public static void catalyzer(SceneBuilder scene, SceneBuildingUtil util){
        scene.title("catalyzer_scene", "Using a Potion Catalyzer to improve Accelerator Efficiency");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.world.showSection(util.select.layer(0), Direction.UP);
        scene.idle(3);

        scene.world.showSection(util.select.fromTo(4,1,1,2,2,3),Direction.DOWN);
        scene.overlay.showText(80).text("When your Accelerator isn't cutting it, you can introduce a Potion Catalyzer above it to improve it").pointAt(new Vec3(2,2,2));
        scene.idle(43);
        scene.world.showSection(util.select.position(2,3,2), Direction.EAST);
        scene.idle(43);
        scene.overlay.showText(60).text("Place a potion catalyzer above the Accelerator, and a Fluid Tank above the Catalyzer").pointAt(new Vec3(2,3,2));
        scene.idle(33);
        scene.world.showSection(util.select.fromTo(2,1,0,4,4,2),Direction.DOWN);
        scene.idle(33);


        scene.overlay.showText(60).text("The Catalyzer uses potion fluid in the tank above it, the rate of which is controlled by the speed of accelerator").pointAt(new Vec3(2,4,2));
        scene.idle(65);
        scene.overlay.showText(60).text("You can use any potion, but all potions are considered equal to the Potion Catalyzer").pointAt(new Vec3(2,4,2));
        scene.idle(65);
        scene.overlay.showText(60).text("The Potion Catalyzer, when functioning, quadruples the effective speed of the Accelerator").pointAt(new Vec3(2,3,2));
        scene.idle(65);
        /*
        scene.overlay.showText(60).text("This benefit is most helpful for high level Arcana Rotors").pointAt(new Vec3(2,3,2));
        scene.world.showSection(util.select.fromTo(1,1,2,1,2,1),Direction.NORTH);
        scene.idle(65);

         */

        scene.markAsFinished();
    }
}
