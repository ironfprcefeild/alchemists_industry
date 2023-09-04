package net.ironf.alchemind;

import com.google.common.base.MoreObjects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.awt.*;

public class BlockDimPos extends BlockPos {
    Level dimension;

    public BlockDimPos(int x, int y, int z, Level dimension) {
        super(x, y, z);
        this.dimension = dimension;
    }

    public BlockDimPos(BlockPos blockPos, Level dimension) {
        super(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        this.dimension = dimension;
    }


    @Override
    public String toString() {
        String A = Integer.toString(this.getX());
        String B = Integer.toString(this.getY());
        String C = Integer.toString(this.getZ());
        return "(" + A + "," + B + "," + C + ")";

    }

    public static BlockDimPos UnString(String og){

        int A = 0;
        int B = 0;

        int Xset = 0;
        int Yset = 0;
        int Zset = 0;

        int tracker = 1;
        while (A != og.length()){
            if (og.charAt(A) == ',' || og.charAt(A) == ')'){
                B = A-1;
                while (og.charAt(B) != ',' && og.charAt(B) != '('){
                    B = B-1;
                }

                if (tracker == 1){
                    Xset = Integer.parseInt(og.substring(B+1,A));
                    tracker++;
                } else if (tracker == 2) {
                    Yset = Integer.parseInt(og.substring(B+1,A));
                    tracker++;
                } else if (tracker == 3) {
                    Zset = Integer.parseInt(og.substring(B+1,A));
                    tracker++;
                }

            }
            A++;
        }

        return new BlockDimPos(Xset, Yset, Zset, null);
    }

    public Level getDimension() {
        return this.dimension;
    }
}
