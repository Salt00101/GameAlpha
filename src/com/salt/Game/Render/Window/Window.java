package com.salt.Game.Render.Window;

import com.salt.Game.Render.Entity;
import com.salt.Game.Vector.Vector2;
import com.salt.Game.Vector.Vector3;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;
import java.util.Locale;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import com.salt.Game.Player.Player;

public class Window {
    private long window;
    boolean flagUp;
    boolean flagDown;
    boolean flagRight;
    boolean flagLeft;

    public void run() throws InterruptedException {
        System.out.println("LWJGL " + Version.getVersion());

        init();
        loop();

        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        window = glfwCreateWindow(480, 300, "Game", NULL, NULL);
        glfwSetWindowAspectRatio(window, 16, 10);
        glfwGetVideoMode(glfwGetPrimaryMonitor()).height();
        glfwSetWindowSizeLimits(window, 480, 300, glfwGetVideoMode(glfwGetPrimaryMonitor()).width(), glfwGetVideoMode(glfwGetPrimaryMonitor()).height());
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_U && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop

            if ( key == GLFW_KEY_W && action == GLFW_PRESS )
                flagUp = true;

            if ( key == GLFW_KEY_W && action == GLFW_RELEASE )
                flagUp = false;

            if ( key == GLFW_KEY_S && action == GLFW_PRESS )
                flagDown = true;

            if ( key == GLFW_KEY_S && action == GLFW_RELEASE )
                flagDown = false;

            if ( key == GLFW_KEY_A && action == GLFW_PRESS )
                flagLeft = true;

            if ( key == GLFW_KEY_A && action == GLFW_RELEASE )
                flagLeft = false;

            if ( key == GLFW_KEY_D && action == GLFW_PRESS )
                flagRight = true;

            if ( key == GLFW_KEY_D && action == GLFW_RELEASE )
                flagRight = false;

        });

        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        }
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
    }

    private void loop() throws InterruptedException {
        GL.createCapabilities();
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        while ( !glfwWindowShouldClose(window) ) {
            Player.player.draw();
            Player.move(flagUp, flagDown, flagLeft, flagRight);
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public String getOperatingSystem() {
        String os = System.getProperty("os.name");
        return os.toLowerCase();
    }

}