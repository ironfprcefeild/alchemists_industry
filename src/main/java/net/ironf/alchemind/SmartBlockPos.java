package net.ironf.alchemind;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class SmartBlockPos extends BlockPos {
    Level dimension;

    public SmartBlockPos(int x, int y, int z) {
        super(x, y, z);
    }

    public SmartBlockPos(BlockPos blockPos) {
        super(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }


    @Override
    public String toString() {
        String A = Integer.toString(this.getX());
        String B = Integer.toString(this.getY());
        String C = Integer.toString(this.getZ());
        return "(" + A + "," + B + "," + C + ")";

    }

    public static SmartBlockPos UnString(String og){

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

        return new SmartBlockPos(Xset, Yset, Zset);
    }

    public Level getDimension() {
        return this.dimension;
    }
}
