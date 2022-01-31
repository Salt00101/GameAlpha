package com.salt.Game.Render;

import com.salt.Game.Vector.Vector2;
import com.salt.Game.Vector.Vector3;

import static org.lwjgl.opengl.GL11.*;

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
        if ((vertex1.y < 1 && (vertex4.y + distanceY) < 1) && type == GL_QUADS) {
            vertex1.y += 0.01;
            vertex2.y += 0.01;
            vertex3.y += 0.01;
            vertex4.y += 0.01;
        } if ((vertex1.y < 1 && (vertex4.y + distanceY) < 1) && type == GL_TRIANGLES) {
            vertex1.y += 0.01;
            vertex2.y += 0.01;
            vertex3.y += 0.01;
        }
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void down() {
        glClear(GL_COLOR_BUFFER_BIT);
        if ((vertex4.y > -1 && (vertex1.y - distanceY) > -1) && type == GL_QUADS) {
            vertex1.y -= 0.01;
            vertex2.y -= 0.01;
            vertex3.y -= 0.01;
            vertex4.y -= 0.01;
        } if ((vertex4.y > -1 && (vertex1.y - distanceY) > -1) && type == GL_TRIANGLES) {
            vertex1.y -= 0.01;
            vertex2.y -= 0.01;
            vertex3.y -= 0.01;
        }
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void left() {
        glClear(GL_COLOR_BUFFER_BIT);
        if ((vertex1.x > -1 && (vertex2.x - distanceX) > -1) && type == GL_QUADS) {
            vertex1.x -= 0.01;
            vertex2.x -= 0.01;
            vertex3.x -= 0.01;
            vertex4.x -= 0.01;
        } if ((vertex1.y > -1 && (vertex2.y - distanceY) > -1) && type == GL_TRIANGLES) {
            vertex1.x -= 0.01;
            vertex2.x -= 0.01;
            vertex3.x -= 0.01;
        }
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void right() {
        glClear(GL_COLOR_BUFFER_BIT);
        if ((vertex2.x < 1 && (vertex1.x + distanceX) < 1) && type == GL_QUADS) {
            vertex1.x += 0.01;
            vertex2.x += 0.01;
            vertex3.x += 0.01;
            vertex4.x += 0.01;
        } if ((vertex2.y < 1 && (vertex1.y + distanceY) < 1) && type == GL_TRIANGLES) {
            vertex1.x += 0.01;
            vertex2.x += 0.01;
            vertex3.x += 0.01;
        }
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void upRight() {
        glClear(GL_COLOR_BUFFER_BIT);
        if ((vertex1.y < 1 && (vertex4.y + distanceY) < 1) && (vertex2.x < 1 && (vertex1.x + distanceX) < 1) && type == GL_QUADS) {
            vertex1.y += 0.0001;
            vertex2.y += 0.0001;
            vertex3.y += 0.0001;
            vertex4.y += 0.0001;
            vertex1.x += 0.0001;
            vertex2.x += 0.0001;
            vertex3.x += 0.0001;
            vertex4.x += 0.0001;
        } if ((vertex1.y < 1 && (vertex4.y + distanceY) < 1) && (vertex2.y < 1 && (vertex1.y + distanceY) < 1) && type == GL_TRIANGLES) {
            vertex1.y += 0.0001;
            vertex2.y += 0.0001;
            vertex3.y += 0.0001;
            vertex1.x += 0.0001;
            vertex2.x += 0.0001;
            vertex3.x += 0.0001;
        }
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void upLeft() {
        glClear(GL_COLOR_BUFFER_BIT);
        if ((vertex1.y < 1 && (vertex4.y + distanceY) < 1) && (vertex1.x > -1 && (vertex2.x - distanceX) > -1) && type == GL_QUADS) {
            vertex1.y += 0.0001;
            vertex2.y += 0.0001;
            vertex3.y += 0.0001;
            vertex4.y += 0.0001;
            vertex1.x -= 0.0001;
            vertex2.x -= 0.0001;
            vertex3.x -= 0.0001;
            vertex4.x -= 0.0001;
        } if ((vertex1.y < 1 && (vertex4.y + distanceY) < 1) && (vertex1.x > -1 && (vertex2.x - distanceX) > -1) && type == GL_TRIANGLES) {
            vertex1.y += 0.0001;
            vertex2.y += 0.0001;
            vertex3.y += 0.0001;
            vertex1.x -= 0.0001;
            vertex2.x -= 0.0001;
            vertex3.x -= 0.0001;
        }
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void downRight() {
        glClear(GL_COLOR_BUFFER_BIT);
        if ((vertex4.y > -1 && (vertex1.y - distanceY) > -1) && (vertex2.x < 1 && (vertex1.x + distanceX) < 1) && type == GL_QUADS) {
            vertex1.y -= 0.0001;
            vertex2.y -= 0.0001;
            vertex3.y -= 0.0001;
            vertex4.y -= 0.0001;
            vertex1.x += 0.0001;
            vertex2.x += 0.0001;
            vertex3.x += 0.0001;
            vertex4.x += 0.0001;
        } if ((vertex4.y > -1 && (vertex1.y - distanceY) > -1) && (vertex2.y < 1 && (vertex1.y + distanceY) < 1) && type == GL_TRIANGLES) {
            vertex1.y -= 0.0001;
            vertex2.y -= 0.0001;
            vertex3.y -= 0.0001;
            vertex1.x += 0.0001;
            vertex2.x += 0.0001;
            vertex3.x += 0.0001;
        }
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void downLeft() {
        glClear(GL_COLOR_BUFFER_BIT);
        if ((vertex4.y > -1 && (vertex1.y - distanceY) > -1) && (vertex1.x > -1 && (vertex2.x - distanceX) > -1) && type == GL_QUADS) {
            vertex1.y -= 0.0001;
            vertex2.y -= 0.0001;
            vertex3.y -= 0.0001;
            vertex4.y -= 0.0001;
            vertex1.x -= 0.0001;
            vertex2.x -= 0.0001;
            vertex3.x -= 0.0001;
            vertex4.x -= 0.0001;
        } if ((vertex4.y > -1 && (vertex1.y - distanceY) > -1) && (vertex1.x > -1 && (vertex2.x - distanceX) > -1) && type == GL_TRIANGLES) {
            vertex1.y -= 0.0001;
            vertex2.y -= 0.0001;
            vertex3.y -= 0.0001;
            vertex1.x -= 0.0001;
            vertex2.x -= 0.0001;
            vertex3.x -= 0.0001;
        }
        glClear(GL_COLOR_BUFFER_BIT);
    }
}
