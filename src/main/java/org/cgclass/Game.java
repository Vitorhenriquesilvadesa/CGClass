package org.cgclass;

import org.gear.framework.application.Application;
import org.gear.framework.core.service.event.reactive.Reactive;

import static org.lwjgl.opengl.GL45.*;

public class Game extends Application {

    float[] vertices = {
            -0.5f, -0.5f, 0.0f,
            0.5f, -0.5f, 0.0f,
            0.0f, 0.5f, 0.0f
    };

    GraphicContext context = new GraphicContext(800, 600, "Hello OpenGL", Platform.Linux);
    int VAO;
    int VBO;

    @Override
    public void start() {
        VAO = glGenVertexArrays();
        glBindVertexArray(VAO);

        VBO = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, VBO);
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        glVertexAttribPointer(0, 3, GL_FLOAT, false, 3 * Float.BYTES, 0);
        glEnableVertexAttribArray(0);

        glBindVertexArray(0);
    }

    @Override
    public void update() {
        Application.dispatchEvent(new RecompileShaderEvent());

        context.clear();

        // Draw calls here
        glBindVertexArray(VAO);
        glDrawArrays(GL_TRIANGLES, 0, 3);
        glBindVertexArray(0);

        context.swapBuffers();
        context.pollEvents();

        if (context.isCloseRequested()) {
            shutdown();
        }
    }

    @Reactive
    public void onRecompileShaderRequest(RecompileShaderEvent event) {
    }
}
