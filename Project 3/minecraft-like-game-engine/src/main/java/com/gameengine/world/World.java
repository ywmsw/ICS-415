package com.gameengine.world;

import java.util.HashMap;
import java.util.Map;

public class World {
    private Map<Integer, Chunk> chunks;

    public World() {
        chunks = new HashMap<>();
    }

    public void generateWorld() {
        // Logic to generate the world and populate chunks
    }

    public Chunk getChunkAt(int x, int z) {
        return chunks.get(generateChunkKey(x, z));
    }

    private int generateChunkKey(int x, int z) {
        return (x << 16) | (z & 0xFFFF);
    }

    public void loadChunk(int x, int z) {
        // Logic to load a chunk at the specified coordinates
    }

    public void render() {
        // Logic to render the world and its chunks
    }
}