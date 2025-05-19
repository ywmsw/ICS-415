package com.gameengine.world;

import java.util.HashMap;
import java.util.Map;
// import com.gameengine.world.Block;

public class Chunk {
    private final int chunkX;
    private final int chunkZ;
    private final Map<String, Block> blocks;

    public Chunk(int chunkX, int chunkZ) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.blocks = new HashMap<>();
        loadBlocks();
    }

    private void loadBlocks() {
        // Load blocks into the chunk (this is a placeholder for actual block loading logic)
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                blocks.put(x + "," + z, new Block("Dirt", x + chunkX * 16, z + chunkZ * 16));
            }
        }
    }

    public Block getBlockAt(int x, int z) {
        return blocks.get(x + "," + z);
    }

    public int getChunkX() {
        return chunkX;
    }

    public int getChunkZ() {
        return chunkZ;
    }
}