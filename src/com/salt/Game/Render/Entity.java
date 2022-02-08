package com.salt.Game.Render;

import com.salt.Game.Vector.Vector2;
import com.salt.Game.Vector.Vector3;

import static org.lwjgl.opengl.GL11.*;

import static com.salt.Game.Player.Player.*;

public class Entity {
    Vector3 colorArray;
    Vector2 vertex1;
    Vector2 vertex2;
    Vector2 vertex3;
    Vector2 vertex4;
    float distanceY;
    float distanceX;
    int type;

    public Entity(Vector3 colorArray, Vector2 vertex1, Vector2 vertex2, Vector2 vertex3, Vector2 vertex4) {
        this.colorArray = colorArray;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.vertex4 = vertex4;
        type = GL_QUADS;
        distanceY = (float) Math.abs(Math.pow((vertex1.y - vertex4.y), 2) + Math.pow((vertex1.x - vertex4.x), 2));
        distanceX = (float) Math.abs(Math.pow((vertex1.x - vertex2.x), 2) + Math.pow((vertex1.y - vertex2.y), 2));
    }

    public Entity(Vector3 colorArray, Vector2 vertex1, Vector2 vertex2, Vector2 vertex3) {
        this.colorArray = colorArray;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        type = GL_TRIANGLES;
    }

    public void draw() {
        glClear(GL_COLOR_BUFFER_BIT);
        if (type == GL_QUADS) {
            glColor3f(colorArray.x, colorArray.y, colorArray.z);
            glBegin(type);
            glVertex2f(vertex1.x, vertex1.y);
            glVertex2f(vertex2.x, vertex2.y);
            glVertex2f(vertex3.x, vertex3.y);
            glVertex2f(vertex4.x, vertex4.y);
            glEnd();
        } else {
            glColor3f(colorArray.x, colorArray.y, colorArray.z);
            glBegin(type);
            glVertex2f(vertex1.x, vertex1.y);
            glVertex2f(vertex2.x, vertex2.y);
            glVertex2f(vertex3.x, vertex3.y);
            glEnd();
        }
    }

    public void up() {
        glClear(GL_COLOR_BUFFER_BIT);
        vertex1.y += 2.0f/9;
        vertex2.y += 2.0f/9;
        vertex3.y += 2.0f/9;
        vertex4.y += 2.0f/9;
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void down() {
        glClear(GL_COLOR_BUFFER_BIT);
        vertex1.y -= 2.0f/9;
        vertex2.y -= 2.0f/9;
        vertex3.y -= 2.0f/9;
        vertex4.y -= 2.0f/9;
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void left() {
        glClear(GL_COLOR_BUFFER_BIT);
        vertex1.x -= 2.0f/16;
        vertex2.x -= 2.0f/16;
        vertex3.x -= 2.0f/16;
        vertex4.x -= 2.0f/16;
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void right() {
        glClear(GL_COLOR_BUFFER_BIT);
        vertex1.x += 2.0f/16;
        vertex2.x += 2.0f/16;
        vertex3.x += 2.0f/16;
        vertex4.x += 2.0f/16;
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void toBottom() {
        glClear(GL_COLOR_BUFFER_BIT);
        vertex1.y = -9f/9;
        vertex2.y = -7f/9;
        vertex3.y = -7f/9;
        vertex4.y = -9f/9;
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void toTop() {
        glClear(GL_COLOR_BUFFER_BIT);
        vertex1.y = 7f/9;
        vertex2.y = 9f/9;
        vertex3.y = 9f/9;
        vertex4.y = 7f/9;
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void toLeft() {
        glClear(GL_COLOR_BUFFER_BIT);
        vertex1.x = -16f/16;
        vertex2.x = -16f/16;
        vertex3.x = -14f/16;
        vertex4.x = -14f/16;
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void toRight() {
        glClear(GL_COLOR_BUFFER_BIT);
        vertex1.x = 14f/16;
        vertex2.x = 14f/16;
        vertex3.x = 16f/16;
        vertex4.x = 16f/16;
        glClear(GL_COLOR_BUFFER_BIT);
    }
}
