package com.salt.Game.Texture;

import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import java.io.InputStream;

import static org.lwjgl.stb.STBImage.*;

public class Texture {
    public ByteBuffer filePath;
    private final int LENGTH = 16;
    private final int WIDTH = 16;
    private IntBuffer x;
    private IntBuffer y;
    private IntBuffer n;
    public ByteBuffer imgBuffer;

    public Texture(String filePath) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            x = stack.mallocInt(1);
            y = stack.mallocInt(1);
            n = stack.mallocInt(1);
            imgBuffer = stbi_load(filePath, x, y, n, 4);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
