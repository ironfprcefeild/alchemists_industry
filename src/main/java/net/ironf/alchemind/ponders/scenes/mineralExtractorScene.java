package net.ironf.alchemind.ponders.scenes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import net.ironf.alchemind.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class mineralExtractorScene {
    public static void extracting(SceneBuilder scene, SceneBuildingUtil util){
        scene.title("mineral_extractor_scene", "Using the Mineral Extractor");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();

        scene.world.showSection(util.select.layer(0), Direction.UP);


        //Put in a mineral Extractor
        scene.world.showSection(util.select.position(2,2,2),Direction.NORTH);

        scene.overlay.showText(75).pointAt(new Vec3(2,2,2)).text("The Mineral Extractor removes material from the block beneath it using Arcana");

        scene.idle(80);

        //Move in a block of endstone
        scene.world.showSection(util.select.position(2,1,2),Direction.NORTH);

        //Move in an accelerator with cogs
        scene.world.showSection(util.select.position(2,3,2),Direction.NORTH);
        scene.world.showSection(util.select.position(2,3,2),Direction.NORTH);
        scene.world.setBlock(new BlockPos(2,3,3), AllBlocks.COGWHEEL.getDefaultState(), false);
        scene.world.showSection(util.select.position(2,3,3),Direction.NORTH);
        scene.world.showSection(util.select.position(2,3,4),Direction.NORTH);
        scene.world.showSection(util.select.position(1,3,4),Direction.NORTH);
        scene.world.showSection(util.select.position(1,2,4),Direction.NORTH);
        scene.world.showSection(util.select.position(1,1,4),Direction.NORTH);

        scene.overlay.showText(75).pointAt(new Vec3(2,3,2)).text("It requires an Arcana Accelerator, which controls its extraction speed");
        scene.idle(80);
        //Move in a Radiator with Accelerator, and connect pipes

        scene.world.setBlock(new BlockPos(2,3,3), ModBlocks.ACCELERATOR.get().defaultBlockState(), false);
        scene.idle(1);
        scene.world.showSection(util.select.position(2,3,3), Direction.NORTH);
        scene.world.showSection(util.select.position(2,2,3), Direction.NORTH);
        scene.world.showSection(util.select.position(2,2,4), Direction.NORTH);
        scene.world.showSection(util.select.position(2,1,4), Direction.NORTH);


        scene.overlay.showText(45).pointAt(new Vec3(2,3,1)).text("Remember to provide Arcana");
        scene.idle(50);

        scene.overlay.showText(45).pointAt(new Vec3(2,3,1)).text("Different Recipes use different amounts of Arcana");
        scene.idle(50);
        //Break the Endstone
        scene.world.setBlock(new BlockPos(2,1,2), Blocks.AIR.defaultBlockState(), true);


        scene.overlay.showText(75).pointAt(new Vec3(2,3,1)).text("Different Recipes have different chances to successfully extract, as well to break the source block when the recipe is successful");

        scene.idle(15);
        scene.world.showSection(util.select.position(2,1,1), Direction.NORTH);
        scene.world.showSection(util.select.position(2,2,1), Direction.NORTH);
        scene.idle(65);

        scene.markAsFinished();


    }
}
