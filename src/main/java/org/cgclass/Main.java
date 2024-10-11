package org.cgclass;

import static org.lwjgl.opengl.GL45.*;

public class Main {
    public static void main(String[] args) {

        float[] vertices = {
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.0f, 0.5f, 0.0f
        };

        GraphicContext context = new GraphicContext(800, 600, "Hello OpenGL", Platform.Linux);

        int VAO = glGenVertexArrays();
        glBindVertexArray(VAO);

        int VBO = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, VBO);
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        glVertexAttribPointer(0, 3, GL_FLOAT, false, 3 * Float.BYTES, 0);
        glEnableVertexAttribArray(0);

        glBindVertexArray(0);

        while (!context.isCloseRequested()) {
            context.clear();

            // Draw calls here
            glBindVertexArray(VAO);
            glDrawArrays(GL_TRIANGLES, 0, 3);
            glBindVertexArray(0);

            context.swapBuffers();
            context.pollEvents();
        }
    }
}