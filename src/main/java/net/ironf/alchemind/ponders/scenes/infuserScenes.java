package net.ironf.alchemind.ponders.scenes;

import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

public class infuserScenes {
    public static void infusing(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("arcana_infuser_scene", "Infusing Items with Arcana using the Arcana Infuser");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();

        scene.world.showSection(util.select.layer(0), Direction.UP);
        scene.world.showSection(util.select.fromTo(0,1,2,4,1,2),Direction.NORTH);
        scene.world.showSection(util.select.position(2,3,2), Direction.DOWN);
        scene.overlay.showText(75).pointAt(new Vec3(2,3,2)).text("The Arcana Infuser can be used to infuse items below it");
        scene.idle(80);

        scene.world.showSection(util.select.position(2,4,2),Direction.DOWN);
        scene.world.showSection(util.select.column(2,3), Direction.UP);
        scene.overlay.showText(75).pointAt(new Vec3(2,4,2)).text("It requires an Arcana Accelerator, the speed of the Infuser is based on it's speed");
        scene.idle(80);

        scene.world.showSection(util.select.everywhere(), Direction.UP);
        scene.overlay.showText(65).pointAt(new Vec3(3,3,2)).text("Dont forget to provide Arcana, the Infuser usually needs a lot.");
        scene.idle(70);


    }
}
